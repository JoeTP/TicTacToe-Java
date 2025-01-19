package tictactoe.signin;

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

public abstract class FXMLSigninBase extends BorderPane {

    protected final HBox hBox;
    protected final AnchorPane anchorPane;
    protected final Button backBtn;
    protected final Text signinTitle;
    protected final VBox vBox;
    protected final AnchorPane anchorPane0;
    protected final Label wrongLabel;
    protected final Button signinBtn;
    protected final Text text;
    protected final Button signupBtn;
    protected final TextField usernameTextField;
    protected final PasswordField passwordField;
    protected final HBox hBox0;
    protected final ImageView helperImageView;
    protected final TextField ipTextField;
    protected final Hyperlink connectToServerButton;

    public FXMLSigninBase() {

        hBox = new HBox();
        anchorPane = new AnchorPane();
        backBtn = new Button();
        signinTitle = new Text();
        vBox = new VBox();
        anchorPane0 = new AnchorPane();
        wrongLabel = new Label();
        signinBtn = new Button();
        text = new Text();
        signupBtn = new Button();
        usernameTextField = new TextField();
        passwordField = new PasswordField();
        hBox0 = new HBox();
        helperImageView = new ImageView();
        ipTextField = new TextField();
        connectToServerButton = new Hyperlink();

        setPrefHeight(552.0);
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
        backBtn.setStyle("-fx-border-radius: 50; -fx-background-radius: 50;");
        backBtn.getStyleClass().add("bigBtn");
        backBtn.setText("B");

        signinTitle.setFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        signinTitle.setLayoutX(154.0);
        signinTitle.setLayoutY(69.0);
        signinTitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signinTitle.setStrokeWidth(0.0);
        signinTitle.getStyleClass().add("bigLabel");
        signinTitle.setText("Sign-in");
        signinTitle.setFont(new Font(48.0));
        BorderPane.setMargin(hBox, new Insets(0.0, 0.0, 10.0, 0.0));
        setTop(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setSpacing(20.0);

        VBox.setVgrow(anchorPane0, javafx.scene.layout.Priority.ALWAYS);

        wrongLabel.setLayoutX(77.0);
        wrongLabel.setLayoutY(204.0);
        wrongLabel.setText("Please Enter correct info");
        wrongLabel.setVisible(false);

        signinBtn.setLayoutX(143.0);
        signinBtn.setLayoutY(252.0);
        signinBtn.setMnemonicParsing(false);
        signinBtn.setOnAction(this::goToActiveUsers);
        signinBtn.setPrefHeight(43.0);
        signinBtn.setPrefWidth(112.0);
        signinBtn.getStyleClass().add("bigBtn");
        signinBtn.setText("Sign-in");

        text.setFill(javafx.scene.paint.Color.valueOf("#3e5879"));
        text.setLayoutX(62.0);
        text.setLayoutY(340.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Don't you have an account?");
        text.setFont(new Font("Chicle Regular", 20.0));

        signupBtn.setLayoutX(241.0);
        signupBtn.setLayoutY(304.0);
        signupBtn.setMnemonicParsing(false);
        signupBtn.setOnAction(this::goToSignup);
        signupBtn.setStyle("-fx-text-fill: #3e5879; -fx-background-color: transparent; -fx-font-size: 20;");
        signupBtn.getStyleClass().add("bigBtn");
        signupBtn.setText("Sign-up");
        signupBtn.setUnderline(true);

        usernameTextField.setLayoutX(62.0);
        usernameTextField.setLayoutY(78.0);
        usernameTextField.setPrefHeight(48.0);
        usernameTextField.setPrefWidth(276.0);
        usernameTextField.setPromptText("User Name");

        passwordField.setLayoutX(62.0);
        passwordField.setLayoutY(147.0);
        passwordField.setPrefHeight(48.0);
        passwordField.setPrefWidth(276.0);
        passwordField.setPromptText("Passoword");

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setLayoutX(60.0);
        hBox0.setLayoutY(396.0);
        hBox0.setSpacing(10.0);

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
        anchorPane.getChildren().add(signinTitle);
        hBox.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(wrongLabel);
        anchorPane0.getChildren().add(signinBtn);
        anchorPane0.getChildren().add(text);
        anchorPane0.getChildren().add(signupBtn);
        anchorPane0.getChildren().add(usernameTextField);
        anchorPane0.getChildren().add(passwordField);
        hBox0.getChildren().add(helperImageView);
        hBox0.getChildren().add(ipTextField);
        hBox0.getChildren().add(connectToServerButton);
        anchorPane0.getChildren().add(hBox0);
        vBox.getChildren().add(anchorPane0);

    }

    protected abstract void handleBackButton(javafx.event.ActionEvent actionEvent);

    protected abstract void goToActiveUsers(javafx.event.ActionEvent actionEvent);

    protected abstract void goToSignup(javafx.event.ActionEvent actionEvent);

    protected abstract void handleConnectToServerButton(javafx.event.ActionEvent actionEvent);

}
