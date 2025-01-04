package tictactoe.checkconnectionpopup;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;

public abstract class FXMLCheckConnectionPopupBase extends HBox {

    protected final ProgressIndicator progressIndicator;
    protected final Label label;

    public FXMLCheckConnectionPopupBase() {

        progressIndicator = new ProgressIndicator();
        label = new Label();

        setAlignment(javafx.geometry.Pos.CENTER);

        progressIndicator.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        label.setText("Checking Connection!");
        label.setPadding(new Insets(20.0, 20.0, 20.0, 0.0));
        setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        getChildren().add(progressIndicator);
        getChildren().add(label);

    }
}
