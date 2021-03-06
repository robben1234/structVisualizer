package structvisualizer.window;

 /*
 * InputWindow   3/24/16, 21:41
 *
 * By Kyrylo Havrylenko
 *
 */

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import structvisualizer.data.DataForValueFactory;
import structvisualizer.data.Methods;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Shows a form for String input from user
 *
 * @author Kyrylo Havrylenko
 * @see structvisualizer.Main
 */
public class InputWindow {
    private static final Logger logger = Logger.getLogger(InputWindow.class.getName());
    static String answer;

    /**
     * @return
     */
    public static String display() {
        Stage window = new Stage(); // пустое окно (stage)

        window.initModality(Modality.APPLICATION_MODAL); // make stage modal (нельзя переключить обратно, не закрыв это)
        window.setTitle("Input");
        window.setMinWidth(500);
        window.setMaxWidth(500);
        window.setMaxHeight(200);

        VBox container = new VBox();
        container.setSpacing(10);

        TextField input = new TextField();
        input.setPromptText("Please write your preferable input according to the type here.");

        Label inputLabel = new Label("Input: ");
        inputLabel.setLabelFor(input);

        Button submit = new Button("Set");
        submit.setOnAction(event -> {
            event.consume();
            window.close();
        });

        container.getChildren().addAll(inputLabel, input, submit);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(container);
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); // fn+f1 to see documentation | ждет пока окно закроется прежде чем показывать другу сцену

        logger.log(Level.FINE, "User input" + input.getText());
        return input.getText();
    }
}
