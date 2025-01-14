package tictactoe.popupwin;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public abstract class FXMLPopUpWinBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final MediaView winOrLoseVideo;
    protected final ImageView leftCupIcon;
    protected final ImageView rightCupIcon;
    protected final Button rematchBtn;
    protected final ImageView rematchImg;
    protected final Button saveGameBtn;
    protected final ImageView saveGameImg;
    protected final Button leaveBtn;
    protected final ImageView leaveImg;
    protected final Label congratsLable;
    protected final Label label;
    protected final Label scoreLabel;
    protected final Label winAndLoseLabel;

    public FXMLPopUpWinBase() {

        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        winOrLoseVideo = new MediaView();
        leftCupIcon = new ImageView();
        rightCupIcon = new ImageView();
        rematchBtn = new Button();
        rematchImg = new ImageView();
        saveGameBtn = new Button();
        saveGameImg = new ImageView();
        leaveBtn = new Button();
        leaveImg = new ImageView();
        congratsLable = new Label();
        label = new Label();
        scoreLabel = new Label();
        winAndLoseLabel = new Label();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(500.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/tictactoe/popupwin/fxmlpopupwin.css");

        AnchorPane.setLeftAnchor(rectangle, 20.0);
        AnchorPane.setRightAnchor(rectangle, 20.0);
        AnchorPane.setTopAnchor(rectangle, 20.0);
        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#f5efe7"));
        rectangle.setHeight(84.0);
        rectangle.setLayoutX(14.0);
        rectangle.setLayoutY(18.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#88f5e6"));
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.getStyleClass().add("rect");
        rectangle.setWidth(613.0);

        AnchorPane.setBottomAnchor(rectangle0, 20.0);
        AnchorPane.setLeftAnchor(rectangle0, 20.0);
        AnchorPane.setRightAnchor(rectangle0, 20.0);
        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setFill(javafx.scene.paint.Color.valueOf("#f5efe7"));
        rectangle0.setHeight(93.0);
        rectangle0.setLayoutX(47.0);
        rectangle0.setLayoutY(384.0);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#88f5e6"));
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.getStyleClass().add("rect");
        rectangle0.setWidth(613.0);

        winOrLoseVideo.setFitHeight(250.0);
        winOrLoseVideo.setFitWidth(430.0);
        winOrLoseVideo.setLayoutX(115.0);
        winOrLoseVideo.setLayoutY(120.0);
        winOrLoseVideo.setNodeOrientation(javafx.geometry.NodeOrientation.INHERIT);

        AnchorPane.setLeftAnchor(leftCupIcon, 70.0);
        leftCupIcon.setFitHeight(62.0);
        leftCupIcon.setFitWidth(62.0);
        leftCupIcon.setLayoutX(89.0);
        leftCupIcon.setLayoutY(22.0);
        leftCupIcon.setPickOnBounds(true);
        leftCupIcon.setPreserveRatio(true);
        leftCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

        AnchorPane.setRightAnchor(rightCupIcon, 70.0);
        rightCupIcon.setFitHeight(62.0);
        rightCupIcon.setFitWidth(62.0);
        rightCupIcon.setLayoutX(527.0);
        rightCupIcon.setLayoutY(27.0);
        rightCupIcon.setPickOnBounds(true);
        rightCupIcon.setPreserveRatio(true);
        rightCupIcon.setImage(new Image(getClass().getResource("/assets/icons/winner.png").toExternalForm()));

        rematchBtn.setLayoutX(287.0);
        rematchBtn.setLayoutY(399.0);
        rematchBtn.setMnemonicParsing(false);
        rematchBtn.setStyle("-fx-background-color: transparent;");

        rematchImg.setFitHeight(40.0);
        rematchImg.setFitWidth(40.0);
        rematchImg.setPickOnBounds(true);
        rematchImg.setPreserveRatio(true);
        rematchImg.setImage(new Image(getClass().getResource("/assets/icons/replay.png").toExternalForm()));
        rematchBtn.setGraphic(rematchImg);

        saveGameBtn.setLayoutX(74.0);
        saveGameBtn.setLayoutY(399.0);
        saveGameBtn.setMnemonicParsing(false);
        saveGameBtn.setStyle("-fx-background-color: transparent;");

        saveGameImg.setFitHeight(40.0);
        saveGameImg.setFitWidth(40.0);
        saveGameImg.setPickOnBounds(true);
        saveGameImg.setPreserveRatio(true);
        saveGameImg.setImage(new Image(getClass().getResource("/assets/icons/save.png").toExternalForm()));
        saveGameBtn.setGraphic(saveGameImg);

        leaveBtn.setLayoutX(530.0);
        leaveBtn.setLayoutY(399.0);
        leaveBtn.setMnemonicParsing(false);
        leaveBtn.setStyle("-fx-background-color: transparent;");
        leaveBtn.setWrapText(true);

        leaveImg.setFitHeight(40.0);
        leaveImg.setFitWidth(40.0);
        leaveImg.setPickOnBounds(true);
        leaveImg.setPreserveRatio(true);
        leaveImg.setImage(new Image(getClass().getResource("/assets/icons/cancel.png").toExternalForm()));
        leaveBtn.setGraphic(leaveImg);

        AnchorPane.setLeftAnchor(congratsLable, 190.0);
        congratsLable.setAlignment(javafx.geometry.Pos.CENTER);
        congratsLable.setLayoutX(190.0);
        congratsLable.setLayoutY(25.0);
        congratsLable.setPrefHeight(30.0);
        congratsLable.setPrefWidth(301.0);
        congratsLable.setText("? Congratulations! ?");
        congratsLable.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        congratsLable.setWrapText(true);
        congratsLable.setFont(new Font("Stencil", 24.0));

        label.setLayoutX(256.0);
        label.setLayoutY(446.0);
        label.setText("Your score:");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        label.setFont(new Font("Stencil", 18.0));

        scoreLabel.setLayoutX(378.0);
        scoreLabel.setLayoutY(447.0);
        scoreLabel.setText("0");
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        scoreLabel.setFont(new Font("Stencil", 18.0));

        winAndLoseLabel.setAlignment(javafx.geometry.Pos.CENTER);
        winAndLoseLabel.setLayoutX(270.0);
        winAndLoseLabel.setLayoutY(55.0);
        winAndLoseLabel.setText("You Win!");
        winAndLoseLabel.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        winAndLoseLabel.setFont(new Font("Stencil", 24.0));

        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(winOrLoseVideo);
        getChildren().add(leftCupIcon);
        getChildren().add(rightCupIcon);
        getChildren().add(rematchBtn);
        getChildren().add(saveGameBtn);
        getChildren().add(leaveBtn);
        getChildren().add(congratsLable);
        getChildren().add(label);
        getChildren().add(scoreLabel);
        getChildren().add(winAndLoseLabel);

    }
}
