package tictactoe.popupwin;

import clientconnection.ClientConnection;
import static clientconnection.ClientConnection.ois;
import static clientconnection.ClientConnection.oos;
import static clientconnection.ClientConnection.startListeningThread;
import static clientconnection.ClientConnection.user;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import static clientconnection.ClientConnection.user;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import models.ComputerPlayer;
import models.DataModel;
import models.GameModel;
import models.Player;
import records.SaveGame;
import shared.AppFunctions;
import static shared.AppFunctions.stages;
import shared.AppString;
import tictactoe.gameboard.GameBoardController;
import tictactoe.homescreen.FXMLHomeScreenController;
import tictactoe.onlinegmaeboard.OnlineGameBoardController;
import tictactoe.popupwin.FXMLPopUpWinBase;

public class FXMLPopUpWinController extends FXMLPopUpWinBase {

    Stage stage;
    Player playerOne;
    Player playerTwo;
    MediaPlayer mediaPlayer;
    String mode;
    boolean isRivalExist;

    public FXMLPopUpWinController(Stage stage, String roundState, Player playerOne, Player playerTwo, String mode) {
        this.stage = stage;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.mode = mode;
        isRivalExist = true;
        System.out.println("Round State string : " + roundState);
        showPopup(roundState, mode);
        if (mode.equals("online")) {
            new Thread(() -> {
                DataModel data = new DataModel();
                {
                    try {
                        data = (DataModel) ois.readObject();
                        System.out.println(data.getResponse());
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String response = data.getResponse();
                    switch (response) {
                        case "GAME_REQUEST":
                            Platform.runLater(() -> {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setContentText("Do you want to play again?");
                                alert.getButtonTypes().setAll(new ButtonType("Accept"), new ButtonType("Decline"));

                                Optional<ButtonType> result = alert.showAndWait();
                                if (result.isPresent() && result.get().getText().equals("Accept")) {
                                    stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
                                    System.out.println("User accepted.");
                                    DataModel newData = new DataModel(6, user.getName(), ClientConnection.rival);
                                    newData.setResponse("GAME_ACCEPTED");
                                    try {
                                        oos.writeObject(newData);
                                        oos.flush();
                                        AppFunctions.goToGameBoard(stage, new OnlineGameBoardController(stage, ClientConnection.rival, user.getName(), mode));
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    System.out.println("User declined.");
                                    DataModel newData = new DataModel(6, user.getName(), ClientConnection.rival);
                                    newData.setResponse("GAME_DECLINED");
                                    try {
                                        oos.writeObject(newData);
                                        oos.flush();
                                    } catch (IOException ex) {
                                        Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    isRivalExist = false;
                                    //AppFunctions.closeAndGo(actionEvent, stage, new FXMLHomeScreenController(stage));
                                    startListeningThread();
                                };
                            });
                            break;
                        case "GAME_ACCEPTED":
                            System.out.println("GAME_ACCEPTED");
                            Platform.runLater(() -> {
                                AppFunctions.goToGameBoard(stage, new OnlineGameBoardController(stage, user.getName(), ClientConnection.rival, mode));
                                    stages.get(stages.size()-1).fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
                            });
                            break;
                        case "GAME_DECLINED":
                            System.out.println("GAME_DECLINED");
                            Platform.runLater(() -> {
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Your request was declined");
                                alert.showAndWait();
                                isRivalExist = false;
//                            AppFunctions.closeAndGo(actionEvent, stage, new FXMLHomeScreenController(stage));                           
                            });
                            startListeningThread();
                            break;
                        case "GAME_ENDED":
                            isRivalExist = false;
                            DataModel newData = new DataModel(6, user.getName(), ClientConnection.rival);
                            newData.setResponse("YES_ENDED");
                            try {
                                System.out.println("GAME_ENDED");
                                oos.writeObject(newData);
                                oos.flush();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            startListeningThread();
                            break;
                        case "YES_ENDED":
                            isRivalExist = false;
                            System.out.println("yes ended");
                            startListeningThread();
                            break;
                    }
                }
            }).start();
        }

    }

    private void showPopup(String roundState, String mode) {

        if (roundState.equals("draw")) {
            displayDraw();
            return;
        }
        switch (mode) {

            case "local": {

                if (roundState.equals("X")) {
                    displayWin(playerOne.getName());
                    break;
                } else {
                    displayWin(playerTwo.getName());
                    break;
                }

            }
            case "computer": {

                if (roundState.equals("computer")) {
                    displayLose();
                    break;
                } else {
                    displayWin(playerOne.getName());
                    break;
                }
            }
            case "online": {

                if (roundState.equals("X")) {
                    if (playerOne.getName().equals(user.getName())) {
                        user.updateUserData(true);
                        displayWin(playerOne.getName());

                    } else {
                        displayLose();
                        user.updateUserData(false);

                    }
                    break;
                } else {

                    if (playerTwo.getName().equals(user.getName())) {
                        user.updateUserData(true);
                        displayWin(playerTwo.getName());
                    } else {
                        displayLose();
                        user.updateUserData(false);

                    }
                    break;
                }

            }

        }
    }

    private void displayWin(String playerName) {
        System.out.println("RWinnner is === " + playerName);
        winAndLoseLabel.setStyle("-fx-text-fill: #21bd5c;");
        winAndLoseLabel.setText(playerName + " Win!");
        congratsLable.setText(AppString.CONGRATS);
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

        Media loadVideo = new Media(this.getClass().getResource(AppString.WIN_VIDEO_URL).toExternalForm());
        mediaPlayer = new MediaPlayer(loadVideo);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
        winOrLoseVideo.setMediaPlayer(mediaPlayer);
    }

    private void displayLose() {

        winAndLoseLabel.setStyle("-fx-text-fill: #99003d;");
        winAndLoseLabel.setText("You Lost!");
        congratsLable.setText("OH NOOO!!");
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/gameOver.png").toExternalForm()));

        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.DRAW_VIDEO_URL).toExternalForm()));
        winOrLoseVideo.setMediaPlayer(mediaPlayer);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

    }

    private void displayDraw() {
        winAndLoseLabel.setText("It's DRAW ");
        congratsLable.setText("OH No Winner!");
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/draw.png").toExternalForm()));
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/draw.png").toExternalForm()));

        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(AppString.DRAW_VIDEO_URL).toExternalForm()));
        winOrLoseVideo.setMediaPlayer(mediaPlayer);

        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();

    }

    @Override
    protected void handleSaveGameButton(ActionEvent actionEvent) {
        SaveGame.saveGameToFile(GameBoardController.gameModel);
        mediaPlayer.pause();

    }

    @Override
    protected void handlePlayAgainButton(ActionEvent actionEvent
    ) {
        mediaPlayer.pause();
        if (mode.equals("online")) {
            if (isRivalExist) {
                DataModel data = new DataModel(6, user.getName(), ClientConnection.rival);
                data.setResponse("GAME_REQUEST");
                try {
                    System.out.println("GAME_REQUESTadddd");
                    oos.writeObject(data);
                    oos.flush();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Your rival Ended the game");
                    alert.showAndWait();
                });
            }

            //AppFunctions.closeAndGo(actionEvent, stage, new OnlineGameBoardController(stage, playerOne.getName(), playerTwo.getName(), mode));
        } else {
            AppFunctions.closeAndGo(actionEvent, stage, new GameBoardController(stage, playerOne.getName(), playerTwo.getName(), mode));
        }

    }

    @Override
    protected void handleLeaveButton(ActionEvent actionEvent) {
        mediaPlayer.pause();       
        if (mode.equals("online") && isRivalExist) {
            DataModel data = new DataModel(6, user.getName(), ClientConnection.rival);
            data.setResponse("GAME_ENDED");
            try {
                System.out.println("LEave btn pressed");
                oos.writeObject(data);
                oos.flush();
            } catch (IOException ex) {
                Logger.getLogger(FXMLPopUpWinController.class.getName()).log(Level.SEVERE, null, ex);
            }
            AppFunctions.closeAndGo(actionEvent, stage, new FXMLHomeScreenController(stage));
        } else {
            AppFunctions.closeAndGo(actionEvent, stage, new FXMLHomeScreenController(stage));
        }       
    }

}
