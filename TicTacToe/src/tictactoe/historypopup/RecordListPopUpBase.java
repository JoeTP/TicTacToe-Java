package tictactoe.historypopup;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class RecordListPopUpBase extends AnchorPane {

    protected final Button closeBtn;
    protected final VBox vBox;

    public RecordListPopUpBase() {

        closeBtn = new Button();
        vBox = new VBox();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/styling/generalStyle.css");

        AnchorPane.setLeftAnchor(closeBtn, 10.0);
        AnchorPane.setTopAnchor(closeBtn, 20.0);
        closeBtn.setOnAction(this::handleCloseButton);
        closeBtn.setText("Back");

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(500.0);
        vBox.setPrefWidth(450.0);
        vBox.setSpacing(10);

        getChildren().add(closeBtn);
        getChildren().add(vBox);

    }

    protected abstract void handleCloseButton(javafx.event.ActionEvent actionEvent);

    
}
