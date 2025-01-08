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
import static shared.AppString.GENERAL_STYLE_FILE_PATH;
import static shared.AppString.LOGO;

public abstract class FXMLHomeScreenBase extends StackPane {

    protected final ImageView imageView;
    protected final BorderPane borderPane;
    protected final HBox hBox;
    protected final HBox hBox0;
    protected final ImageView connectionIndicatorImageView;
    protected final Label connectionLabel;
    protected final Region region;
    protected final Button chatBtn;
    protected final HBox header;
    protected final Region region0;
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
    protected final VBox vBox0;
    protected final ImageView profileImageView;

    public FXMLHomeScreenBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        hBox = new HBox();
        hBox0 = new HBox();
        connectionIndicatorImageView = new ImageView();
        connectionLabel = new Label();
        region = new Region();
        chatBtn = new Button();
        header = new HBox();
        region0 = new Region();
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
        vBox0 = new VBox();
        profileImageView = new ImageView();

        getStylesheets().add(GENERAL_STYLE_FILE_PATH);

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

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER_LEFT);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setSpacing(10.0);

        connectionIndicatorImageView.setFitHeight(40.0);
        connectionIndicatorImageView.setFitWidth(40.0);
        connectionIndicatorImageView.setPickOnBounds(true);
        connectionIndicatorImageView.setPreserveRatio(true);
        HBox.setMargin(connectionIndicatorImageView, new Insets(0.0, 0.0, 0.0, 20.0));

        connectionLabel.setAlignment(javafx.geometry.Pos.CENTER);
        connectionLabel.getStyleClass().add("bigLabel");
        connectionLabel.setText("Online");
        hBox0.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 20.0));

        HBox.setHgrow(region, javafx.scene.layout.Priority.ALWAYS);

        chatBtn.setMnemonicParsing(false);
        chatBtn.setOnAction(this::openChat);
        chatBtn.setText("Chat");
        chatBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        HBox.setMargin(chatBtn, new Insets(0.0, 40.0, 20.0, 0.0));
        chatBtn.setFont(new Font(14.0));
        borderPane.setBottom(hBox);

        BorderPane.setAlignment(header, javafx.geometry.Pos.CENTER);
        header.setSpacing(20.0);

        HBox.setHgrow(region0, javafx.scene.layout.Priority.ALWAYS);

        HBox.setHgrow(settingsBtn, javafx.scene.layout.Priority.NEVER);
        settingsBtn.setMnemonicParsing(false);
        settingsBtn.setOnAction(this::openSettingsScreen);
        settingsBtn.setText("Settings");

        exitBtn.setLayoutX(645.0);
        exitBtn.setLayoutY(30.0);
        exitBtn.setMinWidth(31.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::exitApp);
        exitBtn.setPrefHeight(32.0);
        exitBtn.setPrefWidth(31.0);
        exitBtn.setText("X");
        HBox.setMargin(exitBtn, new Insets(0.0, 15.0, 0.0, 0.0));
        header.setPadding(new Insets(20.0, 20.0, 0.0, 0.0));
        borderPane.setTop(header);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setLayoutX(117.0);
        vBox.setLayoutY(71.0);
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

        dropShadow.setColor(javafx.scene.paint.Color.web("#6d78b0"));
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
        logoImageViewer.setImage(new Image(getClass().getResource(LOGO).toExternalForm()));

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

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.BOTTOM_LEFT);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);

        profileImageView.setFitHeight(67.0);
        profileImageView.setFitWidth(89.0);
        profileImageView.setPickOnBounds(true);
        profileImageView.setPreserveRatio(true);
        BorderPane.setMargin(vBox0, new Insets(0.0));
        vBox0.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));
        borderPane.setLeft(vBox0);

        getChildren().add(imageView);
        hBox0.getChildren().add(connectionIndicatorImageView);
        hBox0.getChildren().add(connectionLabel);
        hBox.getChildren().add(hBox0);
        hBox.getChildren().add(region);
        hBox.getChildren().add(chatBtn);
        header.getChildren().add(region0);
        header.getChildren().add(settingsBtn);
        header.getChildren().add(exitBtn);
        stackPane.getChildren().add(rectangle);
        anchorPane0.getChildren().add(logoImageViewer);
        anchorPane0.getChildren().add(playVsplayBtn);
        anchorPane0.getChildren().add(playVscompBtn);
        stackPane.getChildren().add(anchorPane0);
        vBox.getChildren().add(stackPane);
        anchorPane.getChildren().add(vBox);
        vBox0.getChildren().add(profileImageView);
        getChildren().add(borderPane);

    }

    protected abstract void openChat(javafx.event.ActionEvent actionEvent);

    protected abstract void openSettingsScreen(javafx.event.ActionEvent actionEvent);

    protected abstract void exitApp(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsPlayerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsComputerPopup(javafx.event.ActionEvent actionEvent);

}
