package tictactoe.homescreen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public abstract class FXMLAccountInfoBase extends VBox {

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
    protected final Button historyButton;
    protected final ImageView imageView;
    protected final Button logoutButton;
    protected final ImageView imageView0;

    public FXMLAccountInfoBase() {

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
        historyButton = new Button();
        imageView = new ImageView();
        logoutButton = new Button();
        imageView0 = new ImageView();

        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setPrefHeight(130.0);
        setPrefWidth(321.0);
        setSpacing(5.0);
        getStyleClass().add("rect");
        getStylesheets().add("/tictactoe/homescreen/style.css");

        nameLabel.setPrefHeight(28.0);
        nameLabel.setPrefWidth(274.0);
        nameLabel.setText("Name");
        VBox.setMargin(nameLabel, new Insets(10.0, 0.0, 0.0, 0.0));

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

        historyButton.setMnemonicParsing(false);
        historyButton.setOnAction(this::handleHistoryButton);

        imageView.setFitHeight(15.0);
        imageView.setFitWidth(15.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../../resources/assets/icons/history.png").toExternalForm()));
        historyButton.setGraphic(imageView);

        logoutButton.setMnemonicParsing(false);
        logoutButton.setOnAction(this::handleLogoutButton);

        imageView0.setFitHeight(15.0);
        imageView0.setFitWidth(15.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../../../resources/assets/icons/logout.png").toExternalForm()));
        logoutButton.setGraphic(imageView0);
        hBox1.setPadding(new Insets(0.0, 0.0, 10.0, 20.0));

        getChildren().add(nameLabel);
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
        getChildren().add(hBox);
        hBox1.getChildren().add(historyButton);
        hBox1.getChildren().add(logoutButton);
        getChildren().add(hBox1);

    }

    protected abstract void handleHistoryButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleLogoutButton(javafx.event.ActionEvent actionEvent);

}
