package tictactoe.playervsplayerlocal;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLPlayerVsPlayerLocalBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final AnchorPane anchorPane0;
    protected final TextField textField;
    protected final Label label;
    protected final TextField textField0;
    protected final Label label0;
    protected final Button startBtn;
    protected final Text playerVsPlayerLabel;

    public FXMLPlayerVsPlayerLocalBase() {

        anchorPane = new AnchorPane();
        backBtn = new Button();
        anchorPane0 = new AnchorPane();
        textField = new TextField();
        label = new Label();
        textField0 = new TextField();
        label0 = new Label();
        startBtn = new Button();
        playerVsPlayerLabel = new Text();

        setMaxHeight(500.0);
        setMaxWidth(450.0);
        setMinHeight(500.0);
        setMinWidth(450.0);
        setPrefHeight(500.0);
        setPrefWidth(450.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(0.0);
        anchorPane.setPrefWidth(450.0);

        AnchorPane.setLeftAnchor(backBtn, 20.0);
        AnchorPane.setTopAnchor(backBtn, 14.0);
        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(8.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setOnAction(this::handleBackButton);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(30.0);
        backBtn.setStyle("-fx-border-radius: 30px; -fx-background-radius: 30px;");
        backBtn.setText("B");
        setTop(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        textField.setLayoutX(85.0);
        textField.setLayoutY(135.0);
        textField.setPrefHeight(40.0);
        textField.setPrefWidth(280.0);
        textField.setPromptText("Player 1 name");

        label.setLayoutX(183.0);
        label.setLayoutY(100.0);
        label.setText("Player 1");
        label.setFont(new Font(24.0));

        textField0.setLayoutX(85.0);
        textField0.setLayoutY(242.0);
        textField0.setPrefHeight(40.0);
        textField0.setPrefWidth(280.0);
        textField0.setPromptText("Player 2 name");

        label0.setLayoutX(183.0);
        label0.setLayoutY(207.0);
        label0.setText("Player 2");
        label0.setFont(new Font(24.0));

        startBtn.setLayoutX(165.0);
        startBtn.setLayoutY(366.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setPrefHeight(30.0);
        startBtn.setPrefWidth(120.0);
        startBtn.setText("Start");
        startBtn.setFont(new Font(20.0));

        playerVsPlayerLabel.setLayoutX(100.0);
        playerVsPlayerLabel.setLayoutY(45.0);
        playerVsPlayerLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerVsPlayerLabel.setStrokeWidth(0.0);
        playerVsPlayerLabel.setText("Player Vs Player");
        playerVsPlayerLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerVsPlayerLabel.setFont(new Font(36.0));
        setCenter(anchorPane0);

        anchorPane.getChildren().add(backBtn);
        anchorPane0.getChildren().add(textField);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(textField0);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(startBtn);
        anchorPane0.getChildren().add(playerVsPlayerLabel);

    }

    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

}
