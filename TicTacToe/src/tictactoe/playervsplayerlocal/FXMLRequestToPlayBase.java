package tictactoe.playervsplayerlocal;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLRequestToPlayBase extends BorderPane {

    protected final HBox hBox;
    protected final AnchorPane anchorPane;
    protected final Button acceptBtn;
    protected final Button declineBtn;
    protected final HBox hBox0;
    protected final AnchorPane anchorPane0;
    protected final Label label;
    protected final Line line;
    protected final HBox hBox1;
    protected final AnchorPane anchorPane1;
    protected final ImageView imageView;
    protected final Text playerNameTextField;
    protected final Label label0;

    public FXMLRequestToPlayBase() {

        hBox = new HBox();
        anchorPane = new AnchorPane();
        acceptBtn = new Button();
        declineBtn = new Button();
        hBox0 = new HBox();
        anchorPane0 = new AnchorPane();
        label = new Label();
        line = new Line();
        hBox1 = new HBox();
        anchorPane1 = new AnchorPane();
        imageView = new ImageView();
        playerNameTextField = new Text();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(300.0);
        setPrefWidth(468.0);
        getStylesheets().add("/styling/invitationPageStyle.css");

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(63.0);
        hBox.setPrefWidth(500.0);

        acceptBtn.setId("accept-button");
        acceptBtn.setLayoutX(128.0);
        acceptBtn.setLayoutY(-1.0);
        acceptBtn.setMnemonicParsing(false);
        acceptBtn.setText("Accept");

        declineBtn.setId("decline-button");
        declineBtn.setLayoutX(287.0);
        declineBtn.setLayoutY(-1.0);
        declineBtn.setMnemonicParsing(false);
        declineBtn.setText("Decline");
        setBottom(hBox);

        BorderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);

        anchorPane0.setPrefHeight(65.0);
        anchorPane0.setPrefWidth(467.0);

        label.setId("title");
        label.setLayoutX(144.0);
        label.setLayoutY(8.0);
        label.setText("Game Invitation");
        label.setFont(new Font(36.0));

        line.setEndX(459.5);
        line.setLayoutX(14.0);
        line.setLayoutY(57.0);
        line.setStartX(-100.0);
        setTop(hBox0);

        BorderPane.setAlignment(hBox1, javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        anchorPane1.setPrefHeight(200.0);
        anchorPane1.setPrefWidth(200.0);

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(24.0);
        imageView.setLayoutY(54.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/icons/invite.png").toExternalForm()));

        playerNameTextField.setId("player-name");
        playerNameTextField.setLayoutX(166.0);
        playerNameTextField.setLayoutY(58.0);
        playerNameTextField.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerNameTextField.setStrokeWidth(0.0);
        playerNameTextField.setText("palyer_Name");
        playerNameTextField.setFont(new Font("System Bold", 24.0));

        label0.setLayoutX(96.0);
        label0.setLayoutY(107.0);
        label0.setPrefHeight(35.0);
        label0.setPrefWidth(340.0);
        label0.setText("Invite You To Play With Him");
        label0.setFont(new Font(24.0));
        setCenter(hBox1);

        anchorPane.getChildren().add(acceptBtn);
        anchorPane.getChildren().add(declineBtn);
        hBox.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(line);
        hBox0.getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(imageView);
        anchorPane1.getChildren().add(playerNameTextField);
        anchorPane1.getChildren().add(label0);
        hBox1.getChildren().add(anchorPane1);

    }
}
