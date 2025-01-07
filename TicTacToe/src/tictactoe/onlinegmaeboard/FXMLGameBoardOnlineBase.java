package tictactoe.onlinegmaeboard;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import static shared.AppString.GENERAL_STYLE_FILE_PATH;
import static shared.AppString.ONLINE_GAME_BOARD_STYLE_FILE_PATH;

public abstract class FXMLGameBoardOnlineBase extends VBox {

    protected final HBox hboxTop;
    protected final AnchorPane anchorPane;
    protected final HBox hboxTurn;
    protected final ImageView player1Img;
    protected final Label player1Label;
    protected final Line line;
    protected final Label player2Label;
    protected final ImageView player2Img;
    protected final Region region;
    protected final AnchorPane anchorPane0;
    protected final Button forfiteBtn;
    protected final HBox hBox;
    protected final AnchorPane anchorPane1;
    protected final GridPane gameBoardGridPane;
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
    protected final AnchorPane anchorPane2;
    protected final VBox vBox;
    protected final BorderPane borderPane;
    protected final HBox hBox0;
    protected final Text text;
    protected final AnchorPane anchorPane3;
    protected final StackPane stackPane;
    protected final TextArea textArea;
    protected final FlowPane flowPane;
    protected final TextField messageTextField;
    protected final Button sendBtn;
    protected final AnchorPane anchorPane4;
    protected final Label timerLabel;

    public FXMLGameBoardOnlineBase() {

        hboxTop = new HBox();
        anchorPane = new AnchorPane();
        hboxTurn = new HBox();
        player1Img = new ImageView();
        player1Label = new Label();
        line = new Line();
        player2Label = new Label();
        player2Img = new ImageView();
        region = new Region();
        anchorPane0 = new AnchorPane();
        forfiteBtn = new Button();
        hBox = new HBox();
        anchorPane1 = new AnchorPane();
        gameBoardGridPane = new GridPane();
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
        anchorPane2 = new AnchorPane();
        vBox = new VBox();
        borderPane = new BorderPane();
        hBox0 = new HBox();
        text = new Text();
        anchorPane3 = new AnchorPane();
        stackPane = new StackPane();
        textArea = new TextArea();
        flowPane = new FlowPane();
        messageTextField = new TextField();
        sendBtn = new Button();
        anchorPane4 = new AnchorPane();
        timerLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(1000.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add(ONLINE_GAME_BOARD_STYLE_FILE_PATH);

        hboxTop.setPrefHeight(100.0);
        hboxTop.setPrefWidth(1000.0);
        hboxTop.getStylesheets().add(GENERAL_STYLE_FILE_PATH);

        AnchorPane.setLeftAnchor(hboxTurn, 100.0);
        AnchorPane.setTopAnchor(hboxTurn, 0.0);
        hboxTurn.setPrefHeight(75.0);
        hboxTurn.setPrefWidth(459.14);
        hboxTurn.getStyleClass().add("hbox");

        player1Img.setFitHeight(54.6);
        player1Img.setFitWidth(44.26);
        player1Img.setPickOnBounds(true);
        player1Img.setPreserveRatio(true);

        player1Label.setText("Player1");

        line.setEndX(-65.70710754394531);
        line.setEndY(-0.41418302059173584);
        line.setStartX(-100.0);
        line.setStroke(javafx.scene.paint.Color.valueOf("#3e5879"));

        player2Label.setId("textId");
        player2Label.setText("Player2");

        player2Img.setFitHeight(54.6);
        player2Img.setFitWidth(44.26);
        player2Img.setPickOnBounds(true);
        player2Img.setPreserveRatio(true);
        HBox.setMargin(anchorPane, new Insets(20.0, 0.0, 0.0, 0.0));

        region.setPrefHeight(200.0);
        region.setPrefWidth(230.0);

        AnchorPane.setRightAnchor(forfiteBtn, 10.0);
        forfiteBtn.setLayoutY(6.0);
        forfiteBtn.setMnemonicParsing(false);
        forfiteBtn.setOnAction(this::winOrLossPopup);
        forfiteBtn.setText("Forfite");
        HBox.setMargin(anchorPane0, new Insets(20.0, 0.0, 0.0, 100.0));
        VBox.setMargin(hboxTop, new Insets(30.0, 0.0, 0.0, 0.0));

        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        AnchorPane.setLeftAnchor(gameBoardGridPane, 100.0);
        AnchorPane.setRightAnchor(gameBoardGridPane, 0.0);
        AnchorPane.setTopAnchor(gameBoardGridPane, 0.0);
        gameBoardGridPane.getStyleClass().add("grid-pane");

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
        GridPane.setMargin(btn20, new Insets(20.0, 0.0, 0.0, 0.0));

        GridPane.setColumnIndex(btn21, 2);
        GridPane.setRowIndex(btn21, 1);
        btn21.setMnemonicParsing(false);

        GridPane.setColumnIndex(btn22, 2);
        GridPane.setRowIndex(btn22, 2);
        btn22.setMnemonicParsing(false);

        HBox.setMargin(anchorPane2, new Insets(0.0, 0.0, 0.0, 100.0));

        AnchorPane.setRightAnchor(vBox, 20.0);
        vBox.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        vBox.getStyleClass().add("vbox");

        borderPane.setPrefHeight(500.0);
        borderPane.setPrefWidth(200.0);

        BorderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);
        hBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hBox0.setPrefHeight(60.0);
        hBox0.setPrefWidth(200.0);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setId("textId");
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Chat");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        HBox.setMargin(text, new Insets(20.0, 0.0, 0.0, 0.0));
        text.setFont(new Font("Bell MT Bold", 20.0));
        BorderPane.setMargin(hBox0, new Insets(0.0));
        borderPane.setTop(hBox0);

        stackPane.setPrefHeight(370.0);
        stackPane.setPrefWidth(300.0);

        textArea.setPrefHeight(890.0);
        textArea.setPrefWidth(300.0);
        borderPane.setCenter(anchorPane3);

        BorderPane.setAlignment(flowPane, javafx.geometry.Pos.CENTER);
        flowPane.setPrefHeight(60.0);
        flowPane.setPrefWidth(200.0);
        flowPane.getStylesheets().add(GENERAL_STYLE_FILE_PATH);

        messageTextField.setPromptText("Message");
        messageTextField.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        FlowPane.setMargin(messageTextField, new Insets(12.0, 0.0, 0.0, 15.0));

        sendBtn.setMnemonicParsing(false);
        sendBtn.setText("Send");
        FlowPane.setMargin(sendBtn, new Insets(10.0, 0.0, 0.0, 10.0));
        BorderPane.setMargin(flowPane, new Insets(0.0, 0.0, 10.0, 0.0));
        borderPane.setBottom(flowPane);
        VBox.setMargin(borderPane, new Insets(0.0));
        VBox.setMargin(hBox, new Insets(20.0, 0.0, 0.0, 0.0));

        AnchorPane.setLeftAnchor(timerLabel, 100.0);
        timerLabel.setId("textId");
        timerLabel.getStylesheets().add(GENERAL_STYLE_FILE_PATH);
        timerLabel.setText("7:00");

        hboxTurn.getChildren().add(player1Img);
        hboxTurn.getChildren().add(player1Label);
        hboxTurn.getChildren().add(line);
        hboxTurn.getChildren().add(player2Label);
        hboxTurn.getChildren().add(player2Img);
        anchorPane.getChildren().add(hboxTurn);
        hboxTop.getChildren().add(anchorPane);
        hboxTop.getChildren().add(region);
        anchorPane0.getChildren().add(forfiteBtn);
        hboxTop.getChildren().add(anchorPane0);
        getChildren().add(hboxTop);
        gameBoardGridPane.getColumnConstraints().add(columnConstraints);
        gameBoardGridPane.getColumnConstraints().add(columnConstraints0);
        gameBoardGridPane.getColumnConstraints().add(columnConstraints1);
        gameBoardGridPane.getRowConstraints().add(rowConstraints);
        gameBoardGridPane.getRowConstraints().add(rowConstraints0);
        gameBoardGridPane.getRowConstraints().add(rowConstraints1);
        gameBoardGridPane.getChildren().add(btn00);
        gameBoardGridPane.getChildren().add(btn02);
        gameBoardGridPane.getChildren().add(btn01);
        gameBoardGridPane.getChildren().add(btn10);
        gameBoardGridPane.getChildren().add(btn11);
        gameBoardGridPane.getChildren().add(btn12);
        gameBoardGridPane.getChildren().add(btn20);
        gameBoardGridPane.getChildren().add(btn21);
        gameBoardGridPane.getChildren().add(btn22);
        anchorPane1.getChildren().add(gameBoardGridPane);
        hBox.getChildren().add(anchorPane1);
        hBox0.getChildren().add(text);
        stackPane.getChildren().add(textArea);
        anchorPane3.getChildren().add(stackPane);
        flowPane.getChildren().add(messageTextField);
        flowPane.getChildren().add(sendBtn);
        vBox.getChildren().add(borderPane);
        anchorPane2.getChildren().add(vBox);
        hBox.getChildren().add(anchorPane2);
        getChildren().add(hBox);
        anchorPane4.getChildren().add(timerLabel);
        getChildren().add(anchorPane4);

    }

    protected abstract void winOrLossPopup(javafx.event.ActionEvent actionEvent);

}
