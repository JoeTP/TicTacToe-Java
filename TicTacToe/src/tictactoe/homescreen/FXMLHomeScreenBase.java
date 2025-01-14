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
    protected final VBox vBox;
    protected final Button signInButton;
    protected final Region region;
    protected final Button settingsBtn;
    protected final Button exitBtn;
    protected final AnchorPane anchorPane;
    protected final VBox vBox0;
    protected final StackPane stackPane;
    protected final Rectangle rectangle;
    protected final DropShadow dropShadow;
    protected final AnchorPane anchorPane0;
    protected final ImageView logoImageViewer;
    protected final Button playVsplayBtn;
    protected final Button playVscompBtn;
    protected final HBox header1;
    protected final VBox vBox1;
    protected final ImageView connectionIndicatorImageView;
    protected final VBox vBox2;
    protected final Label connectionLabel;
    protected final Region region0;
    protected final VBox vBox3;
    protected final Button chatBtn;

    public FXMLHomeScreenBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        header = new HBox();
        vBox = new VBox();
        signInButton = new Button();
        region = new Region();
        settingsBtn = new Button();
        exitBtn = new Button();
        anchorPane = new AnchorPane();
        vBox0 = new VBox();
        stackPane = new StackPane();
        rectangle = new Rectangle();
        dropShadow = new DropShadow();
        anchorPane0 = new AnchorPane();
        logoImageViewer = new ImageView();
        playVsplayBtn = new Button();
        playVscompBtn = new Button();
        header1 = new HBox();
        vBox1 = new VBox();
        connectionIndicatorImageView = new ImageView();
        vBox2 = new VBox();
        connectionLabel = new Label();
        region0 = new Region();
        vBox3 = new VBox();
        chatBtn = new Button();

        getStylesheets().add("/styling/generalStyle.css");

        imageView.setFitHeight(720.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/icons/hsBackground.jpg").toExternalForm()));

        borderPane.setMaxHeight(USE_PREF_SIZE);
        borderPane.setMaxWidth(USE_PREF_SIZE);
        borderPane.setMinHeight(USE_PREF_SIZE);
        borderPane.setMinWidth(USE_PREF_SIZE);
        borderPane.setPrefHeight(720.0);
        borderPane.setPrefWidth(720.0);

        BorderPane.setAlignment(header, javafx.geometry.Pos.CENTER);
        header.setOnMouseDragged(this::dragWindow);
        header.setOnMousePressed(this::getOffset);
        header.setSpacing(20.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(130.0);
        vBox.setPrefWidth(321.0);
        vBox.setSpacing(5.0);
        vBox.getStyleClass().add("rect");
        vBox.getStylesheets().add("/tictactoe/homescreen/style.css");

        signInButton.setMnemonicParsing(false);
        signInButton.setOnAction(this::handleSignInButton);
        signInButton.setText("Sign in");
        VBox.setMargin(signInButton, new Insets(0.0, 0.0, 0.0, 20.0));
        vBox.setOpaqueInsets(new Insets(0.0));
        HBox.setMargin(vBox, new Insets(0.0));

        HBox.setHgrow(region, javafx.scene.layout.Priority.ALWAYS);
        region.setPrefHeight(47.0);
        region.setPrefWidth(248.0);

        HBox.setHgrow(settingsBtn, javafx.scene.layout.Priority.NEVER);
        settingsBtn.setMnemonicParsing(false);
        settingsBtn.setOnAction(this::openSettingsScreen);
        settingsBtn.setPrefHeight(47.0);
        settingsBtn.setPrefWidth(97.0);
        settingsBtn.getStyleClass().add("bigBtn");
        settingsBtn.setText("Settings");
        HBox.setMargin(settingsBtn, new Insets(20.0, 0.0, 0.0, 0.0));

        exitBtn.setLayoutX(645.0);
        exitBtn.setLayoutY(30.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::exitApp);
        exitBtn.getStyleClass().add("bigBtn");
        exitBtn.setText("X");
        HBox.setMargin(exitBtn, new Insets(20.0, 0.0, 0.0, 0.0));
        header.setPadding(new Insets(0.0, 20.0, 0.0, 0.0));
        borderPane.setTop(header);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setMaxHeight(523.0);
        anchorPane.setMinHeight(485.0);
        anchorPane.setPrefHeight(523.0);
        anchorPane.setPrefWidth(720.0);

        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setLayoutX(205.0);
        vBox0.setLayoutY(88.0);
        vBox0.setSpacing(20.0);

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
        logoImageViewer.setImage(new Image(getClass().getResource("/assets/icons/icon.png").toExternalForm()));

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

        vBox1.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);

        connectionIndicatorImageView.setFitHeight(40.0);
        connectionIndicatorImageView.setFitWidth(40.0);
        connectionIndicatorImageView.setPickOnBounds(true);
        connectionIndicatorImageView.setPreserveRatio(true);
        connectionIndicatorImageView.setImage(new Image(getClass().getResource("/assets/icons/Wifi-off.png").toExternalForm()));
        vBox1.setOpaqueInsets(new Insets(0.0));
        vBox1.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));

        vBox2.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);

        connectionLabel.setText("Offline");
        vBox2.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));

        HBox.setHgrow(region0, javafx.scene.layout.Priority.ALWAYS);

        vBox3.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);

        chatBtn.setMnemonicParsing(false);
        chatBtn.setOnAction(this::openChat);
        chatBtn.getStyleClass().add("bigBtn");
        chatBtn.setText("Chat");
        HBox.setMargin(vBox3, new Insets(0.0, 0.0, 20.0, 0.0));
        header1.setPadding(new Insets(0.0, 20.0, 0.0, 20.0));
        borderPane.setBottom(header1);

        getChildren().add(imageView);
        vBox.getChildren().add(signInButton);
        header.getChildren().add(vBox);
        header.getChildren().add(region);
        header.getChildren().add(settingsBtn);
        header.getChildren().add(exitBtn);
        stackPane.getChildren().add(rectangle);
        anchorPane0.getChildren().add(logoImageViewer);
        anchorPane0.getChildren().add(playVsplayBtn);
        anchorPane0.getChildren().add(playVscompBtn);
        stackPane.getChildren().add(anchorPane0);
        vBox0.getChildren().add(stackPane);
        anchorPane.getChildren().add(vBox0);
        vBox1.getChildren().add(connectionIndicatorImageView);
        header1.getChildren().add(vBox1);
        vBox2.getChildren().add(connectionLabel);
        header1.getChildren().add(vBox2);
        header1.getChildren().add(region0);
        vBox3.getChildren().add(chatBtn);
        header1.getChildren().add(vBox3);
        getChildren().add(borderPane);

    }

    protected abstract void dragWindow(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void getOffset(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void handleSignInButton(javafx.event.ActionEvent actionEvent);

    protected abstract void openSettingsScreen(javafx.event.ActionEvent actionEvent);

    protected abstract void exitApp(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsPlayerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsComputerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void openChat(javafx.event.ActionEvent actionEvent);

}
