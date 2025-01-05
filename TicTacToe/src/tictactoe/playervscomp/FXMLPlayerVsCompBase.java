package tictactoe.playervscomp;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLPlayerVsCompBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Text chooseDifficultyLabel;
    protected final Slider difficultySlider;
    protected final ImageView difficultyImg;
    protected final Button startBtn;
    protected final AnchorPane anchorPane0;
    protected final Button backBtn;

    public FXMLPlayerVsCompBase() {

        anchorPane = new AnchorPane();
        chooseDifficultyLabel = new Text();
        difficultySlider = new Slider();
        difficultyImg = new ImageView();
        startBtn = new Button();
        anchorPane0 = new AnchorPane();
        backBtn = new Button();

        setMaxHeight(720.0);
        setMaxWidth(720.0);
        setMinHeight(500.0);
        setMinWidth(450.0);
        setPrefHeight(500.0);
        setPrefWidth(450.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(472.0);
        anchorPane.setPrefWidth(720.0);

        chooseDifficultyLabel.setLayoutX(98.0);
        chooseDifficultyLabel.setLayoutY(31.0);
        chooseDifficultyLabel.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        chooseDifficultyLabel.setStrokeWidth(0.0);
        chooseDifficultyLabel.setText("Choose Difficulty");
        chooseDifficultyLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        chooseDifficultyLabel.setFont(new Font(36.0));

        difficultySlider.setBlockIncrement(1.0);
        difficultySlider.setLayoutX(82.0);
        difficultySlider.setLayoutY(273.0);
        difficultySlider.setMajorTickUnit(1.0);
        difficultySlider.setMax(2.0);
        difficultySlider.setMinorTickCount(0);
        difficultySlider.setPrefHeight(31.0);
        difficultySlider.setPrefWidth(286.0);
        difficultySlider.setSnapToTicks(true);

        difficultyImg.setFitHeight(144.0);
        difficultyImg.setFitWidth(262.0);
        difficultyImg.setLayoutX(96.0);
        difficultyImg.setLayoutY(106.0);
        difficultyImg.setPickOnBounds(true);
        difficultyImg.setPreserveRatio(true);
        difficultyImg.setImage(new Image(getClass().getResource("/assets/icons/easy.png").toExternalForm()));

        AnchorPane.setLeftAnchor(startBtn, 165.0);
        AnchorPane.setRightAnchor(startBtn, 165.0);
        startBtn.setLayoutX(165.0);
        startBtn.setLayoutY(318.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setOnAction(this::openGameBoard);
        startBtn.setPrefHeight(30.0);
        startBtn.setPrefWidth(120.0);
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
        backBtn.setText("B");
        setTop(anchorPane0);

        anchorPane.getChildren().add(chooseDifficultyLabel);
        anchorPane.getChildren().add(difficultySlider);
        anchorPane.getChildren().add(difficultyImg);
        anchorPane.getChildren().add(startBtn);
        anchorPane0.getChildren().add(backBtn);

    }


    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

    protected abstract void openGameBoard(javafx.event.ActionEvent actionEvent);


}
