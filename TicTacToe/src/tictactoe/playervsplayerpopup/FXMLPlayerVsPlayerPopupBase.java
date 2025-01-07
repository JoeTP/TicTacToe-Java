package tictactoe.playervsplayerpopup;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public abstract class FXMLPlayerVsPlayerPopupBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final AnchorPane anchorPane0;
    protected final Button localBtn;
    protected final Label label;
    protected final Button onlineBtn;

    public FXMLPlayerVsPlayerPopupBase() {

        anchorPane = new AnchorPane();
        backBtn = new Button();
        anchorPane0 = new AnchorPane();
        localBtn = new Button();
        label = new Label();
        onlineBtn = new Button();

        setMaxHeight(500.0);
        setMaxWidth(450.0);
        setMinHeight(500.0);
        setMinWidth(450.0);
        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/styling/generalStyle.css");

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

        localBtn.setLayoutX(104.0);
        localBtn.setLayoutY(173.0);
        localBtn.setMnemonicParsing(false);
        localBtn.setOnAction(this::handleLocalButton);
        localBtn.setPrefHeight(44.0);
        localBtn.setPrefWidth(242.0);
        localBtn.getStyleClass().add("bigBtn");
        localBtn.setText("Local");
        localBtn.setFont(new Font(20.0));

        label.setLayoutX(145.0);
        label.setLayoutY(64.0);
        label.setText("Player Vs Player");

        onlineBtn.setLayoutX(104.0);
        onlineBtn.setLayoutY(267.0);
        onlineBtn.setMnemonicParsing(false);
        onlineBtn.setOnAction(this::handleOnlineButton);
        onlineBtn.setPrefHeight(44.0);
        onlineBtn.setPrefWidth(242.0);
        onlineBtn.getStyleClass().add("bigBtn");
        onlineBtn.setText("Online");
        onlineBtn.setFont(new Font(20.0));
        setCenter(anchorPane0);

        anchorPane.getChildren().add(backBtn);
        anchorPane0.getChildren().add(localBtn);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(onlineBtn);

    }

    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleLocalButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleOnlineButton(javafx.event.ActionEvent actionEvent);

}
