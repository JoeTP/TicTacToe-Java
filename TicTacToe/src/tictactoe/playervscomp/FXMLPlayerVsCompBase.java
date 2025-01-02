package tictactoe.playervscomp;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    protected final Label difficultyLabel;
    protected final AnchorPane anchorPane0;
    protected final Button backBtn;

    public FXMLPlayerVsCompBase() {

        anchorPane = new AnchorPane();
        chooseDifficultyLabel = new Text();
        difficultySlider = new Slider();
        difficultyImg = new ImageView();
        startBtn = new Button();
        difficultyLabel = new Label();
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

        difficultySlider.setLayoutX(84.0);
        difficultySlider.setLayoutY(334.0);
        difficultySlider.setMajorTickUnit(1.0);
        difficultySlider.setMax(2.0);
        difficultySlider.setMinorTickCount(0);
        difficultySlider.setPrefHeight(31.0);
        difficultySlider.setPrefWidth(286.0);
        difficultySlider.setSnapToTicks(true);

        difficultyImg.setFitHeight(150.0);
        difficultyImg.setFitWidth(200.0);
        difficultyImg.setLayoutX(154.0);
        difficultyImg.setLayoutY(103.0);
        difficultyImg.setPickOnBounds(true);
        difficultyImg.setPreserveRatio(true);
//        difficultyImg.setImage(new Image(getClass().getResource("../../../../../../../difficulty-icon-15.jpg").toExternalForm()));

        AnchorPane.setLeftAnchor(startBtn, 175.0);
        AnchorPane.setRightAnchor(startBtn, 155.0);
        startBtn.setLayoutX(175.0);
        startBtn.setLayoutY(375.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setPrefHeight(30.0);
        startBtn.setPrefWidth(120.0);
        startBtn.setText("Start");
        startBtn.setFont(new Font(20.0));

        difficultyLabel.setLayoutX(194.0);
        difficultyLabel.setLayoutY(277.0);
        difficultyLabel.setPrefHeight(47.0);
        difficultyLabel.setPrefWidth(65.0);
        difficultyLabel.setText("Easy");
        difficultyLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        difficultyLabel.setFont(new Font(32.0));
        setCenter(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(59.0);
        anchorPane0.setPrefWidth(720.0);

        backBtn.setLayoutX(20.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(30.0);
        backBtn.setStyle("-fx-border-radius: 30px; -fx-background-radius: 30px;");
        backBtn.setText("B");
        setTop(anchorPane0);

        anchorPane.getChildren().add(chooseDifficultyLabel);
        anchorPane.getChildren().add(difficultySlider);
        anchorPane.getChildren().add(difficultyImg);
        anchorPane.getChildren().add(startBtn);
        anchorPane.getChildren().add(difficultyLabel);
        anchorPane0.getChildren().add(backBtn);

    }
}
