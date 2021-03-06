package structvisualizer;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parser.SomeClass;
import structvisualizer.animatecollections.animatemethods.MethodsForSearch;
import structvisualizer.data.DataForValueFactory;
import structvisualizer.window.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main javafx class
 */
public class Main extends Application {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setOnCloseRequest(e -> {
            if (askExit()) {
                logger.log(Level.INFO, "Closing app");
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
        return ConfirmBoxWindow.display("Confirm exit", "Do you really wan't to exit?");
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

    /**
     * Shows form for input string to SomeClass
     * @see SomeClass
     * @return user-inputted String
     */
    public static String showInput() {
        return InputWindow.display();
    }

    /**
     * Shows form for user input in MethodsForSearch classes and Arraylist.Sublist. Also works as factory because of
     * different controls which needed for different MethodsForSearch classes
     * @param method
     * @param type
     * @return parsed user input
     * @see MethodsForSearch
     * @see structvisualizer.animatecollections.animatemethods.arraylist.Sublist
     * @see DataForValueFactory
     */
    public static DataForValueFactory showInputSearchable(String method, String type) {
        return InputClassSearchableWindow.display(method, type);
    }

    /**
     * Shows form for user input to SomeClass
     * @see SomeClass
     * @return SomeClass instance
     */
    public static SomeClass showCustomClassDialog() {
       return InputClassWindow.display();
    }
}
