package tictactoe.popupwin;

import java.net.URL;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public abstract class FXMLPopUpWinBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final ImageView winnerImg;
    protected final ImageView replayBtn;
    protected final ImageView saveVideoBtn;
    protected final ImageView homeBtn;
    protected final Label winAndLoseLabel;
    protected final Label label;
    protected final Label scoreLabel;

    public FXMLPopUpWinBase() {

        rectangle = new Rectangle();
        winnerImg = new ImageView();
        replayBtn = new ImageView();
        saveVideoBtn = new ImageView();
        homeBtn = new ImageView();
        winAndLoseLabel = new Label();
        label = new Label();
        scoreLabel = new Label();

        setId("AnchorPane");
        setPrefHeight(450.0);
        setPrefWidth(450.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/tictactoe/popupwin/fxmlpopupwin.css");

        AnchorPane.setLeftAnchor(rectangle, 50.0);
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#f5efe7"));
        rectangle.setHeight(350.0);
        rectangle.setLayoutX(50.0);
        rectangle.setLayoutY(51.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#88f5e6"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.getStyleClass().add("rect");
        rectangle.setWidth(350.0);

        winnerImg.setFitHeight(50.0);
        winnerImg.setFitWidth(50.0);
        winnerImg.setLayoutX(194.0);
        winnerImg.setLayoutY(91.0);
        winnerImg.setPickOnBounds(true);
        winnerImg.setPreserveRatio(true);
        winnerImg.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

        replayBtn.setFitHeight(30.0);
        replayBtn.setFitWidth(30.0);
        replayBtn.setLayoutX(138.0);
        replayBtn.setLayoutY(268.0);
        replayBtn.setPickOnBounds(true);
        replayBtn.setPreserveRatio(true);
        replayBtn.setImage(new Image(getClass().getResource("/assets/icons/replay.png").toExternalForm()));

        saveVideoBtn.setFitHeight(30.0);
        saveVideoBtn.setFitWidth(30.0);
        saveVideoBtn.setLayoutX(204.0);
        saveVideoBtn.setLayoutY(268.0);
        saveVideoBtn.setPickOnBounds(true);
        saveVideoBtn.setPreserveRatio(true);
        saveVideoBtn.setImage(new Image(getClass().getResource("/assets/icons/save.png").toExternalForm()));

        homeBtn.setFitHeight(30.0);
        homeBtn.setFitWidth(30.0);
        homeBtn.setLayoutX(272.0);
        homeBtn.setLayoutY(268.0);
        homeBtn.setPickOnBounds(true);
        homeBtn.setPreserveRatio(true);
        homeBtn.setImage(new Image(getClass().getResource("/assets/icons/cancel.png").toExternalForm()));

        AnchorPane.setLeftAnchor(winAndLoseLabel, 90.0);
        winAndLoseLabel.setAlignment(javafx.geometry.Pos.CENTER);
        winAndLoseLabel.setLayoutX(90.0);
        winAndLoseLabel.setLayoutY(161.0);
        winAndLoseLabel.setText("? Congratulations! You Win!");
        winAndLoseLabel.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        winAndLoseLabel.setFont(new Font("Stencil", 18.0));

        label.setLayoutX(153.0);
        label.setLayoutY(208.0);
        label.setText("Your score:");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        label.setFont(new Font("Stencil", 15.0));

        scoreLabel.setLayoutX(253.0);
        scoreLabel.setLayoutY(206.0);
        scoreLabel.setText("0");
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        scoreLabel.setFont(new Font("Stencil", 18.0));

        getChildren().add(rectangle);
        getChildren().add(winnerImg);
        getChildren().add(replayBtn);
        getChildren().add(saveVideoBtn);
        getChildren().add(homeBtn);
        getChildren().add(winAndLoseLabel);
        getChildren().add(label);
        getChildren().add(scoreLabel);

    }
}
