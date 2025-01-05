package tictactoe.playervsplayerpopup;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLPlayerVsPlayerPopupBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final AnchorPane anchorPane0;
    protected final Button localBtn;
    protected final Text playerVsPlayerLabel;
    protected final Button onlineBtn;

    public FXMLPlayerVsPlayerPopupBase() {

        anchorPane = new AnchorPane();
        backBtn = new Button();
        anchorPane0 = new AnchorPane();
        localBtn = new Button();
        playerVsPlayerLabel = new Text();
        onlineBtn = new Button();

        setMaxHeight(500.0);
        setMaxWidth(450.0);
        setMinHeight(500.0);
        setMinWidth(450.0);
        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStylesheets().add("/tictactoe/playervsplayerpopup/../onlinegmaeboard/style.css");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(0.0);
        anchorPane.setPrefWidth(450.0);

        AnchorPane.setLeftAnchor(backBtn, 20.0);
        AnchorPane.setTopAnchor(backBtn, 14.0);
        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(8.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(30.0);
        backBtn.setStyle("-fx-border-radius: 30px; -fx-background-radius: 30px;");
        backBtn.setText("B");
        setTop(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        localBtn.setLayoutX(94.0);
        localBtn.setLayoutY(167.0);
        localBtn.setMnemonicParsing(false);
        localBtn.setPrefHeight(44.0);
        localBtn.setPrefWidth(242.0);
        localBtn.getStylesheets().add("/tictactoe/playervsplayerpopup/../onlinegmaeboard/style.css");
        localBtn.setText("Local");
        localBtn.setFont(new Font(20.0));

        playerVsPlayerLabel.setLayoutX(100.0);
        playerVsPlayerLabel.setLayoutY(45.0);
        playerVsPlayerLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerVsPlayerLabel.setStrokeWidth(0.0);
        playerVsPlayerLabel.setText("Player Vs Player");
        playerVsPlayerLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerVsPlayerLabel.setFont(new Font(36.0));

        onlineBtn.setLayoutX(94.0);
        onlineBtn.setLayoutY(288.0);
        onlineBtn.setMnemonicParsing(false);
        onlineBtn.setPrefHeight(44.0);
        onlineBtn.setPrefWidth(242.0);
        onlineBtn.setText("Online");
        onlineBtn.setFont(new Font(20.0));
        setCenter(anchorPane0);

        anchorPane.getChildren().add(backBtn);
        anchorPane0.getChildren().add(localBtn);
        anchorPane0.getChildren().add(playerVsPlayerLabel);
        anchorPane0.getChildren().add(onlineBtn);

    }
}
