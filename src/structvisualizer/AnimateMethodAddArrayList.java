package structvisualizer;
 /*
 * AnimateMethodAddArrayList   3/15/16, 15:43
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Kyrylo Havrylenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * <what class do>
 *
 * @author Kyrylo Havrylenko
 * @see
 */
public class AnimateMethodAddArrayList extends AnimateMethod {

    AnimateMethodAddArrayList(Pane canvasPane, String type) {
        super(canvasPane, type);

    }


    @Override
    public void animate(String type) {

        System.out.println("Hello");

            ArrayList<StackPane> rectangles = new ArrayList<>();
            for (int i = 0; i < data.getNumOfStackPanes(); i++) {
                StackPane stack = new StackPane();
                stack.setMinWidth(data.getWidth());
                stack.setLayoutX(data.getWidth() + i * data.getWidth());
                rectangles.add(i, stack);

                Rectangle r = new Rectangle();
                r.setWidth(data.getWidth());
                r.setHeight(data.getHeight());
                r.setFill(Color.TRANSPARENT);
                r.setStroke(Color.BLACK);

                Text text = new Text("" + i);

                rectangles.get(i).getChildren().addAll(r, text);
            }


            StackPane stack = new StackPane();
            stack.setLayoutX(data.getStackPaneSize());
            stack.setLayoutY(data.getStackPaneSize());
            rectangles.add(data.getNumOfStackPanes(), stack);
            Rectangle r = new Rectangle();
            r.setWidth(data.getWidth());
            r.setHeight(data.getHeight());
            r.setFill(Color.TRANSPARENT);
            r.setStroke(Color.BLACK);

            Text text = new Text("" + data.getNumOfStackPanes());

            rectangles.get(data.getNumOfStackPanes()).getChildren().addAll(r, text);
            canvasPane.getChildren().addAll(rectangles);

            FadeTransition ft = new FadeTransition(Duration.millis(data.getTimeFade()), rectangles.get(data.getNumOfStackPanes()));
            ft.setFromValue(data.getTransitionInvisible());
            ft.setToValue(data.getTransitionVisible());
            ft.play();

            TranslateTransition tt = new TranslateTransition(Duration.millis(data.getTimeTranslate()), rectangles.get
                    (data.getNumOfStackPanes()));
            tt.setByY(-1f * data.getStackPaneSize());
            tt.play();

    }


    @Override
    public String getCode() {
//        StringBuilder codeOutput = new StringBuilder();
//        if(collectionBox.getSelectionModel().getSelectedItem() != null) {
//
//            codeOutput
//                    .append(collectionBox.getSelectionModel().getSelectedItem().toString())
//                    .append(".")
//                    .append(methodBox.getValue())
//                    .append(".")
//                    .append(typeBox.getValue());
//        } else {
//            codeOutput.append("Pick your collection!");
//        }
//        return codeOutput.toString();

        return "ArrayList<Integer>.add(E e)";
    }

    @Override
    public String getOutput() {
        return "el1->el2->el3->el4";
    }
}
