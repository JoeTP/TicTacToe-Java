package tictactoe.homescreen;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public abstract class FXMLHomeScreenBase extends BorderPane {

    protected final HBox hBox;
    protected final HBox hBox0;
    protected final ImageView connectionIndicatorImageView;
    protected final Label label;
    protected final Region region;
    protected final Button button;
    protected final HBox header;
    protected final Region region0;
    protected final Button button0;
    protected final Button button1;
    protected final AnchorPane anchorPane;
    protected final VBox vBox;
    protected final AnchorPane anchorPane0;
    protected final ImageView logoImageViewer;
    protected final Button button2;
    protected final Button button3;
    protected final VBox vBox0;
    protected final ImageView profileImageView;

    public FXMLHomeScreenBase() {

        hBox = new HBox();
        hBox0 = new HBox();
        connectionIndicatorImageView = new ImageView();
        label = new Label();
        region = new Region();
        button = new Button();
        header = new HBox();
        region0 = new Region();
        button0 = new Button();
        button1 = new Button();
        anchorPane = new AnchorPane();
        vBox = new VBox();
        anchorPane0 = new AnchorPane();
        logoImageViewer = new ImageView();
        button2 = new Button();
        button3 = new Button();
        vBox0 = new VBox();
        profileImageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(720.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER_LEFT);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setSpacing(10.0);

        connectionIndicatorImageView.setFitHeight(40.0);
        connectionIndicatorImageView.setFitWidth(40.0);
        connectionIndicatorImageView.setPickOnBounds(true);
        connectionIndicatorImageView.setPreserveRatio(true);
        HBox.setMargin(connectionIndicatorImageView, new Insets(0.0, 0.0, 0.0, 20.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setText("Online");
        hBox0.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 20.0));

        HBox.setHgrow(region, javafx.scene.layout.Priority.ALWAYS);

        button.setMnemonicParsing(false);
        button.setText("Chat");
        HBox.setMargin(button, new Insets(0.0, 20.0, 20.0, 0.0));
        setBottom(hBox);

        BorderPane.setAlignment(header, javafx.geometry.Pos.CENTER);
        header.setSpacing(20.0);

        HBox.setHgrow(region0, javafx.scene.layout.Priority.ALWAYS);

        HBox.setHgrow(button0, javafx.scene.layout.Priority.NEVER);
        button0.setMnemonicParsing(false);
        button0.setText("Settings");

        button1.setLayoutX(645.0);
        button1.setLayoutY(30.0);
        button1.setMinWidth(31.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(32.0);
        button1.setPrefWidth(31.0);
        button1.setText("X");
        header.setPadding(new Insets(20.0, 20.0, 0.0, 0.0));
        setTop(header);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setLayoutX(117.0);
        vBox.setLayoutY(71.0);
        vBox.setPrefHeight(368.0);
        vBox.setPrefWidth(274.0);
        vBox.setSpacing(20.0);

        AnchorPane.setBottomAnchor(logoImageViewer, 0.0);
        AnchorPane.setLeftAnchor(logoImageViewer, 0.0);
        AnchorPane.setRightAnchor(logoImageViewer, 0.0);
        AnchorPane.setTopAnchor(logoImageViewer, 0.0);
        logoImageViewer.setFitHeight(180.0);
        logoImageViewer.setFitWidth(285.0);
        logoImageViewer.setPickOnBounds(true);
        logoImageViewer.setPreserveRatio(true);

        button2.setMnemonicParsing(false);
        button2.setText("Play Vs Computer");

        button3.setLayoutX(82.0);
        button3.setLayoutY(122.0);
        button3.setMnemonicParsing(false);
        button3.setText("Play Vs Player");
        setCenter(anchorPane);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.BOTTOM_LEFT);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);

        profileImageView.setFitHeight(67.0);
        profileImageView.setFitWidth(89.0);
        profileImageView.setPickOnBounds(true);
        profileImageView.setPreserveRatio(true);
        BorderPane.setMargin(vBox0, new Insets(0.0));
        vBox0.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        setLeft(vBox0);

        hBox0.getChildren().add(connectionIndicatorImageView);
        hBox0.getChildren().add(label);
        hBox.getChildren().add(hBox0);
        hBox.getChildren().add(region);
        hBox.getChildren().add(button);
        header.getChildren().add(region0);
        header.getChildren().add(button0);
        header.getChildren().add(button1);
        anchorPane0.getChildren().add(logoImageViewer);
        vBox.getChildren().add(anchorPane0);
        vBox.getChildren().add(button2);
        vBox.getChildren().add(button3);
        anchorPane.getChildren().add(vBox);
        vBox0.getChildren().add(profileImageView);

    }
}
