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
    protected final StackPane stackPane;
    protected final Button signInButton;
    protected final VBox accInfoRect;
    protected final Label nameLabel;
    protected final HBox hBox;
    protected final ImageView profileImageView;
    protected final HBox hBox0;
    protected final VBox vBox;
    protected final Label label;
    protected final Label rankStarLabel;
    protected final VBox vBox0;
    protected final Label label0;
    protected final Label wonGamesLabel;
    protected final VBox vBox1;
    protected final Label label1;
    protected final Label playedGamesLabel;
    protected final HBox hBox1;
    protected final Button logoutButton;
    protected final ImageView imageView0;
    protected final Region region;
    protected final Button historyButton;
    protected final ImageView imageView1;
    protected final Button settingsBtn;
    protected final Button exitBtn;
    protected final AnchorPane anchorPane;
    protected final VBox vBox2;
    protected final StackPane stackPane0;
    protected final Rectangle rectangle;
    protected final DropShadow dropShadow;
    protected final AnchorPane anchorPane0;
    protected final ImageView logoImageViewer;
    protected final Button playVsplayBtn;
    protected final Button playVscompBtn;
    protected final HBox header1;
    protected final VBox vBox3;
    protected final ImageView connectionIndicatorImageView;
    protected final VBox vBox4;
    protected final Label connectionLabel;
    protected final Region region0;
    protected final VBox vBox5;
    protected final Button chatBtn;

    public FXMLHomeScreenBase() {

        imageView = new ImageView();
        borderPane = new BorderPane();
        header = new HBox();
        stackPane = new StackPane();
        signInButton = new Button();
        accInfoRect = new VBox();
        nameLabel = new Label();
        hBox = new HBox();
        profileImageView = new ImageView();
        hBox0 = new HBox();
        vBox = new VBox();
        label = new Label();
        rankStarLabel = new Label();
        vBox0 = new VBox();
        label0 = new Label();
        wonGamesLabel = new Label();
        vBox1 = new VBox();
        label1 = new Label();
        playedGamesLabel = new Label();
        hBox1 = new HBox();
        logoutButton = new Button();
        imageView0 = new ImageView();
        region = new Region();
        historyButton = new Button();
        imageView1 = new ImageView();
        settingsBtn = new Button();
        exitBtn = new Button();
        anchorPane = new AnchorPane();
        vBox2 = new VBox();
        stackPane0 = new StackPane();
        rectangle = new Rectangle();
        dropShadow = new DropShadow();
        anchorPane0 = new AnchorPane();
        logoImageViewer = new ImageView();
        playVsplayBtn = new Button();
        playVscompBtn = new Button();
        header1 = new HBox();
        vBox3 = new VBox();
        connectionIndicatorImageView = new ImageView();
        vBox4 = new VBox();
        connectionLabel = new Label();
        region0 = new Region();
        vBox5 = new VBox();
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

        stackPane.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        HBox.setMargin(stackPane, new Insets(0.0));

        signInButton.setMnemonicParsing(false);
        signInButton.setOnAction(this::handleSignInButton);
        signInButton.setText("Sign in");
        StackPane.setMargin(signInButton, new Insets(20.0, 0.0, 0.0, 20.0));

        accInfoRect.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        accInfoRect.setPrefHeight(130.0);
        accInfoRect.setPrefWidth(321.0);
        accInfoRect.setSpacing(5.0);
        accInfoRect.getStyleClass().add("rect");
        accInfoRect.getStylesheets().add("/tictactoe/homescreen/style.css");

        nameLabel.setPrefHeight(28.0);
        nameLabel.setPrefWidth(230.0);
        nameLabel.setText("Name");
        VBox.setMargin(nameLabel, new Insets(10.0, 0.0, 0.0, 20.0));

        hBox.setPrefHeight(30.0);
        hBox.setSpacing(5.0);

        profileImageView.setFitHeight(50.0);
        profileImageView.setFitWidth(50.0);
        profileImageView.setPickOnBounds(true);
        profileImageView.setPreserveRatio(true);
        HBox.setMargin(profileImageView, new Insets(0.0, 0.0, 0.0, 15.0));

        HBox.setHgrow(hBox0, javafx.scene.layout.Priority.ALWAYS);
        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(30.0);
        hBox0.setPrefWidth(163.0);
        hBox0.setSpacing(40.0);

        HBox.setHgrow(vBox, javafx.scene.layout.Priority.ALWAYS);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        label.setText("Rank");

        rankStarLabel.setLayoutX(23.0);
        rankStarLabel.setLayoutY(10.0);
        rankStarLabel.setText("?");

        HBox.setHgrow(vBox0, javafx.scene.layout.Priority.ALWAYS);
        vBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        label0.setText("Won");

        wonGamesLabel.setLayoutX(23.0);
        wonGamesLabel.setLayoutY(10.0);

        HBox.setHgrow(vBox1, javafx.scene.layout.Priority.ALWAYS);
        vBox1.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        label1.setText("Games");

        playedGamesLabel.setLayoutX(23.0);
        playedGamesLabel.setLayoutY(10.0);
        HBox.setMargin(hBox0, new Insets(0.0, 10.0, 0.0, 10.0));

        VBox.setVgrow(hBox1, javafx.scene.layout.Priority.NEVER);
        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setSpacing(20.0);

        logoutButton.setMnemonicParsing(false);
        logoutButton.setOnAction(this::handleLogoutButton);

        imageView0.setFitHeight(20.0);
        imageView0.setFitWidth(20.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/assets/icons/logout.png").toExternalForm()));
        logoutButton.setGraphic(imageView0);
        hBox1.setPadding(new Insets(0.0, 0.0, 10.0, 20.0));
        accInfoRect.setOpaqueInsets(new Insets(0.0));

        HBox.setHgrow(region, javafx.scene.layout.Priority.ALWAYS);
        region.setPrefHeight(130.0);
        region.setPrefWidth(181.0);

        historyButton.setMnemonicParsing(false);
        historyButton.setOnAction(this::handleHistoryButton);

        imageView1.setFitHeight(23.0);
        imageView1.setFitWidth(23.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/assets/icons/history.png").toExternalForm()));
        historyButton.setGraphic(imageView1);
        HBox.setMargin(historyButton, new Insets(20.0, 0.0, 0.0, 0.0));

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

        vBox2.setAlignment(javafx.geometry.Pos.CENTER);
        vBox2.setLayoutX(205.0);
        vBox2.setLayoutY(88.0);
        vBox2.setSpacing(20.0);

        stackPane0.setLayoutX(222.0);
        stackPane0.setLayoutY(54.0);

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

        vBox3.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);

        connectionIndicatorImageView.setFitHeight(40.0);
        connectionIndicatorImageView.setFitWidth(40.0);
        connectionIndicatorImageView.setPickOnBounds(true);
        connectionIndicatorImageView.setPreserveRatio(true);
        connectionIndicatorImageView.setImage(new Image(getClass().getResource("/assets/icons/Wifi-off.png").toExternalForm()));
        vBox3.setOpaqueInsets(new Insets(0.0));
        vBox3.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));

        vBox4.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);

        connectionLabel.setText("Offline");
        vBox4.setPadding(new Insets(0.0, 0.0, 20.0, 0.0));

        HBox.setHgrow(region0, javafx.scene.layout.Priority.ALWAYS);

        vBox5.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);

        chatBtn.setMnemonicParsing(false);
        chatBtn.setOnAction(this::openChat);
        chatBtn.getStyleClass().add("bigBtn");
        chatBtn.setText("Chat");
        HBox.setMargin(vBox5, new Insets(0.0, 0.0, 20.0, 0.0));
        header1.setPadding(new Insets(0.0, 20.0, 0.0, 20.0));
        borderPane.setBottom(header1);

        getChildren().add(imageView);
        stackPane.getChildren().add(signInButton);
        accInfoRect.getChildren().add(nameLabel);
        hBox.getChildren().add(profileImageView);
        vBox.getChildren().add(label);
        vBox.getChildren().add(rankStarLabel);
        hBox0.getChildren().add(vBox);
        vBox0.getChildren().add(label0);
        vBox0.getChildren().add(wonGamesLabel);
        hBox0.getChildren().add(vBox0);
        vBox1.getChildren().add(label1);
        vBox1.getChildren().add(playedGamesLabel);
        hBox0.getChildren().add(vBox1);
        hBox.getChildren().add(hBox0);
        accInfoRect.getChildren().add(hBox);
        hBox1.getChildren().add(logoutButton);
        accInfoRect.getChildren().add(hBox1);
        stackPane.getChildren().add(accInfoRect);
        header.getChildren().add(stackPane);
        header.getChildren().add(region);
        header.getChildren().add(historyButton);
        header.getChildren().add(settingsBtn);
        header.getChildren().add(exitBtn);
        anchorPane.getChildren().add(vBox2);
        stackPane0.getChildren().add(rectangle);
        anchorPane0.getChildren().add(logoImageViewer);
        anchorPane0.getChildren().add(playVsplayBtn);
        anchorPane0.getChildren().add(playVscompBtn);
        stackPane0.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(stackPane0);
        vBox3.getChildren().add(connectionIndicatorImageView);
        header1.getChildren().add(vBox3);
        vBox4.getChildren().add(connectionLabel);
        header1.getChildren().add(vBox4);
        header1.getChildren().add(region0);
        vBox5.getChildren().add(chatBtn);
        header1.getChildren().add(vBox5);
        getChildren().add(borderPane);

    }

    protected abstract void dragWindow(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void getOffset(javafx.scene.input.MouseEvent mouseEvent);

    protected abstract void handleSignInButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleLogoutButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleHistoryButton(javafx.event.ActionEvent actionEvent);

    protected abstract void openSettingsScreen(javafx.event.ActionEvent actionEvent);

    protected abstract void exitApp(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsPlayerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void openPlayerVsComputerPopup(javafx.event.ActionEvent actionEvent);

    protected abstract void openChat(javafx.event.ActionEvent actionEvent);

}
