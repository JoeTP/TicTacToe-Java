/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author Ayat Gamal
 */
public class WinningLine {

    static String startLine;
    static String endLine;

    public static int getCol(String btnString) {
        char c = btnString.charAt(1);
        int col = Character.getNumericValue(c);
        return col;
    }

    public static int getRow(String btnString) {
        char r = btnString.charAt(0);
        int row = Character.getNumericValue(r);
        return row;
    }

    public static void setStartLine(String s) {
        startLine = s;
    }

    public static void setEndLine(String s) {
        endLine = s;
    }

    public static String getStartLine() {
        return startLine;
    }

    public static String getEndLine() {
        return endLine;
    }

    public static void drawWinningLine(String startLine, String endLine, GridPane grid) {
        int r1 = getRow(startLine);
        int c1 = getCol(startLine);
        int r2 = getRow(endLine);
        int c2 = getCol(endLine);
        //start point
        double btnWidth = grid.getWidth() / 3;
        double btnHeight = grid.getHeight() / 3;

        double gridX = grid.getLayoutX();
        double gridY = grid.getLayoutY();

        double x1 = gridX + (c1 * btnWidth) + btnWidth / 2;
        double y1 = gridY + (r1 * btnHeight) + btnHeight / 2;

        double x2 = gridX + (c2 * btnWidth) + btnWidth / 2;
        double y2 = gridY + (r2 * btnHeight) + btnHeight / 2;

        Line line = new Line(x1, y1, x2, y2);
        AnchorPane anchorPane = (AnchorPane) grid.getParent();
        anchorPane.getChildren().add(line);

        line.setStroke(Color.GREENYELLOW.darker());
        line.setStrokeWidth(5);
        line.setVisible(true);

    }

}
