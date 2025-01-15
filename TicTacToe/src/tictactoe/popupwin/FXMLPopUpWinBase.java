package tictactoe.popupwin;

import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public abstract class FXMLPopUpWinBase extends VBox {

    protected final StackPane stackPane;
    protected final Rectangle rectangle;
    protected final HBox hBox;
    protected final ImageView leftCupIcon;
    protected final VBox vBox;
    protected final Label congratsLable;
    protected final Label winAndLoseLabel;
    protected final ImageView rightCupIcon;
    protected final MediaView winOrLoseVideo;
    protected final HBox hBox0;
    protected final Button saveGameButton;
    protected final ImageView imageView;
    protected final Button playAgainButton;
    protected final ImageView imageView0;
    protected final Button leaveButton;
    protected final ImageView imageView1;

    public FXMLPopUpWinBase() {

        stackPane = new StackPane();
        rectangle = new Rectangle();
        hBox = new HBox();
        leftCupIcon = new ImageView();
        vBox = new VBox();
        congratsLable = new Label();
        winAndLoseLabel = new Label();
        rightCupIcon = new ImageView();
        winOrLoseVideo = new MediaView();
        hBox0 = new HBox();
        saveGameButton = new Button();
        imageView = new ImageView();
        playAgainButton = new Button();
        imageView0 = new ImageView();
        leaveButton = new Button();
        imageView1 = new ImageView();

        setAlignment(javafx.geometry.Pos.CENTER);
        setSpacing(20.0);
        setStyle("-fx-background-color: #f5efe7;");

        stackPane.setStyle("-fx-background-color: transparent;");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#f5efe7"));
        rectangle.setHeight(84.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#88f5e6"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.getStyleClass().add("rect");
        rectangle.setWidth(613.0);

        hBox.setAlignment(javafx.geometry.Pos.CENTER);

        leftCupIcon.setFitHeight(62.0);
        leftCupIcon.setFitWidth(62.0);
        leftCupIcon.setPickOnBounds(true);
        leftCupIcon.setPreserveRatio(true);
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

        vBox.setAlignment(javafx.geometry.Pos.CENTER);

        congratsLable.setAlignment(javafx.geometry.Pos.CENTER);
        congratsLable.setPrefHeight(30.0);
        congratsLable.setPrefWidth(301.0);
        congratsLable.setText("? Congratulations! ?");
        congratsLable.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        congratsLable.setWrapText(true);
        congratsLable.setFont(new Font("Stencil", 24.0));

        winAndLoseLabel.setAlignment(javafx.geometry.Pos.CENTER);
        winAndLoseLabel.setText("You Win!");
        winAndLoseLabel.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        winAndLoseLabel.setFont(new Font("Stencil", 24.0));

        rightCupIcon.setFitHeight(62.0);
        rightCupIcon.setFitWidth(62.0);
        rightCupIcon.setPickOnBounds(true);
        rightCupIcon.setPreserveRatio(true);
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

        winOrLoseVideo.setFitHeight(250.0);
        winOrLoseVideo.setFitWidth(430.0);
        winOrLoseVideo.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setSpacing(30.0);
        hBox0.setStyle("-fx-background-color: transparent;");

        saveGameButton.setMnemonicParsing(false);
        saveGameButton.setOnAction(this::handleSaveGameButton);
        saveGameButton.setStyle("-fx-background-radius: 50;");

        imageView.setFitHeight(30.0);
        imageView.setFitWidth(30.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/icons/save.png").toExternalForm()));
        saveGameButton.setGraphic(imageView);

        playAgainButton.setLayoutX(10.0);
        playAgainButton.setLayoutY(10.0);
        playAgainButton.setMnemonicParsing(false);
        playAgainButton.setOnAction(this::handlePlayAgainButton);
        playAgainButton.setStyle("-fx-background-radius: 50;");

        imageView0.setFitHeight(30.0);
        imageView0.setFitWidth(30.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/assets/icons/Refresh.png").toExternalForm()));
        playAgainButton.setGraphic(imageView0);

        leaveButton.setLayoutX(66.0);
        leaveButton.setLayoutY(10.0);
        leaveButton.setMnemonicParsing(false);
        leaveButton.setOnAction(this::handleLeaveButton);
        leaveButton.setStyle("-fx-background-radius: 50;");

        imageView1.setFitHeight(30.0);
        imageView1.setFitWidth(30.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/assets/icons/cancel.png").toExternalForm()));
        leaveButton.setGraphic(imageView1);
        VBox.setMargin(hBox0, new Insets(0.0, 0.0, 10.0, 0.0));
        getStylesheets().add("/tictactoe/popupwin/fxmlpopupwin.css");
        getStylesheets().add("/styling/generalStyle.css");

        stackPane.getChildren().add(rectangle);
        hBox.getChildren().add(leftCupIcon);
        vBox.getChildren().add(congratsLable);
        vBox.getChildren().add(winAndLoseLabel);
        hBox.getChildren().add(vBox);
        hBox.getChildren().add(rightCupIcon);
        stackPane.getChildren().add(hBox);
        getChildren().add(stackPane);
        getChildren().add(winOrLoseVideo);
        hBox0.getChildren().add(saveGameButton);
        hBox0.getChildren().add(playAgainButton);
        hBox0.getChildren().add(leaveButton);
        getChildren().add(hBox0);

    }

    protected abstract void handleSaveGameButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handlePlayAgainButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleLeaveButton(javafx.event.ActionEvent actionEvent);

}
