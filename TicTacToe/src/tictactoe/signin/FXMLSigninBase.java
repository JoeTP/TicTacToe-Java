package tictactoe.signin;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
    protected final ImageView userImg;
    protected final Button signinBtn;
    protected final Text text;
    protected final Button signupBtn;
    protected final TextField usernameTextField;
    protected final PasswordField passwordField;

    public FXMLSigninBase() {

        hBox = new HBox();
        anchorPane = new AnchorPane();
        backBtn = new Button();
        signinTitle = new Text();
        vBox = new VBox();
        anchorPane0 = new AnchorPane();
        userImg = new ImageView();
        signinBtn = new Button();
        text = new Text();
        signupBtn = new Button();
        usernameTextField = new TextField();
        passwordField = new PasswordField();

        setPrefHeight(552.0);
        setPrefWidth(400.0);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setSpacing(120.0);

        HBox.setHgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);

        AnchorPane.setLeftAnchor(backBtn, 23.0);
        backBtn.setLayoutX(23.0);
        backBtn.setLayoutY(44.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        signinTitle.setLayoutX(125.0);
        signinTitle.setLayoutY(77.0);
        signinTitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signinTitle.setStrokeWidth(0.0);
        signinTitle.setText("Sign-in");
        signinTitle.setFont(new Font(48.0));
        BorderPane.setMargin(hBox, new Insets(0.0, 0.0, 10.0, 0.0));
        setTop(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setSpacing(20.0);

        VBox.setVgrow(anchorPane0, javafx.scene.layout.Priority.ALWAYS);

        userImg.setFitHeight(84.0);
        userImg.setFitWidth(84.0);
        userImg.setLayoutX(155.0);
        userImg.setLayoutY(14.0);
        userImg.setPickOnBounds(true);
        userImg.setPreserveRatio(true);
        userImg.setImage(new Image(getClass().getResource("/assets/icons/robot.png").toExternalForm()));

        signinBtn.setLayoutX(141.0);
        signinBtn.setLayoutY(288.0);
        signinBtn.setMnemonicParsing(false);
        signinBtn.setPrefHeight(43.0);
        signinBtn.setPrefWidth(112.0);
        signinBtn.setText("Sign-in");

        text.setLayoutX(60.0);
        text.setLayoutY(372.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Don't you have an account?");

        signupBtn.setLayoutX(263.0);
        signupBtn.setLayoutY(351.0);
        signupBtn.setMnemonicParsing(false);
        signupBtn.setText("Sign-up");

        usernameTextField.setLayoutX(60.0);
        usernameTextField.setLayoutY(143.0);
        usernameTextField.setPrefHeight(48.0);
        usernameTextField.setPrefWidth(276.0);
        usernameTextField.setPromptText("User Name");

        passwordField.setLayoutX(60.0);
        passwordField.setLayoutY(213.0);
        passwordField.setPrefHeight(48.0);
        passwordField.setPrefWidth(276.0);
        passwordField.setPromptText("Passoword");
        setCenter(vBox);

        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(signinTitle);
        hBox.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(userImg);
        anchorPane0.getChildren().add(signinBtn);
        anchorPane0.getChildren().add(text);
        anchorPane0.getChildren().add(signupBtn);
        anchorPane0.getChildren().add(usernameTextField);
        anchorPane0.getChildren().add(passwordField);
        vBox.getChildren().add(anchorPane0);

    }
}
