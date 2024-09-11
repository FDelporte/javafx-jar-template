package be.webtechie.app.view;

import be.webtechie.app.AppLauncher;
import be.webtechie.app.MyApp;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class MyView extends BorderPane {

    private static final Logger logger = LogManager.getLogger(MyView.class);

    public MyView() {

        var topTitle = new Label("JavaFX Template");
        topTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        setTop(topTitle);
        BorderPane.setAlignment(topTitle, javafx.geometry.Pos.CENTER);

        Button exit = new Button("Exit");
        exit.setOnAction(event -> {
            logger.info("Clicked exit");
            MyApp.cleanExit();
        });
        setLeft(exit);

        setCenter(getTiles());

        var bottomJavaVersion = new Label("Java: "
                + System.getProperty("java.runtime.version")
                + " - JavaFx: "
                + System.getProperty("javafx.runtime.version"));
        bottomJavaVersion.setStyle("-fx-font-size: 14px;");
        setBottom(bottomJavaVersion);
        BorderPane.setAlignment(bottomJavaVersion, javafx.geometry.Pos.CENTER);
    }

    private HBox getTiles() {
        var holder = new HBox();
        holder.setSpacing(5);
        holder.setAlignment(Pos.CENTER);

        holder.getChildren().add(TileBuilder.create()
                        .prefSize(300, 300)
                        .skinType(Tile.SkinType.CLOCK)
                        .title("Clock")
                        .dateVisible(true)
                        .locale(Locale.UK)
                        .running(true)
                        .build());

        holder.getChildren().add(
                TileBuilder.create()
                        .prefSize(300, 300)
                        .skinType(Tile.SkinType.WORLDMAP)
                        .title("WorldMap")
                        .textVisible(false)
                        .build());

        return holder;
    }
}
