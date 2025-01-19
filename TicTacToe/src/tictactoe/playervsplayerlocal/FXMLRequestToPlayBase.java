package tictactoe.playervsplayerlocal;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    protected final VBox vBox;
    protected final Label playerNameLabel;
    protected final HBox hBox2;
    protected final Label label0;
    protected final Label scoreLabel;
    protected final Label label1;

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
        vBox = new VBox();
        playerNameLabel = new Label();
        hBox2 = new HBox();
        label0 = new Label();
        scoreLabel = new Label();
        label1 = new Label();

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

        anchorPane0.setPrefHeight(168.0);
        anchorPane0.setPrefWidth(466.0);

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(64.0);
        imageView.setLayoutX(24.0);
        imageView.setLayoutY(54.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/icons/invite.png").toExternalForm()));

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setLayoutX(118.0);
        vBox.setLayoutY(14.0);

        playerNameLabel.setText("palyer_Name");

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);

        label0.setText("Score: ");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        scoreLabel.setText("0");
        scoreLabel.setTextFill(javafx.scene.paint.Color.valueOf("#43a39c"));

        label1.setPrefHeight(41.0);
        label1.setPrefWidth(267.0);
        label1.getStylesheets().add("/styling/generalStyle.css");
        label1.setText("Invite You To Play With Him");
        label1.setFont(new Font(24.0));
        setCenter(hBox1);

        hBox.getChildren().add(acceptBtn);
        hBox.getChildren().add(declineBtn);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(line);
        hBox0.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(imageView);
        vBox.getChildren().add(playerNameLabel);
        hBox2.getChildren().add(label0);
        hBox2.getChildren().add(scoreLabel);
        vBox.getChildren().add(hBox2);
        vBox.getChildren().add(label1);
        anchorPane0.getChildren().add(vBox);
        hBox1.getChildren().add(anchorPane0);

    }

    protected abstract void handleAcceptButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleDeclineButton(javafx.event.ActionEvent actionEvent);

}
