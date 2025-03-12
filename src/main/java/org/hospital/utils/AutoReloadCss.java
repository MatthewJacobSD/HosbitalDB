package org.hospital.utils;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.*;

public class AutoReloadCss extends Application {
    private static final String CSS_FILE_NAME = "main.css";
    private static final String CSS_FOLDER_PATH = "src/main/resources/styles";
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        // Create a simple UI for the utility
        Label statusLabel = new Label("CSS Auto-Reloaded Active");
        StackPane root = new StackPane(statusLabel);
        scene = new Scene(root, 300, 200);

        // Initial style loading
        loadStyles();

        // Configure the window
        primaryStage.setScene(scene);
        primaryStage.setTitle("CSS Auto-Reloaded");
        primaryStage.show();

        // Start file watcher in a separate thread
        new Thread(this::watchCSSFile).start();
    }

    private void loadStyles() {
        // This must be run on the JavaFX application thread
        Platform.runLater(() -> {
            // Clear existing styles to prevent duplicates
            scene.getStylesheets().clear();

            // Use the correct format for loading resources
            String cssResource = "/styles/main.css";
            String cssUrl = getClass().getResource(cssResource).toExternalForm();
            scene.getStylesheets().add(cssUrl);

            System.out.println("➕ CSS styles reloaded: " + cssUrl);
        });
    }

    private void watchCSSFile() {
        try {
            // Create a watch service to monitor file system events
            WatchService watchService = FileSystems.getDefault().newWatchService();

            // We need to watch the directory containing the CSS file, not the file itself
            Path cssDirectoryPath = Paths.get(CSS_FOLDER_PATH);
            cssDirectoryPath.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("👀 Watching for changes in: " + cssDirectoryPath.toAbsolutePath());

            while (true) {
                // This will block until an event occurs
                WatchKey key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    // Check if the modified file is our CSS file
                    if (event.context().toString().equals(CSS_FILE_NAME)) {
                        System.out.println("✅ CSS update detected, reloading styles...");

                        // Reload the CSS
                        loadStyles();
                    }
                }

                // Reset the key to receive further events
                boolean valid = key.reset();
                if (!valid) {
                    System.out.println("❌ Watch key no longer valid. Exiting watch service.");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("💀 Error setting up file watcher: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("❌ Watcher thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}