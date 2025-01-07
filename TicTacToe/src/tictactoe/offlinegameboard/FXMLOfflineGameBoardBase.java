package tictactoe.offlinegameboard;

import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Line;

public abstract class FXMLOfflineGameBoardBase extends BorderPane {

    protected final HBox hBox;
    protected final HBox hBox0;
    protected final ImageView player1Img;
    protected final Label player1Label;
    protected final Line line;
    protected final Label player2Label;
    protected final ImageView player2Img;
    protected final Region region;
    protected final HBox hBox1;
    protected final AnchorPane anchorPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button btn00;
    protected final Button btn02;
    protected final Button btn01;
    protected final Button btn10;
    protected final Button btn11;
    protected final Button btn12;
    protected final Button btn20;
    protected final Button btn21;
    protected final Button btn22;
    protected final FlowPane flowPane;
    protected final Label timerLabel;
    protected final Region region0;
    protected final Button leaveBtn;

    public FXMLOfflineGameBoardBase() {

        hBox = new HBox();
        hBox0 = new HBox();
        player1Img = new ImageView();
        player1Label = new Label();
        line = new Line();
        player2Label = new Label();
        player2Img = new ImageView();
        region = new Region();
        hBox1 = new HBox();
        anchorPane = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btn00 = new Button();
        btn02 = new Button();
        btn01 = new Button();
        btn10 = new Button();
        btn11 = new Button();
        btn12 = new Button();
        btn20 = new Button();
        btn21 = new Button();
        btn22 = new Button();
        flowPane = new FlowPane();
        timerLabel = new Label();
        region0 = new Region();
        leaveBtn = new Button();

        setPrefHeight(720.0);
        setPrefWidth(720.0);
        getStyleClass().add("mainBackground");

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(70.0);
        hBox.setPrefWidth(300.0);

        hBox0.setPrefHeight(75.0);
        hBox0.setPrefWidth(459.14);
        hBox0.getStyleClass().add("hbox");

        player1Img.setFitHeight(54.6);
        player1Img.setFitWidth(44.26);
        player1Img.setPickOnBounds(true);
        player1Img.setPreserveRatio(true);

        player1Label.setId("textId");
        player1Label.setText("Player1");
        player1Label.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        line.setEndX(-65.70710754394531);
        line.setEndY(-0.41418302059173584);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#3e5879"));

        player2Label.setId("textId");
        player2Label.setText("Player2");
        player2Label.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        player2Img.setFitHeight(54.6);
        player2Img.setFitWidth(44.26);
        player2Img.setPickOnBounds(true);
        player2Img.setPreserveRatio(true);
        HBox.setMargin(hBox0, new Insets(0.0, 0.0, 0.0, 100.0));

        region.setPrefHeight(200.0);
        region.setPrefWidth(100.0);
        BorderPane.setMargin(hBox, new Insets(30.0, 0.0, 0.0, 0.0));
        setTop(hBox);

        BorderPane.setAlignment(hBox1, javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        AnchorPane.setLeftAnchor(gridPane, 100.0);
        AnchorPane.setRightAnchor(gridPane, 0.0);
        gridPane.getStyleClass().add("grid-pane");

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

        btn00.setMnemonicParsing(false);

        GridPane.setRowIndex(btn02, 2);
        btn02.setMnemonicParsing(false);

        GridPane.setRowIndex(btn01, 1);
        btn01.setMnemonicParsing(false);

        GridPane.setColumnIndex(btn10, 1);
        btn10.setMnemonicParsing(false);

        GridPane.setColumnIndex(btn11, 1);
        GridPane.setRowIndex(btn11, 1);
        btn11.setMnemonicParsing(false);

        GridPane.setColumnIndex(btn12, 1);
        GridPane.setRowIndex(btn12, 2);
        btn12.setMnemonicParsing(false);

        GridPane.setColumnIndex(btn20, 2);
        btn20.setMnemonicParsing(false);

        GridPane.setColumnIndex(btn21, 2);
        GridPane.setRowIndex(btn21, 1);
        btn21.setMnemonicParsing(false);

        GridPane.setColumnIndex(btn22, 2);
        GridPane.setRowIndex(btn22, 2);
        btn22.setMnemonicParsing(false);
        BorderPane.setMargin(hBox1, new Insets(20.0, 0.0, 0.0, 0.0));
        setCenter(hBox1);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.TOP_CENTER);
        flowPane.setPrefHeight(70.0);
        flowPane.setPrefWidth(300.0);

        timerLabel.setId("textId");
        timerLabel.setText("7:00");
        timerLabel.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        region0.setPrefHeight(50.0);
        region0.setPrefWidth(360.0);

        leaveBtn.setId("textId");
        leaveBtn.setMnemonicParsing(false);
        leaveBtn.setText("Leave");
        BorderPane.setMargin(flowPane, new Insets(0.0, 0.0, 20.0, 105.0));
        setBottom(flowPane);
        getStylesheets().add("/tictactoe/offlinegameboard/fxmlofflinegameboard.css");
        getStylesheets().add("/styling/generalStyle.css");

        hBox0.getChildren().add(player1Img);
        hBox0.getChildren().add(player1Label);
        hBox0.getChildren().add(line);
        hBox0.getChildren().add(player2Label);
        hBox0.getChildren().add(player2Img);
        hBox.getChildren().add(hBox0);
        hBox.getChildren().add(region);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(btn00);
        gridPane.getChildren().add(btn02);
        gridPane.getChildren().add(btn01);
        gridPane.getChildren().add(btn10);
        gridPane.getChildren().add(btn11);
        gridPane.getChildren().add(btn12);
        gridPane.getChildren().add(btn20);
        gridPane.getChildren().add(btn21);
        gridPane.getChildren().add(btn22);
        anchorPane.getChildren().add(gridPane);
        hBox1.getChildren().add(anchorPane);
        flowPane.getChildren().add(timerLabel);
        flowPane.getChildren().add(region0);
        flowPane.getChildren().add(leaveBtn);

    }
}
