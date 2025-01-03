package tictactoe.onlinegmaeboard;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public  class FXMLGameBoardOnlineBase extends VBox {

    protected final HBox hBox;
    protected final AnchorPane anchorPane;
    protected final HBox hBox0;
    protected final ImageView imageView;
    protected final Label label;
    protected final Line line;
    protected final Label label0;
    protected final ImageView imageView0;
    protected final Region region;
    protected final AnchorPane anchorPane0;
    protected final Button button;
    protected final HBox hBox1;
    protected final AnchorPane anchorPane1;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button button8;
    protected final AnchorPane anchorPane2;
    protected final VBox vBox;
    protected final BorderPane borderPane;
    protected final HBox hBox2;
    protected final Text text;
    protected final ScrollPane scrollPane;
    protected final Pane pane;
    protected final Label label1;
    protected final Label label2;
    protected final FlowPane flowPane;
    protected final TextField textField;
    protected final Button button9;
    protected final AnchorPane anchorPane3;
    protected final Label label3;

    public FXMLGameBoardOnlineBase() {

        hBox = new HBox();
        anchorPane = new AnchorPane();
        hBox0 = new HBox();
        imageView = new ImageView();
        label = new Label();
        line = new Line();
        label0 = new Label();
        imageView0 = new ImageView();
        region = new Region();
        anchorPane0 = new AnchorPane();
        button = new Button();
        hBox1 = new HBox();
        anchorPane1 = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        anchorPane2 = new AnchorPane();
        vBox = new VBox();
        borderPane = new BorderPane();
        hBox2 = new HBox();
        text = new Text();
        scrollPane = new ScrollPane();
        pane = new Pane();
        label1 = new Label();
        label2 = new Label();
        flowPane = new FlowPane();
        textField = new TextField();
        button9 = new Button();
        anchorPane3 = new AnchorPane();
        label3 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(1000.0);
        getStyleClass().add("scrollBane");

        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(1000.0);

        AnchorPane.setLeftAnchor(hBox0, 100.0);
        AnchorPane.setTopAnchor(hBox0, 0.0);
        hBox0.setPrefHeight(75.0);
        hBox0.setPrefWidth(459.14);
        hBox0.getStyleClass().add("hbox");

        imageView.setFitHeight(54.6);
        imageView.setFitWidth(44.26);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("assets/gamer.png").toExternalForm()));

        label.setId("textId");
        label.setText("Player1");

        line.setEndX(-65.70710754394531);
        line.setEndY(-0.41418302059173584);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#3e5879"));

        label0.setId("textId");
        label0.setText("Player2");

        imageView0.setFitHeight(54.6);
        imageView0.setFitWidth(44.26);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("assets/gamer.png").toExternalForm()));
        HBox.setMargin(anchorPane, new Insets(20.0, 0.0, 0.0, 0.0));

        region.setPrefHeight(200.0);
        region.setPrefWidth(230.0);

        button.setId("textId");
        button.setLayoutY(6.0);
        button.setMnemonicParsing(false);
        button.setText("Leave");
        HBox.setMargin(anchorPane0, new Insets(20.0, 0.0, 0.0, 0.0));

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

        button0.setMnemonicParsing(false);

        GridPane.setRowIndex(button1, 2);
        button1.setMnemonicParsing(false);

        GridPane.setRowIndex(button2, 1);
        button2.setMnemonicParsing(false);

        GridPane.setColumnIndex(button3, 1);
        button3.setMnemonicParsing(false);

        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);

        GridPane.setColumnIndex(button5, 1);
        GridPane.setRowIndex(button5, 2);
        button5.setMnemonicParsing(false);

        GridPane.setColumnIndex(button6, 2);
        button6.setMnemonicParsing(false);

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 1);
        button7.setMnemonicParsing(false);

        GridPane.setColumnIndex(button8, 2);
        GridPane.setRowIndex(button8, 2);
        button8.setMnemonicParsing(false);

        HBox.setMargin(anchorPane2, new Insets(0.0, 0.0, 0.0, 40.0));

        vBox.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        vBox.getStyleClass().add("vbox");

        borderPane.setPrefHeight(500.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(hBox2, javafx.geometry.Pos.CENTER);
        hBox2.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBox2.setPrefHeight(60.0);
        hBox2.setPrefWidth(200.0);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setId("textId");
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Chat");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        HBox.setMargin(text, new Insets(10.0, 0.0, 0.0, 0.0));
        borderPane.setTop(hBox2);

        BorderPane.setAlignment(scrollPane, javafx.geometry.Pos.CENTER);
        scrollPane.setPrefHeight(400.0);
        scrollPane.setPrefWidth(300.0);
        scrollPane.getStyleClass().add("transparent-background");

        pane.setPrefHeight(400.0);
        pane.setPrefWidth(300.0);

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(14.0);
        label1.setLayoutY(23.0);
        label1.getStyleClass().add("incoming-bubble");
        label1.setText("Can i play with you again ?");

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setLayoutX(212.0);
        label2.setLayoutY(75.0);
        label2.getStyleClass().add("outcoming-bubble");
        label2.setText("Sure !");
        scrollPane.setContent(pane);
        borderPane.setCenter(scrollPane);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(60.0);
        flowPane.setPrefWidth(200.0);

        textField.setPromptText("Message");
        textField.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        FlowPane.setMargin(textField, new Insets(12.0, 0.0, 0.0, 15.0));

        button9.setMnemonicParsing(false);
        button9.setText("Send");
        FlowPane.setMargin(button9, new Insets(10.0, 0.0, 0.0, 10.0));
        borderPane.setBottom(flowPane);
        VBox.setMargin(hBox1, new Insets(0.0));

        AnchorPane.setLeftAnchor(label3, 100.0);
        label3.setId("textId");
        label3.setText("7:00");

        hBox0.getChildren().add(imageView);
        hBox0.getChildren().add(label);
        hBox0.getChildren().add(line);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(imageView0);
        anchorPane.getChildren().add(hBox0);
        hBox.getChildren().add(anchorPane);
        hBox.getChildren().add(region);
        anchorPane0.getChildren().add(button);
        hBox.getChildren().add(anchorPane0);
        getChildren().add(hBox);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        gridPane.getChildren().add(button8);
        anchorPane1.getChildren().add(gridPane);
        hBox1.getChildren().add(anchorPane1);
        hBox2.getChildren().add(text);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        flowPane.getChildren().add(textField);
        flowPane.getChildren().add(button9);
        vBox.getChildren().add(borderPane);
        anchorPane2.getChildren().add(vBox);
        hBox1.getChildren().add(anchorPane2);
        getChildren().add(hBox1);
        anchorPane3.getChildren().add(label3);
        getChildren().add(anchorPane3);

    }
}
