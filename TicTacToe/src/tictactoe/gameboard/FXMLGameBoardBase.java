package tictactoe.gameboard;

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
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public abstract class FXMLGameBoardBase extends BorderPane {

    protected final HBox hBox;
    protected final Region region;
    protected final Label timer;
    protected final Region region0;
    protected final VBox vBox;
    protected final Button leaveButton;
    protected final HBox hBox0;
    protected final Label playerOneLabel;
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

    public FXMLGameBoardBase() {

        hBox = new HBox();
        region = new Region();
        timer = new Label();
        region0 = new Region();
        vBox = new VBox();
        leaveButton = new Button();
        hBox0 = new HBox();
        playerOneLabel = new Label();
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
        setPrefHeight(720.0);
        setPrefWidth(720.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(70.0);
        BorderPane.setMargin(hBox, new Insets(0.0, 20.0, 0.0, 20.0));

        region.setPrefHeight(70.0);
        region.setPrefWidth(250.0);

        timer.setPrefHeight(70.0);
        timer.setPrefWidth(216.0);
        timer.setText("  Start  ");
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
        setBottom(hBox);

        BorderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);
        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(73.0);
        hBox0.setSpacing(50.0);
        BorderPane.setMargin(hBox0, new Insets(0.0, 20.0, 0.0, 20.0));

        playerOneLabel.setText("Player1Name");

        playerTwoLabel.setLayoutX(10.0);
        playerTwoLabel.setLayoutY(10.0);
        playerTwoLabel.setText("Player2Name");
        setTop(hBox0);
        getStylesheets().add("/styling/generalStyle.css");
        getStylesheets().add("/tictactoe/gameboard/style.css");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(400.0);
        anchorPane.setPrefWidth(400.0);

        AnchorPane.setBottomAnchor(grid, 50.0);
        AnchorPane.setLeftAnchor(grid, 50.0);
        AnchorPane.setRightAnchor(grid, 50.0);
        AnchorPane.setTopAnchor(grid, 50.0);
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

        GridPane.setColumnIndex(b22, 2);
        GridPane.setRowIndex(b22, 2);
        b22.setMnemonicParsing(false);
        b22.setOnAction(this::handleB22);
        b22.setStyle("-fx-border-radius: 0 0 30 0;");

        GridPane.setColumnIndex(b20, 2);
        b20.setLayoutX(10.0);
        b20.setLayoutY(10.0);
        b20.setMnemonicParsing(false);
        b20.setOnAction(this::handleB20);
        b20.setStyle("-fx-border-radius: 0 30 0 0;");

        GridPane.setColumnIndex(b12, 1);
        GridPane.setRowIndex(b12, 2);
        b12.setLayoutX(177.0);
        b12.setLayoutY(10.0);
        b12.setMnemonicParsing(false);
        b12.setOnAction(this::handleB12);
        b12.setStyle("-fx-border-radius: 0 0 0 0;");

        GridPane.setRowIndex(b02, 2);
        b02.setLayoutX(10.0);
        b02.setLayoutY(10.0);
        b02.setMnemonicParsing(false);
        b02.setOnAction(this::handleB02);
        b02.setStyle("-fx-border-radius: 0 0 0 30;");

        GridPane.setColumnIndex(b21, 2);
        GridPane.setRowIndex(b21, 1);
        b21.setLayoutX(10.0);
        b21.setLayoutY(10.0);
        b21.setMnemonicParsing(false);
        b21.setOnAction(this::handleB21);
        b21.setStyle("-fx-border-radius: 0 0 0 0;");

        GridPane.setRowIndex(b01, 1);
        b01.setLayoutX(10.0);
        b01.setLayoutY(10.0);
        b01.setMnemonicParsing(false);
        b01.setOnAction(this::handleB01);
        b01.setStyle("-fx-border-radius: 0;");

        GridPane.setColumnIndex(b10, 1);
        b10.setLayoutX(10.0);
        b10.setLayoutY(10.0);
        b10.setMnemonicParsing(false);
        b10.setOnAction(this::handleB10);
        b10.setStyle("-fx-border-radius: 0;");

        GridPane.setColumnIndex(b11, 1);
        GridPane.setRowIndex(b11, 1);
        b11.setLayoutX(10.0);
        b11.setLayoutY(10.0);
        b11.setMnemonicParsing(false);
        b11.setOnAction(this::handleB11);
        b11.setStyle("-fx-border-radius: 0;");

        b00.setLayoutX(177.0);
        b00.setLayoutY(10.0);
        b00.setMnemonicParsing(false);
        b00.setOnAction(this::handleB00);
        b00.setPrefHeight(153.0);
        b00.setPrefWidth(192.0);
        b00.setStyle("-fx-border-radius: 30 0 0 0;");
        BorderPane.setMargin(anchorPane, new Insets(0.0, 20.0, 0.0, 20.0));
        setCenter(anchorPane);

        hBox.getChildren().add(region);
        hBox.getChildren().add(timer);
        hBox.getChildren().add(region0);
        vBox.getChildren().add(leaveButton);
        hBox.getChildren().add(vBox);
        hBox0.getChildren().add(playerOneLabel);
        hBox0.getChildren().add(playerTwoLabel);
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

    protected abstract void handleLeaveButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB22(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB20(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB12(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB02(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB21(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB01(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB10(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB11(javafx.event.ActionEvent actionEvent);

    protected abstract void handleB00(javafx.event.ActionEvent actionEvent);

}
