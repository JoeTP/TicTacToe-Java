package tictactoeserver.gui;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLServerBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final Button serverEscBtn;
    protected final AnchorPane anchorPane0;
    protected final PieChart usersPieChart;
    protected final Circle serverIndicator;
    protected final Text text;
    protected final ListView usersList;
    protected final Label label;
    protected final ToggleButton serverStateToggle;
    protected final ToggleGroup startCloseGroup;
    protected final Label totalUsersLabel;
    protected final Label label0;
    protected final Label totalUsersNoLabel;
    protected final Label ActiceUsersLabel;
    protected final Label ActiceUsersNoLabel;

    public FXMLServerBase() {

        anchorPane = new AnchorPane();
        serverEscBtn = new Button();
        anchorPane0 = new AnchorPane();
        usersPieChart = new PieChart();
        serverIndicator = new Circle();
        text = new Text();
        usersList = new ListView();
        label = new Label();
        serverStateToggle = new ToggleButton();
        startCloseGroup = new ToggleGroup();
        totalUsersLabel = new Label();
        label0 = new Label();
        totalUsersNoLabel = new Label();
        ActiceUsersLabel = new Label();
        ActiceUsersNoLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoeserver/gui/styles/serverstylesheet.css");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(13.0);
        anchorPane.setPrefWidth(600.0);

        serverEscBtn.setLayoutX(14.0);
        serverEscBtn.setLayoutY(11.0);
        serverEscBtn.setMnemonicParsing(false);
        serverEscBtn.setText("ESC");
        setTop(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(401.0);
        anchorPane0.setPrefWidth(600.0);

        usersPieChart.setLayoutX(300.0);
        usersPieChart.setLayoutY(32.0);
        usersPieChart.setLegendVisible(false);
        usersPieChart.setPrefHeight(284.0);
        usersPieChart.setPrefWidth(280.0);
        usersPieChart.getStyleClass().add("default-color0");
        usersPieChart.setTitle("Users");

        serverIndicator.setFill(javafx.scene.paint.Color.valueOf("#13f803"));
        serverIndicator.setLayoutX(64.0);
        serverIndicator.setLayoutY(305.0);
        serverIndicator.setRadius(11.0);
        serverIndicator.setStroke(javafx.scene.paint.Color.BLACK);
        serverIndicator.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        serverIndicator.getStyleClass().add("serverStartBtn");

        text.setLayoutX(216.0);
        text.setLayoutY(22.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Server GUI");
        text.setWrappingWidth(167.923828125);
        text.setFont(new Font(36.0));

        usersList.setLayoutX(47.0);
        usersList.setLayoutY(60.0);
        usersList.setPrefHeight(202.0);
        usersList.setPrefWidth(200.0);

        label.setLayoutX(100.0);
        label.setLayoutY(32.0);
        label.setText("Active users");
        label.setFont(new Font(18.0));

        serverStateToggle.setLayoutX(99.0);
        serverStateToggle.setLayoutY(289.0);
        serverStateToggle.setMnemonicParsing(false);
        serverStateToggle.setOnAction(this::handleServerState);
        serverStateToggle.setText("Start");

        serverStateToggle.setToggleGroup(startCloseGroup);

        totalUsersLabel.setLayoutX(356.0);
        totalUsersLabel.setLayoutY(297.0);
        totalUsersLabel.setText("Total Users :");

        label0.setLayoutX(426.0);
        label0.setLayoutY(297.0);

        totalUsersNoLabel.setLayoutX(426.0);
        totalUsersNoLabel.setLayoutY(297.0);
        totalUsersNoLabel.setText("0");

        ActiceUsersLabel.setLayoutX(454.0);
        ActiceUsersLabel.setLayoutY(297.0);
        ActiceUsersLabel.setText("Active Users :");

        ActiceUsersNoLabel.setLayoutX(531.0);
        ActiceUsersNoLabel.setLayoutY(297.0);
        ActiceUsersNoLabel.setText("0");
        setBottom(anchorPane0);

        anchorPane.getChildren().add(serverEscBtn);
        anchorPane0.getChildren().add(usersPieChart);
        anchorPane0.getChildren().add(serverIndicator);
        anchorPane0.getChildren().add(text);
        anchorPane0.getChildren().add(usersList);
        anchorPane0.getChildren().add(label);
        anchorPane0.getChildren().add(serverStateToggle);
        anchorPane0.getChildren().add(totalUsersLabel);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(totalUsersNoLabel);
        anchorPane0.getChildren().add(ActiceUsersLabel);
        anchorPane0.getChildren().add(ActiceUsersNoLabel);

    }

    protected abstract void handleServerState(javafx.event.ActionEvent actionEvent);

}
