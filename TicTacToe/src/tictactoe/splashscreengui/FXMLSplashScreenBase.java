package tictactoe.splashscreengui;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class FXMLSplashScreenBase extends StackPane {

    protected final ImageView foreground;
    protected final VBox vbox;
    protected final ImageView icon;
    protected final Text texttictactoe;

    public FXMLSplashScreenBase() {

        foreground = new ImageView();
        vbox = new VBox();
        icon = new ImageView();
        texttictactoe = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(720.0);

        foreground.setFitHeight(720.0);
        foreground.setFitWidth(720.0);
        foreground.setPickOnBounds(true);
        foreground.setPreserveRatio(true);
        foreground.setImage(new Image(getClass().getResource("../../../resources/assets/icons/foreground.jpg").toExternalForm()));

        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        vbox.setSpacing(10.0);

        icon.setFitHeight(300.0);
        icon.setFitWidth(300.0);
        icon.setPickOnBounds(true);
        icon.setPreserveRatio(true);
        icon.setImage(new Image(getClass().getResource("../../../resources/assets/icons/icon.png").toExternalForm()));
        VBox.setMargin(icon, new Insets(0.0, 0.0, 20.0, 0.0));

        texttictactoe.setFill(javafx.scene.paint.Color.valueOf("#473e77"));
        texttictactoe.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        texttictactoe.setStrokeWidth(0.0);
        texttictactoe.setText("Tic Tac Toe");
        texttictactoe.setFont(new Font("Stencil", 50.0));
        VBox.setMargin(texttictactoe, new Insets(0.0, 0.0, 20.0, 0.0));

        getChildren().add(foreground);
        vbox.getChildren().add(icon);
        vbox.getChildren().add(texttictactoe);
        getChildren().add(vbox);

    }
}
