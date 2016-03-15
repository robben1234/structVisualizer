package structvisualizer;

/*
 * Main   3/13/16, 20:48
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

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Main javafx class
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setOnCloseRequest(e -> {
            if (askExit()) {
                primaryStage.close();
            } else {
                e.consume();
            }
        });

        Parent root = FXMLLoader.load(getClass().getResource("structvisualizer.fxml"));
        primaryStage.setTitle("Data Structure Visualizer");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(820);
        primaryStage.setMinHeight(620);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Shows user new window with confirmation whether he actually want to close app
     *
     * @return true if still wanted, false if dont want
     */
    public static boolean askExit() {
        return ConfirmBox.display("Confirm exit", "Do you really wan't to exit?");
    }

    /**
     * Shows user new window with about information of the app
     */
    public static void showAbout() {
        if (AboutWindow.display()) {
            Platform.exit();
            System.exit(0);
        }
    }
}
