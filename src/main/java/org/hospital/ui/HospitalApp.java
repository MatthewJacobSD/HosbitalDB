package org.hospital.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

public class HospitalApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Button styling
        Button btn = new Button("Patients");
        btn.getStyleClass().add("primary-button"); // Changed to a more specific class name

        // Window set up
        StackPane root = new StackPane(btn);
        Scene scene = new Scene(root, 400, 300);

        // Verify CSS file existence before loading
        String cssResource = "/styles/main.css";
        if (getClass().getResource(cssResource) != null) {
            // Load CSS file
            scene.getStylesheets().add(getClass().getResource(cssResource).toExternalForm());
            System.out.println("✅ CSS loaded successfully: " + cssResource);
        } else {
            System.err.println("⚠️ WARNING: CSS file not found: " + cssResource);

            // Alternative: Try to find the file in development environment
            File cssFile = new File("src/main/resources" + cssResource);
            if (cssFile.exists()) {
                System.out.println("🤔 Found CSS file in dev environment: " + cssFile.getAbsolutePath());
                // For development, you can use a file URL, but this won't work in production JAR
                scene.getStylesheets().add("file:///" + cssFile.getAbsolutePath().replace("\\", "/"));
            }
        }

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hospital Database");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}