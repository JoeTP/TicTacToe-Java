package tictactoe.playervsplayeronline;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLPlayerVsPlayerOnlineBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final AnchorPane anchorPane0;
    protected final Button startBtn;
    protected final Text playerVsPlayerLabel;
    protected final ListView listView;

    public FXMLPlayerVsPlayerOnlineBase() {

        anchorPane = new AnchorPane();
        backBtn = new Button();
        anchorPane0 = new AnchorPane();
        startBtn = new Button();
        playerVsPlayerLabel = new Text();
        listView = new ListView();

        setMaxHeight(500.0);
        setMaxWidth(450.0);
        setMinHeight(500.0);
        setMinWidth(450.0);
        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStylesheets().add("/tictactoe/playervsplayeronline/../onlinegmaeboard/style.css");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(0.0);
        anchorPane.setPrefWidth(450.0);

        AnchorPane.setLeftAnchor(backBtn, 14.0);
        AnchorPane.setTopAnchor(backBtn, 7.0);
        backBtn.setLayoutX(14.0);
        backBtn.setLayoutY(7.0);
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

        startBtn.setLayoutX(131.0);
        startBtn.setLayoutY(367.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setPrefHeight(33.0);
        startBtn.setPrefWidth(188.0);
        startBtn.setText("Send request");
        startBtn.setFont(new Font(20.0));

        playerVsPlayerLabel.setLayoutX(90.0);
        playerVsPlayerLabel.setLayoutY(53.0);
        playerVsPlayerLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerVsPlayerLabel.setStrokeWidth(0.0);
        playerVsPlayerLabel.setText("Player Vs Player");
        playerVsPlayerLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerVsPlayerLabel.setFont(new Font(36.0));

        listView.setLayoutX(37.0);
        listView.setLayoutY(77.0);
        listView.setPrefHeight(248.0);
        listView.setPrefWidth(368.0);
        setCenter(anchorPane0);

        anchorPane.getChildren().add(backBtn);
        anchorPane0.getChildren().add(startBtn);
        anchorPane0.getChildren().add(playerVsPlayerLabel);
        anchorPane0.getChildren().add(listView);

    }

    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

}
