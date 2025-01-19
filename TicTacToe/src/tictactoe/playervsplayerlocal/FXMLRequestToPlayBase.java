package tictactoe.playervsplayerlocal;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public abstract class FXMLRequestToPlayBase extends BorderPane {

    protected final HBox hBox;
    protected final Button acceptBtn;
    protected final Button declineBtn;
    protected final HBox hBox0;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Line line;
    protected final HBox hBox1;
    protected final AnchorPane anchorPane0;
    protected final ImageView imageView;
    protected final Label playerNameLabel;
    protected final Label label0;
    protected final Label label1;
    protected final Label scoreLabel;

    public FXMLRequestToPlayBase() {

        hBox = new HBox();
        acceptBtn = new Button();
        declineBtn = new Button();
        hBox0 = new HBox();
        anchorPane = new AnchorPane();
        label = new Label();
        line = new Line();
        hBox1 = new HBox();
        anchorPane0 = new AnchorPane();
        imageView = new ImageView();
        playerNameLabel = new Label();
        label0 = new Label();
        label1 = new Label();
        scoreLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(300.0);
        setPrefWidth(468.0);
        getStylesheets().add("/styling/generalStyle.css");

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setSpacing(100.0);

        acceptBtn.setId("accept-button");
        acceptBtn.setMnemonicParsing(false);
        acceptBtn.setOnAction(this::handleAcceptButton);
        acceptBtn.setStyle("-fx-background-color: green;");
        acceptBtn.setText("Accept");

        declineBtn.setId("decline-button");
        declineBtn.setMnemonicParsing(false);
        declineBtn.setOnAction(this::handleDeclineButton);
        declineBtn.setStyle("-fx-background-color: red;");
        declineBtn.setText("Decline");
        BorderPane.setMargin(hBox, new Insets(0.0, 0.0, 20.0, 0.0));
        setBottom(hBox);

        BorderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);

        anchorPane.setPrefHeight(65.0);
        anchorPane.setPrefWidth(467.0);

        label.setId("title");
        label.setLayoutX(144.0);
        label.setLayoutY(8.0);
        label.setText("Game Invitation");
        label.setFont(new Font(36.0));
        label.setOpaqueInsets(new Insets(0.0));

        line.setEndX(459.5);
        line.setLayoutX(14.0);
        line.setLayoutY(57.0);
        line.setStartX(-100.0);
        setTop(hBox0);

        BorderPane.setAlignment(hBox1, javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(24.0);
        imageView.setLayoutY(54.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/icons/invite.png").toExternalForm()));

        playerNameLabel.setLayoutX(150.0);
        playerNameLabel.setLayoutY(14.0);
        playerNameLabel.setText("palyer_Name");

        label0.setLayoutX(96.0);
        label0.setLayoutY(107.0);
        label0.setPrefHeight(35.0);
        label0.setPrefWidth(340.0);
        label0.getStylesheets().add("/styling/generalStyle.css");
        label0.setText("Invite You To Play With Him");
        label0.setFont(new Font(24.0));

        label1.setLayoutX(178.0);
        label1.setLayoutY(55.0);
        label1.setText("Score: ");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        scoreLabel.setLayoutX(252.0);
        scoreLabel.setLayoutY(55.0);
        scoreLabel.setText("0");
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#43a39c"));
        setCenter(hBox1);

        hBox.getChildren().add(acceptBtn);
        hBox.getChildren().add(declineBtn);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(line);
        hBox0.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(imageView);
        anchorPane0.getChildren().add(playerNameLabel);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(label1);
        anchorPane0.getChildren().add(scoreLabel);
        hBox1.getChildren().add(anchorPane0);

    }

    protected abstract void handleAcceptButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleDeclineButton(javafx.event.ActionEvent actionEvent);

}
