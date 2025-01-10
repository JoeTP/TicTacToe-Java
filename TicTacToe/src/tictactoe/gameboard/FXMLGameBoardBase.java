package tictactoe.gameboard;

import java.lang.String;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public abstract class FXMLGameBoardBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final GridPane grid;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final AnchorPane anchorPane0;
    protected final HBox hBox;
    protected final TextField chatField;
    protected final Button sendButton;
    protected final TextArea chatTextArea;
    protected final Label opName;
    protected final HBox hBox0;
    protected final Region region;
    protected final Label timer;
    protected final Region region0;
    protected final VBox vBox;
    protected final Button leaveButton;
    protected final HBox hBox1;
    protected final Label label;
    protected final Label label0;

    public FXMLGameBoardBase() {

        anchorPane = new AnchorPane();
        grid = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        anchorPane0 = new AnchorPane();
        hBox = new HBox();
        chatField = new TextField();
        sendButton = new Button();
        chatTextArea = new TextArea();
        opName = new Label();
        hBox0 = new HBox();
        region = new Region();
        timer = new Label();
        region0 = new Region();
        vBox = new VBox();
        leaveButton = new Button();
        hBox1 = new HBox();
        label = new Label();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(1000.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(557.0);
        anchorPane.setPrefWidth(605.0);

        AnchorPane.setBottomAnchor(grid, 0.0);
        AnchorPane.setLeftAnchor(grid, 0.0);
        AnchorPane.setRightAnchor(grid, 0.0);
        AnchorPane.setTopAnchor(grid, 0.0);
        grid.setLayoutX(23.0);
        grid.setLayoutY(108.0);
        grid.setPrefHeight(449.0);
        grid.setPrefWidth(560.0);
        grid.getStyleClass().add("grid-pane");

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        BorderPane.setMargin(anchorPane, new Insets(0.0, 0.0, 0.0, 20.0));
        setLeft(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(557.0);
        anchorPane0.setPrefWidth(307.0);
        BorderPane.setMargin(anchorPane0, new Insets(0.0, 20.0, 0.0, 0.0));

        AnchorPane.setBottomAnchor(hBox, 20.0);
        AnchorPane.setLeftAnchor(hBox, 0.0);
        AnchorPane.setRightAnchor(hBox, 0.0);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setLayoutX(21.0);
        hBox.setLayoutY(372.0);
        hBox.setPrefHeight(47.0);
        hBox.setPrefWidth(304.0);
        hBox.setSpacing(20.0);

        chatField.setPrefHeight(36.0);
        chatField.setPrefWidth(257.0);

        sendButton.setMnemonicParsing(false);
        sendButton.setOnAction(this::handleSendButton);
        sendButton.setPrefHeight(47.0);
        sendButton.setPrefWidth(60.0);
        sendButton.setText("Send");

        AnchorPane.setLeftAnchor(chatTextArea, 0.0);
        AnchorPane.setRightAnchor(chatTextArea, 0.0);
        AnchorPane.setTopAnchor(chatTextArea, 56.0);
        chatTextArea.setLayoutY(56.0);
        chatTextArea.setPrefHeight(419.0);
        chatTextArea.setPrefWidth(338.0);

        opName.setLayoutX(147.0);
        opName.setText("Chat");
        setRight(anchorPane0);

        BorderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(70.0);
        BorderPane.setMargin(hBox0, new Insets(0.0, 20.0, 0.0, 20.0));

        region.setPrefHeight(70.0);
        region.setPrefWidth(255.0);

        timer.setPrefHeight(77.0);
        timer.setPrefWidth(74.0);
        timer.setText("Timer");
        timer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        HBox.setHgrow(region0, javafx.scene.layout.Priority.ALWAYS);
        region0.setPrefHeight(70.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);

        leaveButton.setMnemonicParsing(false);
        leaveButton.setOnAction(this::handleLeaveButton);
        leaveButton.setPrefHeight(47.0);
        leaveButton.setPrefWidth(70.0);
        leaveButton.setText("Leave");
        leaveButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        setBottom(hBox0);

        BorderPane.setAlignment(hBox1, javafx.geometry.Pos.CENTER);
        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(73.0);
        hBox1.setSpacing(50.0);
        BorderPane.setMargin(hBox1, new Insets(0.0, 20.0, 0.0, 20.0));

        label.setText("Player1Name");

        label0.setLayoutX(10.0);
        label0.setLayoutY(10.0);
        label0.setText("Player2Name");
        setTop(hBox1);
        getStylesheets().add("/tictactoe/gameboard/../../../resources/styling/generalStyle.css");
        getStylesheets().add("/tictactoe/gameboard/style.css");

        grid.getColumnConstraints().add(columnConstraints);
        grid.getColumnConstraints().add(columnConstraints0);
        grid.getColumnConstraints().add(columnConstraints1);
        grid.getRowConstraints().add(rowConstraints);
        grid.getRowConstraints().add(rowConstraints0);
        grid.getRowConstraints().add(rowConstraints1);
        anchorPane.getChildren().add(grid);
        hBox.getChildren().add(chatField);
        hBox.getChildren().add(sendButton);
        anchorPane0.getChildren().add(hBox);
        anchorPane0.getChildren().add(chatTextArea);
        anchorPane0.getChildren().add(opName);
        hBox0.getChildren().add(region);
        hBox0.getChildren().add(timer);
        hBox0.getChildren().add(region0);
        vBox.getChildren().add(leaveButton);
        hBox0.getChildren().add(vBox);
        hBox1.getChildren().add(label);
        hBox1.getChildren().add(label0);

    }

    protected abstract void handleSendButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleLeaveButton(javafx.event.ActionEvent actionEvent);

}
