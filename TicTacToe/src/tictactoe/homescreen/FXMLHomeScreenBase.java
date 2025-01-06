package tictactoe.homescreen;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    protected final Label connectionLabel;
    protected final AnchorPane anchorPane;
    protected final Button button;
    protected final AnchorPane anchorPane0;
    protected final Button chatBtn;
    protected final HBox header;
    protected final Region region;
    protected final Button settingsBtn;
    protected final Button exitBtn;
    protected final AnchorPane anchorPane1;
    protected final VBox vBox;
    protected final AnchorPane anchorPane2;
    protected final ImageView logoImageViewer;
    protected final Button button0;
    protected final Button button1;

    public FXMLHomeScreenBase() {

        hBox = new HBox();
        hBox0 = new HBox();
        connectionIndicatorImageView = new ImageView();
        connectionLabel = new Label();
        anchorPane = new AnchorPane();
        button = new Button();
        anchorPane0 = new AnchorPane();
        chatBtn = new Button();
        header = new HBox();
        region = new Region();
        settingsBtn = new Button();
        exitBtn = new Button();
        anchorPane1 = new AnchorPane();
        vBox = new VBox();
        anchorPane2 = new AnchorPane();
        logoImageViewer = new ImageView();
        button0 = new Button();
        button1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(720.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setSpacing(10.0);

        connectionIndicatorImageView.setFitHeight(40.0);
        connectionIndicatorImageView.setFitWidth(40.0);
        connectionIndicatorImageView.setPickOnBounds(true);
        connectionIndicatorImageView.setPreserveRatio(true);
        HBox.setMargin(connectionIndicatorImageView, new Insets(0.0, 0.0, 0.0, 20.0));

        connectionLabel.setAlignment(javafx.geometry.Pos.CENTER);
        connectionLabel.getStyleClass().add("bigLabel");
        connectionLabel.getStylesheets().add("/styling/generalStyle.css");
        connectionLabel.setText("Online");
        hBox0.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 20.0));

        HBox.setHgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefHeight(40.0);
        anchorPane.setPrefWidth(184.0);

        AnchorPane.setBottomAnchor(button, 10.0);
        AnchorPane.setRightAnchor(button, 248.0);
        button.setLayoutX(174.0);
        button.setLayoutY(5.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::openPlayerVsPlayerPopup);
        button.getStyleClass().add("bigBtn");
        button.getStylesheets().add("/styling/generalStyle.css");
        button.setText("Sign In");

        HBox.setHgrow(anchorPane0, javafx.scene.layout.Priority.SOMETIMES);
        anchorPane0.setPrefHeight(44.0);
        anchorPane0.setPrefWidth(0.0);
        HBox.setMargin(anchorPane0, new Insets(0.0));

        AnchorPane.setBottomAnchor(chatBtn, 10.0);
        AnchorPane.setRightAnchor(chatBtn, 20.0);
        chatBtn.setLayoutX(312.0);
        chatBtn.setLayoutY(2.0);
        chatBtn.setMnemonicParsing(false);
        chatBtn.setOnAction(this::openChat);
        chatBtn.getStyleClass().add("bigBtn");
        chatBtn.getStylesheets().add("/styling/generalStyle.css");
        chatBtn.setText("Chat");
        BorderPane.setMargin(hBox, new Insets(0.0));
        setBottom(hBox);

        BorderPane.setAlignment(header, javafx.geometry.Pos.CENTER);
        header.setSpacing(20.0);
        header.getStylesheets().add("/styling/generalStyle.css");

        HBox.setHgrow(region, javafx.scene.layout.Priority.ALWAYS);

        HBox.setHgrow(settingsBtn, javafx.scene.layout.Priority.NEVER);
        settingsBtn.setMnemonicParsing(false);
        settingsBtn.setOnAction(this::openSettingsScreen);
        settingsBtn.getStyleClass().add("bigBtn");
        settingsBtn.getStylesheets().add("/styling/generalStyle.css");
        settingsBtn.setText("Settings");

        exitBtn.setLayoutX(645.0);
        exitBtn.setLayoutY(30.0);
        exitBtn.setMinWidth(31.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::exitApp);
        exitBtn.setPrefHeight(32.0);
        exitBtn.setPrefWidth(31.0);
        exitBtn.getStyleClass().add("bigBtn");
        exitBtn.getStylesheets().add("/styling/generalStyle.css");
        exitBtn.setText("X");
        header.setPadding(new Insets(20.0, 20.0, 0.0, 0.0));
        setTop(header);

        BorderPane.setAlignment(anchorPane1, javafx.geometry.Pos.CENTER);
        anchorPane1.setPrefHeight(200.0);
        anchorPane1.setPrefWidth(200.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setLayoutX(223.0);
        vBox.setLayoutY(71.0);
        vBox.setPrefHeight(368.0);
        vBox.setPrefWidth(274.0);
        vBox.setSpacing(20.0);

        AnchorPane.setBottomAnchor(logoImageViewer, 30.0);
        AnchorPane.setLeftAnchor(logoImageViewer, 13.0);
        AnchorPane.setRightAnchor(logoImageViewer, 12.634613037109375);
        AnchorPane.setTopAnchor(logoImageViewer, 0.0);
        logoImageViewer.setFitHeight(180.0);
        logoImageViewer.setFitWidth(285.0);
        logoImageViewer.setLayoutX(13.0);
        logoImageViewer.setPickOnBounds(true);
        logoImageViewer.setPreserveRatio(true);
        logoImageViewer.setImage(new Image(getClass().getResource("/assets/icons/icon.png").toExternalForm()));

        button0.setMnemonicParsing(false);
        button0.setOnAction(this::openPlayerVsComputerPopup);
        button0.getStyleClass().add("bigBtn");
        button0.getStylesheets().add("/styling/generalStyle.css");
        button0.setText("Play Vs Computer");
        VBox.setMargin(button0, new Insets(0.0));

        button1.setLayoutX(82.0);
        button1.setLayoutY(122.0);
        button1.setMnemonicParsing(false);
        button1.setOnAction(this::openPlayerVsPlayerPopup);
        button1.getStyleClass().add("bigBtn");
        button1.getStylesheets().add("/styling/generalStyle.css");
        button1.setText("   Play Vs Player   ");
        BorderPane.setMargin(anchorPane1, new Insets(0.0));
        setCenter(anchorPane1);

        hBox0.getChildren().add(connectionIndicatorImageView);
        hBox0.getChildren().add(connectionLabel);
        hBox.getChildren().add(hBox0);
        anchorPane.getChildren().add(button);
        hBox.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(chatBtn);
        hBox.getChildren().add(anchorPane0);
        header.getChildren().add(region);
        header.getChildren().add(settingsBtn);
        header.getChildren().add(exitBtn);
        anchorPane2.getChildren().add(logoImageViewer);
        vBox.getChildren().add(anchorPane2);
        vBox.getChildren().add(button0);
        vBox.getChildren().add(button1);
        anchorPane1.getChildren().add(vBox);

    }

    protected abstract void openPlayerVsPlayerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void openChat(javafx.event.ActionEvent actionEvent);

    protected abstract void openSettingsScreen(javafx.event.ActionEvent actionEvent);

    protected abstract void exitApp(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsComputerPopup(javafx.event.ActionEvent actionEvent);


}
