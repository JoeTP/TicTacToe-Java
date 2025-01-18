package tictactoe.historypopup;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class RecordListPopUpBase extends AnchorPane {

    protected final VBox vBox;
    protected final Button closeBtn;

    public RecordListPopUpBase() {

        vBox = new VBox();
        closeBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(450.0);
        getStyleClass().add("mainBackground");
        getStylesheets().add("/tictactoe/historypopup/../../styling/generalStyle.css");

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(500.0);
        vBox.setPrefWidth(450.0);
        vBox.setSpacing(10);

        AnchorPane.setLeftAnchor(closeBtn, 20.0);
        AnchorPane.setTopAnchor(closeBtn, 20.0);
        closeBtn.setOnAction(this::handleCloseButton);
        closeBtn.setText("Back");

        getChildren().add(vBox);
        getChildren().add(closeBtn);

    }

    protected abstract void handleCloseButton(javafx.event.ActionEvent actionEvent);

}
