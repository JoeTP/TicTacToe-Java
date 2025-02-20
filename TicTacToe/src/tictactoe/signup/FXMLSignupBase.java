package tictactoe.signup;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLSignupBase extends BorderPane {

    protected final HBox hBox;
    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final Text signupTitle;
    protected final VBox vBox;
    protected final AnchorPane anchorPane0;
    protected final Button signupBtn;
    protected final TextField usernameTextField;
    protected final Text chooseCharText;
    protected final PasswordField passwordField;
    protected final TextField emailTextField;
    protected final Label label;
    protected final Button signinBtn;
    protected final HBox hBox0;
    protected final Button previousImageBtn;
    protected final ImageView imageView;
    protected final ImageView characterImageView;
    protected final Button nextImageBtn;
    protected final ImageView imageView0;
    protected final HBox hBox1;
    protected final ImageView helperImageView;
    protected final TextField ipTextField;
    protected final Hyperlink connectToServerButton;

    public FXMLSignupBase() {

        hBox = new HBox();
        anchorPane = new AnchorPane();
        backBtn = new Button();
        signupTitle = new Text();
        vBox = new VBox();
        anchorPane0 = new AnchorPane();
        signupBtn = new Button();
        usernameTextField = new TextField();
        chooseCharText = new Text();
        passwordField = new PasswordField();
        emailTextField = new TextField();
        label = new Label();
        signinBtn = new Button();
        hBox0 = new HBox();
        previousImageBtn = new Button();
        imageView = new ImageView();
        characterImageView = new ImageView();
        nextImageBtn = new Button();
        imageView0 = new ImageView();
        hBox1 = new HBox();
        helperImageView = new ImageView();
        ipTextField = new TextField();
        connectToServerButton = new Hyperlink();

        setPrefHeight(580.0);
        setPrefWidth(400.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/styling/generalStyle.css");

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setSpacing(120.0);

        HBox.setHgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);

        AnchorPane.setLeftAnchor(backBtn, 23.0);
        backBtn.setLayoutX(23.0);
        backBtn.setLayoutY(44.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setOnAction(this::handleBackButton);
        backBtn.setStyle("-fx-background-radius: 50;");
        backBtn.getStyleClass().add("bigBtn");
        backBtn.setText("B");

        signupTitle.setFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        signupTitle.setLayoutX(144.0);
        signupTitle.setLayoutY(70.0);
        signupTitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signupTitle.setStrokeWidth(0.0);
        signupTitle.getStyleClass().add("bigLabel");
        signupTitle.setText("Sign-up");
        signupTitle.setFont(new Font(48.0));
        BorderPane.setMargin(hBox, new Insets(0.0, 0.0, 10.0, 0.0));
        setTop(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setSpacing(20.0);

        VBox.setVgrow(anchorPane0, javafx.scene.layout.Priority.ALWAYS);
        anchorPane0.setPrefWidth(400.0);

        signupBtn.setLayoutX(142.0);
        signupBtn.setLayoutY(320.0);
        signupBtn.setMnemonicParsing(false);
        signupBtn.setOnAction(this::goToActiveUsers);
        signupBtn.setPrefHeight(43.0);
        signupBtn.setPrefWidth(112.0);
        signupBtn.getStyleClass().add("bigBtn");
        signupBtn.setText("Sign-Up");

        usernameTextField.setLayoutX(60.0);
        usernameTextField.setLayoutY(140.0);
        usernameTextField.setPrefHeight(48.0);
        usernameTextField.setPrefWidth(276.0);
        usernameTextField.setPromptText("User Name");

        chooseCharText.setFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        chooseCharText.setLayoutX(112.0);
        chooseCharText.setLayoutY(117.0);
        chooseCharText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        chooseCharText.setStrokeWidth(0.0);
        chooseCharText.setText("Choose Your Character");
        chooseCharText.setFont(new Font("Stencil", 14.0));

        passwordField.setLayoutX(60.0);
        passwordField.setLayoutY(260.0);
        passwordField.setPrefHeight(48.0);
        passwordField.setPrefWidth(276.0);
        passwordField.setPromptText("Passoword");

        emailTextField.setLayoutX(60.0);
        emailTextField.setLayoutY(200.0);
        emailTextField.setPrefHeight(48.0);
        emailTextField.setPrefWidth(276.0);
        emailTextField.setPromptText("E-mail");

        label.setLayoutX(106.0);
        label.setLayoutY(388.0);
        label.setStyle("-fx-font-size: 20;");
        label.setText("Have Account?");

        signinBtn.setLayoutX(183.0);
        signinBtn.setLayoutY(375.0);
        signinBtn.setMnemonicParsing(false);
        signinBtn.setOnAction(this::goToSignin);
        signinBtn.setPrefHeight(43.0);
        signinBtn.setPrefWidth(112.0);
        signinBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #3e5879; -fx-font-size: 20;");
        signinBtn.setText("Sign-In");
        signinBtn.setUnderline(true);

        AnchorPane.setLeftAnchor(hBox0, 98.0);
        AnchorPane.setRightAnchor(hBox0, 98.0);
        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setLayoutX(98.0);
        hBox0.setLayoutY(30.0);

        previousImageBtn.setMnemonicParsing(false);
        previousImageBtn.setOnAction(this::showPreviousIcon);
        previousImageBtn.getStyleClass().add("bigBtn");
        previousImageBtn.setText("Back");
        HBox.setMargin(previousImageBtn, new Insets(10.0));

        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/assets/icons/angle-left.png").toExternalForm()));
        previousImageBtn.setGraphic(imageView);

        characterImageView.setFitHeight(64.0);
        characterImageView.setFitWidth(64.0);
        characterImageView.setPickOnBounds(true);
        characterImageView.setPreserveRatio(true);

        nextImageBtn.setMnemonicParsing(false);
        nextImageBtn.setOnAction(this::showNextIcon);
        nextImageBtn.getStyleClass().add("bigBtn");
        nextImageBtn.setText("Next");
        HBox.setMargin(nextImageBtn, new Insets(10.0));

        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/assets/icons/angle-right.png").toExternalForm()));
        nextImageBtn.setGraphic(imageView0);

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setLayoutX(52.0);
        hBox1.setLayoutY(430.0);
        hBox1.setSpacing(10.0);

        helperImageView.setAccessibleHelp("write IP address of the device running server (leave it empty if you are running the server)");
        helperImageView.setFitHeight(30.0);
        helperImageView.setFitWidth(30.0);
        helperImageView.setOpacity(0.4);
        helperImageView.setPickOnBounds(true);
        helperImageView.setPreserveRatio(true);
        helperImageView.setImage(new Image(getClass().getResource("/assets/icons/help.png").toExternalForm()));

        ipTextField.setPromptText("Server IP");

        connectToServerButton.setOnAction(this::handleConnectToServerButton);
        connectToServerButton.setText("Connect");
        setCenter(vBox);

        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(signupTitle);
        hBox.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(signupBtn);
        anchorPane0.getChildren().add(usernameTextField);
        anchorPane0.getChildren().add(chooseCharText);
        anchorPane0.getChildren().add(passwordField);
        anchorPane0.getChildren().add(emailTextField);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(signinBtn);
        hBox0.getChildren().add(previousImageBtn);
        hBox0.getChildren().add(characterImageView);
        hBox0.getChildren().add(nextImageBtn);
        anchorPane0.getChildren().add(hBox0);
        hBox1.getChildren().add(helperImageView);
        hBox1.getChildren().add(ipTextField);
        hBox1.getChildren().add(connectToServerButton);
        anchorPane0.getChildren().add(hBox1);
        vBox.getChildren().add(anchorPane0);

    }

    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

    protected abstract void goToActiveUsers(javafx.event.ActionEvent actionEvent);

    protected abstract void goToSignin(javafx.event.ActionEvent actionEvent);

    protected abstract void showPreviousIcon(javafx.event.ActionEvent actionEvent);

    protected abstract void showNextIcon(javafx.event.ActionEvent actionEvent);

    protected abstract void handleConnectToServerButton(javafx.event.ActionEvent actionEvent);

}
