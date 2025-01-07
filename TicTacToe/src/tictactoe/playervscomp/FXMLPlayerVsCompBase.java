package tictactoe.playervscomp;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public abstract class FXMLPlayerVsCompBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Slider difficultySlider;
    protected final ImageView difficultyImg;
    protected final Label label0;
    protected final Button startBtn;
    protected final AnchorPane anchorPane0;
    protected final Button backBtn;

    public FXMLPlayerVsCompBase() {

        anchorPane = new AnchorPane();
        label = new Label();
        difficultySlider = new Slider();
        difficultyImg = new ImageView();
        label0 = new Label();
        startBtn = new Button();
        anchorPane0 = new AnchorPane();
        backBtn = new Button();

        setMaxHeight(720.0);
        setMaxWidth(720.0);
        setMinHeight(500.0);
        setMinWidth(450.0);
        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/styling/generalStyle.css");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(472.0);
        anchorPane.setPrefWidth(720.0);

        label.setLayoutX(180.0);
        label.setLayoutY(12.0);
        label.getStyleClass().add("bigLabel");
       
        label.setText("Difficulty");

        difficultySlider.setBlockIncrement(1.0);
        difficultySlider.setLayoutX(100.0);
        difficultySlider.setLayoutY(267.0);
        difficultySlider.setMajorTickUnit(1.0);
        difficultySlider.setMax(2.0);
        difficultySlider.setMinorTickCount(0);
        difficultySlider.setPrefHeight(42.0);
        difficultySlider.setPrefWidth(266.0);
        difficultySlider.setShowTickLabels(true);
        difficultySlider.setShowTickMarks(true);
        difficultySlider.setSnapToTicks(true);
        difficultySlider.setCursor(Cursor.HAND);

        difficultyImg.setFitHeight(144.0);
        difficultyImg.setFitWidth(262.0);
        difficultyImg.setLayoutX(96.0);
        difficultyImg.setLayoutY(87.0);
        difficultyImg.setPickOnBounds(true);
        difficultyImg.setPreserveRatio(true);
        difficultyImg.setImage(new Image(getClass().getResource("/assets/icons/easy.png").toExternalForm()));

        label0.setLayoutX(155.0);
        label0.setLayoutY(226.0);
        label0.getStyleClass().add("bigLabel");
     
        label0.setText("Select Difficulty");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#213555"));
        label0.setFont(new Font("System Bold", 18.0));
        label0.setOpaqueInsets(new Insets(0.0));

        AnchorPane.setLeftAnchor(startBtn, 148.0);
        AnchorPane.setRightAnchor(startBtn, 147.0);
        startBtn.setLayoutX(148.0);
        startBtn.setLayoutY(332.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setOnAction(this::openGameBoard);
        startBtn.setPrefHeight(44.0);
        startBtn.setPrefWidth(155.0);
        startBtn.getStyleClass().add("bigBtn");
       
        startBtn.setText("Start");
        startBtn.setFont(new Font(20.0));
        setCenter(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(59.0);
        anchorPane0.setPrefWidth(720.0);

        AnchorPane.setLeftAnchor(backBtn, 20.0);
        AnchorPane.setTopAnchor(backBtn, 14.0);
        backBtn.setLayoutX(20.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setOnAction(this::handleBackButton);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(30.0);
        backBtn.setStyle("-fx-border-radius: 30px; -fx-background-radius: 30px;");
        backBtn.getStyleClass().add("bigBtn");
       
        backBtn.setText("B");
        setTop(anchorPane0);

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(difficultySlider);
        anchorPane.getChildren().add(difficultyImg);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(startBtn);
        anchorPane0.getChildren().add(backBtn);

    }

    protected abstract void openGameBoard(javafx.event.ActionEvent actionEvent);

    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

}
