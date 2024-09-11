package be.webtechie.app;

import be.webtechie.app.view.MyView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyApp extends Application {

    private static final Logger logger = LogManager.getLogger(MyApp.class);

    public void run() {
        logger.info("Starting UI");
        launch();
    }

    /**
     * Starting point of the JavaFX application.
     *
     * @param stage Tha JavaFX stage
     */
    @Override
    public void start(Stage stage) {
        logger.info("Creating the stage");

        var scene = new Scene(new MyView(), 1024, 600);
        stage.setScene(scene);
        stage.setTitle("My JavaFX Application");
        stage.centerOnScreen();
        stage.show();

        // Make sure the application quits completely on close
        stage.setOnCloseRequest(t -> {
            cleanExit();
        });

        logger.info("UI is ready to be used");
    }

    public static void cleanExit() {
        logger.info("Bye bye");
        Platform.exit();
        System.exit(0);
    }
}