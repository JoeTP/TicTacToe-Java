package tictactoe.signup;

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
    protected final Button signinBtn;
    protected final HBox hBox0;
    protected final Button previousImageBtn;
    protected ImageView characterImageView;
    protected final Button nextImageBtn;
    protected int imgeNavigator = 0;

    protected final String[] imagePaths = {
        "assets/icons/cat.png",
        "assets/icons/robot.png",
        "assets/icons/panda-bear.png",
        "assets/icons/dinosaur.png",
        "assets/icons/jaguar.png",
        "assets/icons/turtle.png"
    };

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
        signinBtn = new Button();
        hBox0 = new HBox();
        previousImageBtn = new Button();
        characterImageView = new ImageView();
        nextImageBtn = new Button();

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

        signupTitle.setLayoutX(125.0);
        signupTitle.setLayoutY(77.0);
        signupTitle.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        signupTitle.setStrokeWidth(0.0);
        signupTitle.setText("Sign-up");
        signupTitle.setFont(new Font(48.0));
        BorderPane.setMargin(hBox, new Insets(0.0, 0.0, 10.0, 0.0));
        setTop(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setSpacing(20.0);

        VBox.setVgrow(anchorPane0, javafx.scene.layout.Priority.ALWAYS);

        signupBtn.setLayoutX(59.0);
        signupBtn.setLayoutY(321.0);
        signupBtn.setMnemonicParsing(false);
        signupBtn.setPrefHeight(43.0);
        signupBtn.setPrefWidth(112.0);
        signupBtn.setText("Sign-Up");

        usernameTextField.setLayoutX(60.0);
        usernameTextField.setLayoutY(140.0);
        usernameTextField.setPrefHeight(48.0);
        usernameTextField.setPrefWidth(276.0);
        usernameTextField.setPromptText("User Name");

        chooseCharText.setLayoutX(112.0);
        chooseCharText.setLayoutY(121.0);
        chooseCharText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        chooseCharText.setStrokeWidth(0.0);
        chooseCharText.setText("Click To Choose Character");

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

        signinBtn.setLayoutX(224.0);
        signinBtn.setLayoutY(321.0);
        signinBtn.setMnemonicParsing(false);
        signinBtn.setPrefHeight(43.0);
        signinBtn.setPrefWidth(112.0);
        signinBtn.setText("Sign-In");

        hBox0.setLayoutX(81.0);
        hBox0.setLayoutY(30.0);

        previousImageBtn.setMnemonicParsing(false);
        previousImageBtn.setText("Back");
        HBox.setMargin(previousImageBtn, new Insets(10.0));

        characterImageView.setFitHeight(60.0);
        characterImageView.setFitWidth(92.0);
        characterImageView.setPickOnBounds(true);
        characterImageView.setPreserveRatio(true);

        nextImageBtn.setMnemonicParsing(false);
        nextImageBtn.setText("Next");
        HBox.setMargin(nextImageBtn, new Insets(10.0));
        setCenter(vBox);

        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(signupTitle);
        hBox.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(signupBtn);
        anchorPane0.getChildren().add(usernameTextField);
        anchorPane0.getChildren().add(chooseCharText);
        anchorPane0.getChildren().add(passwordField);
        anchorPane0.getChildren().add(emailTextField);
        anchorPane0.getChildren().add(signinBtn);
        hBox0.getChildren().add(previousImageBtn);
        hBox0.getChildren().add(characterImageView);
        hBox0.getChildren().add(nextImageBtn);
        anchorPane0.getChildren().add(hBox0);
        vBox.getChildren().add(anchorPane0);

        characterImageView.setImage(new Image(imagePaths[imgeNavigator]));
        characterImageView.setFitWidth(64);
        characterImageView.setFitHeight(64);
        characterImageView.setPreserveRatio(true);

        nextImageBtn.setOnAction(e -> {
            imgeNavigator = (imgeNavigator + 1) % imagePaths.length;
            characterImageView.setImage(new Image(imagePaths[imgeNavigator]));
        });

        previousImageBtn.setOnAction(e -> {
            imgeNavigator = (imgeNavigator - 1 + imagePaths.length) % imagePaths.length;
            characterImageView.setImage(new Image(imagePaths[imgeNavigator]));
            System.out.println("Next image: " + imgeNavigator);
        });
       

    }
}