package tictactoe.homescreen;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
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
    protected final BoxBlur boxBlur;
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
    protected final Button button;
    protected final Button button0;
    protected final VBox vBox0;
    protected final ImageView profileImageView;

    public FXMLHomeScreenBase() {

        imageView = new ImageView();
        boxBlur = new BoxBlur();
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
        button = new Button();
        button0 = new Button();
        vBox0 = new VBox();
        profileImageView = new ImageView();

        imageView.setFitHeight(10000.0);
        imageView.setFitWidth(720.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/icons/hsBackground.jpg").toExternalForm()));

        imageView.setEffect(boxBlur);

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
        connectionLabel.setText("Online");
        connectionLabel.setTextFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        connectionLabel.setFont(new Font("Stencil", 25.0));
        hBox0.setOpaqueInsets(new Insets(0.0, 0.0, 0.0, 20.0));

        HBox.setHgrow(region, javafx.scene.layout.Priority.ALWAYS);

        chatBtn.setMnemonicParsing(false);
        chatBtn.setOnAction(this::openChat);
        chatBtn.setStyle("-fx-background-color: #3E5879; -fx-border-radius: 5; -fx-background-radius: 8;");
        chatBtn.getStyleClass().add("bigBtn");
        chatBtn.setText("Chat");
        chatBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        HBox.setMargin(chatBtn, new Insets(0.0, 40.0, 20.0, 0.0));
        chatBtn.setFont(new Font("Stencil", 14.0));
        borderPane.setBottom(hBox);

        BorderPane.setAlignment(header, javafx.geometry.Pos.CENTER);
        header.setSpacing(20.0);
        header.getStylesheets().add("/styling/generalStyle.css");

        HBox.setHgrow(region0, javafx.scene.layout.Priority.ALWAYS);

        HBox.setHgrow(settingsBtn, javafx.scene.layout.Priority.NEVER);
        settingsBtn.setMnemonicParsing(false);
        settingsBtn.setOnAction(this::openSettingsScreen);
        settingsBtn.getStyleClass().add("bigBtn");
        settingsBtn.setText("Settings");

        exitBtn.setLayoutX(645.0);
        exitBtn.setLayoutY(30.0);
        exitBtn.setMinWidth(31.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::exitApp);
        exitBtn.setPrefHeight(32.0);
        exitBtn.setPrefWidth(31.0);
        exitBtn.getStyleClass().add("bigBtn");
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
        rectangle.setHeight(420.0);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#334d94"));
        rectangle.setStrokeDashOffset(20.0);
        rectangle.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        rectangle.setWidth(300.0);

        dropShadow.setColor(javafx.scene.paint.Color.web("#6d78b0"));
        rectangle.setEffect(dropShadow);

        AnchorPane.setBottomAnchor(logoImageViewer, 211.0);
        AnchorPane.setLeftAnchor(logoImageViewer, 26.0);
        AnchorPane.setRightAnchor(logoImageViewer, 25.634613037109375);
        AnchorPane.setTopAnchor(logoImageViewer, 59.0);
        logoImageViewer.setFitHeight(180.0);
        logoImageViewer.setFitWidth(285.0);
        logoImageViewer.setLayoutX(26.0);
        logoImageViewer.setLayoutY(59.0);
        logoImageViewer.setPickOnBounds(true);
        logoImageViewer.setPreserveRatio(true);
        logoImageViewer.setImage(new Image(getClass().getResource("/assets/icons/icon.png").toExternalForm()));

        button.setLayoutX(77.0);
        button.setLayoutY(328.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::openPlayerVsPlayerPopup);
        button.setStyle("-fx-background-color: #3E5879; -fx-border-radius: 5; -fx-background-radius: 8;");
        button.getStyleClass().add("bigBtn");
        button.setText("   Play Vs Player   ");
        button.setTextFill(javafx.scene.paint.Color.WHITE);
        button.setFont(new Font("Stencil", 14.0));
        button.setCursor(Cursor.HAND);

        button0.setLayoutX(77.0);
        button0.setLayoutY(269.0);
        button0.setMnemonicParsing(false);
        button0.setOnAction(this::openPlayerVsComputerPopup);
        button0.setStyle("-fx-background-color: #3E5879; -fx-border-radius: 8; -fx-background-radius: 8;");
        button0.getStyleClass().add("bigBtn");
        button0.setText("Play Vs Computer");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        button0.setFont(new Font("Stencil", 14.0));
        button0.setCursor(Cursor.HAND);
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
        anchorPane0.getChildren().add(button);
        anchorPane0.getChildren().add(button0);
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
