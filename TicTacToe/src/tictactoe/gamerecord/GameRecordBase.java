package tictactoe.gamerecord;

import java.lang.String;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public abstract class GameRecordBase extends BorderPane {

    protected final HBox hBox;
    protected final Button prevBtn;
    protected final Button nextBtn;
    protected final VBox vBox;
    protected final HBox hBox0;
    protected final Label label;
    protected final Label playerOneLabel;
    protected final Button exitBtn;
    protected final HBox hBox1;
    protected final Label label0;
    protected final Label playerTwoLabel;
    protected final AnchorPane anchorPane;
    protected final GridPane grid;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button b22;
    protected final Button b20;
    protected final Button b12;
    protected final Button b02;
    protected final Button b21;
    protected final Button b01;
    protected final Button b10;
    protected final Button b11;
    protected final Button b00;

    public GameRecordBase() {

        hBox = new HBox();
        prevBtn = new Button();
        nextBtn = new Button();
        vBox = new VBox();
        hBox0 = new HBox();
        label = new Label();
        playerOneLabel = new Label();
        exitBtn = new Button();
        hBox1 = new HBox();
        label0 = new Label();
        playerTwoLabel = new Label();
        anchorPane = new AnchorPane();
        grid = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        b22 = new Button();
        b20 = new Button();
        b12 = new Button();
        b02 = new Button();
        b21 = new Button();
        b01 = new Button();
        b10 = new Button();
        b11 = new Button();
        b00 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(450.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(70.0);
        BorderPane.setMargin(hBox, new Insets(20.0, 20.0, 0.0, 20.0));

        prevBtn.setMnemonicParsing(false);
        prevBtn.setOnAction(this::handlePreviousBtn);
        prevBtn.setPrefHeight(47.0);
        prevBtn.setPrefWidth(90.0);
        prevBtn.setText("Previous");
        prevBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        HBox.setMargin(prevBtn, new Insets(0.0, 0.0, 0.0, 30.0));

        nextBtn.setLayoutX(260.0);
        nextBtn.setLayoutY(10.0);
        nextBtn.setMnemonicParsing(false);
        nextBtn.setOnAction(this::handleNextBtn);
        nextBtn.setPrefHeight(47.0);
        nextBtn.setPrefWidth(90.0);
        nextBtn.setText("Next");
        nextBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        HBox.setMargin(nextBtn, new Insets(0.0, 0.0, 0.0, 150.0));
        setBottom(hBox);

        hBox0.setSpacing(15.0);

        label.setLayoutX(10.0);
        label.setLayoutY(10.0);
        label.setText("O");

        playerOneLabel.setText("Player1Name");

        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::handleExitButton);
        exitBtn.setPrefHeight(47.0);
        exitBtn.setPrefWidth(20.0);
        exitBtn.setStyle("-fx-background-radius: 100;");
        exitBtn.setText("B");
        exitBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        HBox.setMargin(exitBtn, new Insets(0.0, 0.0, 0.0, 150.0));

        hBox1.setSpacing(15.0);

        label0.setLayoutX(10.0);
        label0.setLayoutY(10.0);
        label0.setText("X");

        playerTwoLabel.setText("Player2Name");
        vBox.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        setTop(vBox);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(100.0);
        anchorPane.setPrefWidth(100.0);

        AnchorPane.setBottomAnchor(grid, 0.0);
        AnchorPane.setLeftAnchor(grid, 0.0);
        AnchorPane.setRightAnchor(grid, 0.0);
        AnchorPane.setTopAnchor(grid, 0.0);
        grid.setLayoutX(23.0);
        grid.setLayoutY(108.0);
        grid.setPrefHeight(449.0);
        grid.setPrefWidth(560.0);
        grid.getStyleClass().add("grid-pane-record");

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

        GridPane.setColumnIndex(b22, 2);
        GridPane.setRowIndex(b22, 2);
        b22.setMnemonicParsing(false);
        b22.setStyle("-fx-border-radius: 0;");

        GridPane.setColumnIndex(b20, 2);
        b20.setLayoutX(10.0);
        b20.setLayoutY(10.0);
        b20.setMnemonicParsing(false);
        b20.setStyle("-fx-border-radius: 0;");

        GridPane.setColumnIndex(b12, 1);
        GridPane.setRowIndex(b12, 2);
        b12.setLayoutX(177.0);
        b12.setLayoutY(10.0);
        b12.setMnemonicParsing(false);
        b12.setStyle("-fx-border-radius: 0 0 0 0;");

        GridPane.setRowIndex(b02, 2);
        b02.setLayoutX(10.0);
        b02.setLayoutY(10.0);
        b02.setMnemonicParsing(false);
        b02.setStyle("-fx-border-radius: 0;");

        GridPane.setColumnIndex(b21, 2);
        GridPane.setRowIndex(b21, 1);
        b21.setLayoutX(10.0);
        b21.setLayoutY(10.0);
        b21.setMnemonicParsing(false);
        b21.setStyle("-fx-border-radius: 0 0 0 0;");

        GridPane.setRowIndex(b01, 1);
        b01.setLayoutX(10.0);
        b01.setLayoutY(10.0);
        b01.setMnemonicParsing(false);
        b01.setStyle("-fx-border-radius: 0;");

        GridPane.setColumnIndex(b10, 1);
        b10.setLayoutX(10.0);
        b10.setLayoutY(10.0);
        b10.setMnemonicParsing(false);
        b10.setStyle("-fx-border-radius: 0;");

        GridPane.setColumnIndex(b11, 1);
        GridPane.setRowIndex(b11, 1);
        b11.setLayoutX(10.0);
        b11.setLayoutY(10.0);
        b11.setMnemonicParsing(false);
        b11.setStyle("-fx-border-radius: 0;");

        b00.setLayoutX(177.0);
        b00.setLayoutY(10.0);
        b00.setMnemonicParsing(false);
        b00.setPrefHeight(153.0);
        b00.setPrefWidth(192.0);
        b00.setStyle("-fx-border-radius: 0;");
        BorderPane.setMargin(anchorPane, new Insets(10.0, 30.0, 0.0, 30.0));
        setCenter(anchorPane);
        getStylesheets().add("/tictactoe/gameboard/style.css");
        getStylesheets().add("/styling/generalStyle.css");

        hBox.getChildren().add(prevBtn);
        hBox.getChildren().add(nextBtn);
        hBox0.getChildren().add(label);
        hBox0.getChildren().add(playerOneLabel);
        hBox0.getChildren().add(exitBtn);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(label0);
        hBox1.getChildren().add(playerTwoLabel);
        vBox.getChildren().add(hBox1);
        grid.getColumnConstraints().add(columnConstraints);
        grid.getColumnConstraints().add(columnConstraints0);
        grid.getColumnConstraints().add(columnConstraints1);
        grid.getRowConstraints().add(rowConstraints);
        grid.getRowConstraints().add(rowConstraints0);
        grid.getRowConstraints().add(rowConstraints1);
        grid.getChildren().add(b22);
        grid.getChildren().add(b20);
        grid.getChildren().add(b12);
        grid.getChildren().add(b02);
        grid.getChildren().add(b21);
        grid.getChildren().add(b01);
        grid.getChildren().add(b10);
        grid.getChildren().add(b11);
        grid.getChildren().add(b00);
        anchorPane.getChildren().add(grid);

    }

    protected abstract void handlePreviousBtn(javafx.event.ActionEvent actionEvent);

    protected abstract void handleNextBtn(javafx.event.ActionEvent actionEvent);

    protected abstract void handleExitButton(javafx.event.ActionEvent actionEvent);

}
