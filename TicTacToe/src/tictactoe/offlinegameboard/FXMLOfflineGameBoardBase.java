package tictactoe.offlinegameboard;

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

public  class FXMLOfflineGameBoardBase extends BorderPane {

    protected final HBox hBox;
    protected final HBox hBox0;
    protected final ImageView imageView;
    protected final Label label;
    protected final Line line;
    protected final Label label0;
    protected final ImageView imageView0;
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
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final FlowPane flowPane;
    protected final Label label1;
    protected final Region region0;
    protected final Button button8;

    public FXMLOfflineGameBoardBase() {

        hBox = new HBox();
        hBox0 = new HBox();
        imageView = new ImageView();
        label = new Label();
        line = new Line();
        label0 = new Label();
        imageView0 = new ImageView();
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
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        flowPane = new FlowPane();
        label1 = new Label();
        region0 = new Region();
        button8 = new Button();

        setPrefHeight(720.0);
        setPrefWidth(720.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(70.0);
        hBox.setPrefWidth(300.0);

        hBox0.setPrefHeight(75.0);
        hBox0.setPrefWidth(459.14);
        hBox0.getStyleClass().add("hbox");

        imageView.setFitHeight(54.6);
        imageView.setFitWidth(44.26);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        label.setId("textId");
        label.setText("Player1");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        line.setEndX(-65.70710754394531);
        line.setEndY(-0.41418302059173584);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#3e5879"));

        label0.setId("textId");
        label0.setText("Player2");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        imageView0.setFitHeight(54.6);
        imageView0.setFitWidth(44.26);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
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

        button.setMnemonicParsing(false);

        GridPane.setRowIndex(button0, 2);
        button0.setMnemonicParsing(false);

        GridPane.setRowIndex(button1, 1);
        button1.setMnemonicParsing(false);

        GridPane.setColumnIndex(button2, 1);
        button2.setMnemonicParsing(false);

        GridPane.setColumnIndex(button3, 1);
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);

        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button4, 2);
        button4.setMnemonicParsing(false);

        GridPane.setColumnIndex(button5, 2);
        button5.setMnemonicParsing(false);

        GridPane.setColumnIndex(button6, 2);
        GridPane.setRowIndex(button6, 1);
        button6.setMnemonicParsing(false);

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        BorderPane.setMargin(hBox1, new Insets(20.0, 0.0, 0.0, 0.0));
        setCenter(hBox1);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.TOP_CENTER);
        flowPane.setPrefHeight(70.0);
        flowPane.setPrefWidth(300.0);

        label1.setId("textId");
        label1.setText("7:00");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));

        region0.setPrefHeight(50.0);
        region0.setPrefWidth(330.0);

        button8.setId("textId");
        button8.setMnemonicParsing(false);
        button8.setText("Leave");
        BorderPane.setMargin(flowPane, new Insets(0.0, 0.0, 20.0, 105.0));
        setBottom(flowPane);

        hBox0.getChildren().add(imageView);
        hBox0.getChildren().add(label);
        hBox0.getChildren().add(line);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(imageView0);
        hBox.getChildren().add(hBox0);
        hBox.getChildren().add(region);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        anchorPane.getChildren().add(gridPane);
        hBox1.getChildren().add(anchorPane);
        flowPane.getChildren().add(label1);
        flowPane.getChildren().add(region0);
        flowPane.getChildren().add(button8);

    }
}
