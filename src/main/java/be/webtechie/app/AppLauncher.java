package be.webtechie.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The AppLauncher class provides the main entry point
 * for launching the application.
 */
public class AppLauncher {

    private static final Logger logger = LogManager.getLogger(AppLauncher.class);

    public static void main(String[] args) {
        logger.info("Here we go");

        var app = new MyApp();
        app.run();
    }
}
