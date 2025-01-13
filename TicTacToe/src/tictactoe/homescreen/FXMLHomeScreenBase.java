package tictactoe.homescreen;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public abstract class FXMLHomeScreenBase extends StackPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final HBox header;
    protected final Region region;
    protected final Button settingsBtn;
    protected final Button exitBtn;
    protected final AnchorPane anchorPane;
    protected final VBox vBox;
    protected final StackPane stackPane;
    protected final Rectangle rectangle;
    protected final DropShadow dropShadow;
    protected final AnchorPane anchorPane0;
    protected final ImageView logoImageViewer;
    protected final Button playVsplayBtn;
    protected final Button playVscompBtn;
    protected final HBox header1;
    protected final VBox vBox0;
    protected final ImageView connectionIndicatorImageView;
    protected final Label connectionLabel;
    protected final Region region0;
    protected final Button signInBtn;
    protected final Region region1;
    protected final Button chatBtn;

    public FXMLHomeScreenBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        header = new HBox();
        region = new Region();
        settingsBtn = new Button();
        exitBtn = new Button();
        anchorPane = new AnchorPane();
        vBox = new VBox();
        stackPane = new StackPane();
        rectangle = new Rectangle();
        dropShadow = new DropShadow();
        anchorPane0 = new AnchorPane();
        logoImageViewer = new ImageView();
        playVsplayBtn = new Button();
        playVscompBtn = new Button();
        header1 = new HBox();
        vBox0 = new VBox();
        connectionIndicatorImageView = new ImageView();
        connectionLabel = new Label();
        region0 = new Region();
        signInBtn = new Button();
        region1 = new Region();
        chatBtn = new Button();

        getStylesheets().add("/tictactoe/homescreen/../../../resources/styling/generalStyle.css");

        imageView.setFitHeight(720.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../../resources/assets/icons/hsBackground.jpg").toExternalForm()));

        borderPane.setMaxHeight(USE_PREF_SIZE);
        borderPane.setMaxWidth(USE_PREF_SIZE);
        borderPane.setMinHeight(USE_PREF_SIZE);
        borderPane.setMinWidth(USE_PREF_SIZE);
        borderPane.setPrefHeight(720.0);
        borderPane.setPrefWidth(720.0);

        BorderPane.setAlignment(header, javafx.geometry.Pos.CENTER);
        header.setSpacing(20.0);

        HBox.setHgrow(region, javafx.scene.layout.Priority.ALWAYS);

        HBox.setHgrow(settingsBtn, javafx.scene.layout.Priority.NEVER);
        settingsBtn.setMnemonicParsing(false);
        settingsBtn.setOnAction(this::openSettingsScreen);
        settingsBtn.getStyleClass().add("bigBtn");
        settingsBtn.setText("Settings");

        exitBtn.setLayoutX(645.0);
        exitBtn.setLayoutY(30.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::exitApp);
        exitBtn.getStyleClass().add("bigBtn");
        exitBtn.setText("X");
        header.setPadding(new Insets(20.0, 20.0, 0.0, 0.0));
        borderPane.setTop(header);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setLayoutX(215.0);
        vBox.setLayoutY(92.0);
        vBox.setPrefHeight(368.0);
        vBox.setPrefWidth(274.0);
        vBox.setSpacing(20.0);

        rectangle.setArcHeight(40.0);
        rectangle.setArcWidth(40.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#f5efe7"));
        rectangle.setHeight(380.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#334d94"));
        rectangle.setStrokeDashOffset(20.0);
        rectangle.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        rectangle.setWidth(280.0);

        dropShadow.setColor(javafx.scene.paint.Color.valueOf("#6d78b0"));
        rectangle.setEffect(dropShadow);

        AnchorPane.setBottomAnchor(logoImageViewer, 216.0);
        AnchorPane.setLeftAnchor(logoImageViewer, 48.0);
        AnchorPane.setRightAnchor(logoImageViewer, 47.028839111328125);
        AnchorPane.setTopAnchor(logoImageViewer, 56.0);
        logoImageViewer.setFitHeight(150.0);
        logoImageViewer.setFitWidth(250.0);
        logoImageViewer.setLayoutX(48.0);
        logoImageViewer.setLayoutY(56.0);
        logoImageViewer.setPickOnBounds(true);
        logoImageViewer.setPreserveRatio(true);
        logoImageViewer.setImage(new Image(getClass().getResource("../../../resources/assets/icons/icon.png").toExternalForm()));

        playVsplayBtn.setLayoutX(92.0);
        playVsplayBtn.setLayoutY(312.0);
        playVsplayBtn.setMnemonicParsing(false);
        playVsplayBtn.setOnAction(this::openPlayerVsPlayerPopup);
        playVsplayBtn.setText("   Play Vs Player   ");
        playVsplayBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        playVsplayBtn.setFont(new Font(14.0));

        playVscompBtn.setLayoutX(93.0);
        playVscompBtn.setLayoutY(245.0);
        playVscompBtn.setMnemonicParsing(false);
        playVscompBtn.setOnAction(this::openPlayerVsComputerPopup);
        playVscompBtn.setText("Play Vs Computer");
        playVscompBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        playVscompBtn.setFont(new Font(14.0));
        BorderPane.setMargin(anchorPane, new Insets(0.0));
        borderPane.setCenter(anchorPane);

        BorderPane.setAlignment(header1, javafx.geometry.Pos.CENTER);
        header1.setSpacing(20.0);

        vBox0.setAlignment(javafx.geometry.Pos.CENTER);

        connectionIndicatorImageView.setFitHeight(40.0);
        connectionIndicatorImageView.setFitWidth(40.0);
        connectionIndicatorImageView.setPickOnBounds(true);
        connectionIndicatorImageView.setPreserveRatio(true);
        connectionIndicatorImageView.setImage(new Image(getClass().getResource("../../../resources/assets/icons/Wifi-off.png").toExternalForm()));

        connectionLabel.setText("Offline");

        HBox.setHgrow(region0, javafx.scene.layout.Priority.ALWAYS);
        region0.setPrefHeight(47.0);
        region0.setPrefWidth(132.0);

        signInBtn.setLayoutX(645.0);
        signInBtn.setLayoutY(30.0);
        signInBtn.setMnemonicParsing(false);
        signInBtn.setOnAction(this::singIn);
        signInBtn.getStyleClass().add("bigBtn");
        signInBtn.setText("Sign in");

        region1.setLayoutX(175.0);
        region1.setLayoutY(10.0);
        region1.setPrefHeight(47.0);
        region1.setPrefWidth(219.0);

        chatBtn.setLayoutX(175.0);
        chatBtn.setLayoutY(10.0);
        chatBtn.setMnemonicParsing(false);
        chatBtn.setOnAction(this::openChat);
        chatBtn.getStyleClass().add("bigBtn");
        chatBtn.setText("Chat");
        header1.setPadding(new Insets(0.0, 20.0, 20.0, 20.0));
        borderPane.setBottom(header1);

        getChildren().add(imageView);
        header.getChildren().add(region);
        header.getChildren().add(settingsBtn);
        header.getChildren().add(exitBtn);
        stackPane.getChildren().add(rectangle);
        anchorPane0.getChildren().add(logoImageViewer);
        anchorPane0.getChildren().add(playVsplayBtn);
        anchorPane0.getChildren().add(playVscompBtn);
        stackPane.getChildren().add(anchorPane0);
        vBox.getChildren().add(stackPane);
        anchorPane.getChildren().add(vBox);
        vBox0.getChildren().add(connectionIndicatorImageView);
        header1.getChildren().add(vBox0);
        header1.getChildren().add(connectionLabel);
        header1.getChildren().add(region0);
        header1.getChildren().add(signInBtn);
        header1.getChildren().add(region1);
        header1.getChildren().add(chatBtn);
        getChildren().add(borderPane);

    }

    protected abstract void openSettingsScreen(javafx.event.ActionEvent actionEvent);

    protected abstract void exitApp(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsPlayerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsComputerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void singIn(javafx.event.ActionEvent actionEvent);

    protected abstract void openChat(javafx.event.ActionEvent actionEvent);

}
