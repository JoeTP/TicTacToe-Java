package tictactoe.playervsplayerlocal;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static shared.AppString.GENERAL_STYLE_FILE_PATH;

public abstract class FXMLPlayerVsPlayerLocalBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final AnchorPane anchorPane0;
    protected final TextField playerOneTextField;
    protected final Label label;
    protected final TextField playerTwoTextField;
    protected final Label label0;
    protected final Button startBtn;
    protected final Text playerVsPlayerLabel;

    public FXMLPlayerVsPlayerLocalBase() {

        anchorPane = new AnchorPane();
        backBtn = new Button();
        anchorPane0 = new AnchorPane();
        playerOneTextField = new TextField();
        label = new Label();
        playerTwoTextField = new TextField();
        label0 = new Label();
        startBtn = new Button();
        playerVsPlayerLabel = new Text();

        setMaxHeight(500.0);
        setMaxWidth(450.0);
        setMinHeight(500.0);
        setMinWidth(450.0);
        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add(GENERAL_STYLE_FILE_PATH);

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
        backBtn.getStyleClass().add("bigBtn");
        backBtn.setText("B");
        setTop(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        playerOneTextField.setLayoutX(92.0);
        playerOneTextField.setLayoutY(129.0);
        playerOneTextField.setPrefHeight(40.0);
        playerOneTextField.setPrefWidth(280.0);
        playerOneTextField.setPromptText("Player 1 name");

        label.setLayoutX(193.0);
        label.setLayoutY(78.0);
        label.getStyleClass().add("bigLabel");
        label.setText("Player 1");
        label.setFont(new Font(24.0));

        playerTwoTextField.setLayoutX(92.0);
        playerTwoTextField.setLayoutY(246.0);
        playerTwoTextField.setPrefHeight(40.0);
        playerTwoTextField.setPrefWidth(280.0);
        playerTwoTextField.setPromptText("Player 2 name");

        label0.setLayoutX(190.0);
        label0.setLayoutY(191.0);
        label0.getStyleClass().add("bigLabel");
        label0.setText("Player 2");
        label0.setFont(new Font(24.0));

        startBtn.setLayoutX(165.0);
        startBtn.setLayoutY(333.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setOnAction(this::openGameBoard);
        startBtn.setPrefHeight(30.0);
        startBtn.setPrefWidth(120.0);
        startBtn.getStyleClass().add("bigBtn");
        startBtn.setText("Start");
        startBtn.setFont(new Font(20.0));

        playerVsPlayerLabel.setFill(javafx.scene.paint.Color.valueOf("#d8c4b6"));
        playerVsPlayerLabel.setLayoutX(151.0);
        playerVsPlayerLabel.setLayoutY(39.0);
        playerVsPlayerLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerVsPlayerLabel.setStrokeWidth(0.0);
        playerVsPlayerLabel.getStyleClass().add("bigLabel");
        playerVsPlayerLabel.setText("Player Vs Player");
        playerVsPlayerLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerVsPlayerLabel.setFont(new Font(36.0));
        setCenter(anchorPane0);

        anchorPane.getChildren().add(backBtn);
        anchorPane0.getChildren().add(playerOneTextField);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(playerTwoTextField);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(startBtn);
        anchorPane0.getChildren().add(playerVsPlayerLabel);

    }

    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

    protected abstract void openGameBoard(javafx.event.ActionEvent actionEvent);

}
