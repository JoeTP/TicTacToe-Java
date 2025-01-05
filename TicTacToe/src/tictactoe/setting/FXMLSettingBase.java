package tictactoe.setting;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLSettingBase extends BorderPane {

    protected final HBox hBox;
    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final Text signinTitle;
    protected final VBox accountHeaderVBox;
    protected final AnchorPane anchorPane0;
    protected final Rectangle rectangle;
    protected final Separator separator;
    protected final ToggleButton soundToggleBtn;
    protected final ImageView imageView;
    protected final Label label;
    protected final ToggleButton themeToggleBtn;
    protected final ImageView imageView0;
    protected final Label label0;
    protected final ToggleButton langToggleBtn;
    protected final ImageView imageView1;
    protected final Label label1;
    protected final Label label2;
    protected final MenuButton menuBtn;
    protected final MenuItem userNameMenuItem;
    protected final Text userNameText;
    protected final MenuItem iconMenuItem;
    protected final ImageView userIconImage;
    protected final MenuItem emailMenuItem;
    protected final Text emailText;
    protected final ImageView menuBtnIcon;

    public FXMLSettingBase() {

        hBox = new HBox();
        anchorPane = new AnchorPane();
        backBtn = new Button();
        signinTitle = new Text();
        accountHeaderVBox = new VBox();
        anchorPane0 = new AnchorPane();
        rectangle = new Rectangle();
        separator = new Separator();
        soundToggleBtn = new ToggleButton();
        imageView = new ImageView();
        label = new Label();
        themeToggleBtn = new ToggleButton();
        imageView0 = new ImageView();
        label0 = new Label();
        langToggleBtn = new ToggleButton();
        imageView1 = new ImageView();
        label1 = new Label();
        label2 = new Label();
        menuBtn = new MenuButton();
        userNameMenuItem = new MenuItem();
        userNameText = new Text();
        iconMenuItem = new MenuItem();
        userIconImage = new ImageView();
        emailMenuItem = new MenuItem();
        emailText = new Text();
        menuBtnIcon = new ImageView();

        setPrefHeight(720.0);
        setPrefWidth(720.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setSpacing(120.0);

        HBox.setHgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);

        AnchorPane.setLeftAnchor(backBtn, 23.0);
        backBtn.setLayoutX(23.0);
        backBtn.setLayoutY(44.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setOnAction(this::handleBackBtn);
        backBtn.setText("Back");

        signinTitle.setLayoutX(281.0);
        signinTitle.setLayoutY(82.0);
        signinTitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signinTitle.setStrokeWidth(0.0);
        signinTitle.setText("Setting");
        signinTitle.setFont(new Font(48.0));
        BorderPane.setMargin(hBox, new Insets(0.0, 0.0, 10.0, 0.0));
        setTop(hBox);

        BorderPane.setAlignment(accountHeaderVBox, javafx.geometry.Pos.CENTER);
        accountHeaderVBox.setPrefHeight(200.0);
        accountHeaderVBox.setPrefWidth(100.0);
        accountHeaderVBox.setSpacing(20.0);
        accountHeaderVBox.getStylesheets().add("/tictactoe/setting/toggleButtonStyle.css");

        VBox.setVgrow(anchorPane0, javafx.scene.layout.Priority.ALWAYS);
        anchorPane0.setAccessibleRole(javafx.scene.AccessibleRole.TOGGLE_BUTTON);
        anchorPane0.getStylesheets().add("/tictactoe/setting/toggleButtonStyle.css");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(375.0);
        rectangle.setLayoutX(171.0);
        rectangle.setLayoutY(88.0);
        rectangle.setStroke(javafx.scene.paint.Color.BLACK);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(360.0);

        separator.setLayoutX(171.0);
        separator.setLayoutY(183.0);
        separator.setPrefHeight(6.0);
        separator.setPrefWidth(361.0);

        soundToggleBtn.setId("sound-toggle");
        soundToggleBtn.setLayoutX(418.0);
        soundToggleBtn.setLayoutY(205.0);
        soundToggleBtn.setMnemonicParsing(false);
        soundToggleBtn.setPrefHeight(41.0);
        soundToggleBtn.setPrefWidth(89.0);
        soundToggleBtn.getStylesheets().add("/tictactoe/setting/toggleButtonStyle.css");

        imageView.setFitHeight(32.0);
        imageView.setFitWidth(32.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
         imageView.setImage(new Image(getClass().getResource("/assets/icons/sound.png").toExternalForm()));
        soundToggleBtn.setGraphic(imageView);

        label.setLayoutX(202.0);
        label.setLayoutY(215.0);
        label.setText("Sound");
        label.setFont(new Font(24.0));

        themeToggleBtn.setId("theme-toggle");
        themeToggleBtn.setLayoutX(418.0);
        themeToggleBtn.setLayoutY(286.0);
        themeToggleBtn.setMnemonicParsing(false);
        themeToggleBtn.setPrefHeight(41.0);
        themeToggleBtn.setPrefWidth(89.0);

        imageView0.setFitHeight(32.0);
        imageView0.setFitWidth(32.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
             imageView0.setImage(new Image(getClass().getResource("/assets/icons/dark-theme.png").toExternalForm()));
        themeToggleBtn.setGraphic(imageView0);

        label0.setLayoutX(200.0);
        label0.setLayoutY(290.0);
        label0.setText("Theme");
        label0.setFont(new Font(24.0));

        langToggleBtn.setId("lang-toggle");
        langToggleBtn.setLayoutX(420.0);
        langToggleBtn.setLayoutY(376.0);
        langToggleBtn.setMnemonicParsing(false);
        langToggleBtn.setPrefHeight(41.0);
        langToggleBtn.setPrefWidth(89.0);

        imageView1.setFitHeight(30.0);
        imageView1.setFitWidth(93.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
           imageView1.setImage(new Image(getClass().getResource("/assets/icons/english.png").toExternalForm()));
        langToggleBtn.setGraphic(imageView1);

        label1.setLayoutX(200.0);
        label1.setLayoutY(380.0);
        label1.setText("Language");
        label1.setFont(new Font(24.0));

        label2.setLayoutX(182.0);
        label2.setLayoutY(120.0);
        label2.setText("Account Information");
        label2.setFont(new Font(24.0));

        menuBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        menuBtn.setGraphicTextGap(9.0);
        menuBtn.setLayoutX(419.0);
        menuBtn.setLayoutY(107.0);
        menuBtn.setMnemonicParsing(false);
        menuBtn.setPopupSide(javafx.geometry.Side.RIGHT);
        menuBtn.setPrefHeight(47.0);
        menuBtn.setPrefWidth(62.0);
        menuBtn.getStylesheets().add("/tictactoe/setting/menuButtonStyling.css");

        userNameMenuItem.setMnemonicParsing(false);

        userNameText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userNameText.setStrokeWidth(0.0);
        userNameText.setText("Ayat Gamal");
        userNameMenuItem.setGraphic(userNameText);

        iconMenuItem.setMnemonicParsing(false);

        userIconImage.setFitHeight(32.0);
        userIconImage.setFitWidth(32.0);
        userIconImage.setPickOnBounds(true);
        userIconImage.setPreserveRatio(true);
        userIconImage.setImage(new Image(getClass().getResource("/assets/icons/dinosaur.png").toExternalForm()));
        iconMenuItem.setGraphic(userIconImage);

        emailMenuItem.setMnemonicParsing(false);

        emailText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        emailText.setStrokeWidth(0.0);
        emailText.setText("AyatGa@gmail.com");
        emailMenuItem.setGraphic(emailText);

        menuBtnIcon.setFitHeight(32.0);
        menuBtnIcon.setFitWidth(32.0);
        menuBtnIcon.setPickOnBounds(true);
        menuBtnIcon.setPreserveRatio(true);
        menuBtnIcon.setImage(new Image(getClass().getResource("/assets/icons/down.png").toExternalForm()));
        menuBtn.setGraphic(menuBtnIcon);
        menuBtn.setOpaqueInsets(new Insets(0.0));
        setCenter(accountHeaderVBox);

        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(signinTitle);
        hBox.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(rectangle);
        anchorPane0.getChildren().add(separator);
        anchorPane0.getChildren().add(soundToggleBtn);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(themeToggleBtn);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(langToggleBtn);
        anchorPane0.getChildren().add(label1);
        anchorPane0.getChildren().add(label2);
        menuBtn.getItems().add(userNameMenuItem);
        menuBtn.getItems().add(iconMenuItem);
        menuBtn.getItems().add(emailMenuItem);
        anchorPane0.getChildren().add(menuBtn);
        accountHeaderVBox.getChildren().add(anchorPane0);

    }

    protected abstract void handleBackBtn(javafx.event.ActionEvent actionEvent);

}
