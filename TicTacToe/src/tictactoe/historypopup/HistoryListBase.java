package tictactoe.historypopup;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class HistoryListBase extends AnchorPane {

    protected final Button closeBtn;
    protected final VBox vBox;
    protected final ListView<String> listView;

    public HistoryListBase() {

        closeBtn = new Button();
        vBox = new VBox();
        listView = new ListView<>();

        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/styling/generalStyle.css");

        AnchorPane.setLeftAnchor(closeBtn, 10.0);
        AnchorPane.setTopAnchor(closeBtn, 20.0);
        closeBtn.setText("Back");

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(500.0);
        vBox.setPrefWidth(450.0);
        vBox.setSpacing(10);

        listView.setPrefHeight(350.0);
        listView.setPrefWidth(300.0);
        listView.setOnMouseClicked(this::handleCellClick);
        closeBtn.setOnAction(this::handleCloseButton);
        VBox.setMargin(listView, new Insets(10, 10, 10, 10));

        vBox.getChildren().addAll(new Label("History List"), listView);

        getChildren().add(vBox);
        getChildren().add(closeBtn);
    }

    protected abstract void handleCellClick(javafx.scene.input.MouseEvent event);

    protected abstract void handleCloseButton(javafx.event.ActionEvent actionEvent);

}
