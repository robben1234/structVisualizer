package structvisualizer.animatecollections.animatemethods.arraylist;

 /*
 * Remove   4/5/16, 23:33
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.AnimateMethod;
import structvisualizer.animatecollections.animatemethods.MethodsForSearch;
import structvisualizer.data.OutputStrings;

/**
 * Animates ArrayList.remove
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class Remove extends AnimateMethod implements MethodsForSearch {
    Object indexOf;
    int index;

    public Remove(Pane canvasPane, String type, SomeClass obj, Object indexOf, int index) {
        super(canvasPane, type, obj);
        this.indexOf = indexOf;
        this.index = index;
    }


    /**
     *
     * @param redRectangle
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param canvas
     * @see MethodsForSearch
     */
    public void animateSearch(StackPane redRectangle, double fromX, double fromY, double toX, double toY, Pane canvas) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), redRectangle);
        tt.setFromX(fromX);
        tt.setFromY(fromY);
        tt.setToX(toX);
        tt.setToY(toY);
        tt.play();

        tt.setOnFinished(event -> {
            redRectangle.setVisible(false);
            canvas.getChildren().remove(index);


        });
    }

    @Override
    public void animate(String type) throws UnsupportedOperationException {
        //        ArrayList<StackPane> rectangles = createArrayList(type);
        //        canvasPane.getChildren().addAll(rectangles);
        //        AnimateMethod.setTooltip(rectangles, type, customClass);
        //
        //        StackPane sp = newStackPane(0, 0, canvasPane, data.getHightlightColor());
        //
        //        double finalX = 0;
        //
        //        for(int i = 0; i < data.getNumOfStackPanes(); i++) {
        //            String text = rectangles.get(i).getChildren().get(1).toString();
        //            // indexOf - VALUE OF ELEMENT WHAT WE LOOKING FOR
        //            if(!text.substring(11, 12).equals(indexOf)) {
        //                finalX += data.getWidth();
        //            }
        //        }
        //        animateSearch(sp, 0, 0, finalX, 0, canvasPane);

        Arraylists.searchForElement(this, type, canvasPane, customClass, indexOf, index);
    }

    @Override
    public String getCode(OutputStrings os) throws UnsupportedOperationException {
        String result = os.getCode() + "\n\ttmp.remove(" + indexOf + ");" + "\n\t}\n}";

        return result;
    }

    @Override
    public String getResults(OutputStrings os) throws UnsupportedOperationException {
        return "Object " + indexOf + "have been deleted from your data structure.";
    }
}
