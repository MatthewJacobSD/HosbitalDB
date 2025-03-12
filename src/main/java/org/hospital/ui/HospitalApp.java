package org.hospital.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class HospitalApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the main layout container
        BorderPane root = new BorderPane();

        // Create a header with the hospital name
        HBox header = new HBox();
        header.setPadding(new Insets(15, 15, 15, 15));
        header.setSpacing(10);
        header.setAlignment(Pos.CENTER_LEFT);
        header.getStyleClass().addAll("navbar", "navbar-default");

        Label hospitalTitle = new Label("Community Hospital Management System");
        hospitalTitle.getStyleClass().add("h3");

        header.getChildren().add(hospitalTitle);
        root.setTop(header);

        // Create a sidebar with navigation buttons
        VBox sidebar = new VBox();
        sidebar.setPadding(new Insets(10));
        sidebar.setSpacing(8);
        sidebar.getStyleClass().add("panel-primary");
        sidebar.setMinWidth(200);

        Button patientsBtn = new Button("Patients");
        patientsBtn.getStyleClass().addAll("btn", "btn-primary");
        patientsBtn.setMaxWidth(Double.MAX_VALUE);

        Button doctorsBtn = new Button("Doctors");
        doctorsBtn.getStyleClass().addAll("btn", "btn-info");
        doctorsBtn.setMaxWidth(Double.MAX_VALUE);

        Button appointmentsBtn = new Button("Appointments");
        appointmentsBtn.getStyleClass().addAll("btn", "btn-success");
        appointmentsBtn.setMaxWidth(Double.MAX_VALUE);

        Button medicationsBtn = new Button("Medications");
        medicationsBtn.getStyleClass().addAll("btn", "btn-warning");
        medicationsBtn.setMaxWidth(Double.MAX_VALUE);

        Button logoutBtn = new Button("Logout");
        logoutBtn.getStyleClass().addAll("btn", "btn-danger");
        logoutBtn.setMaxWidth(Double.MAX_VALUE);

        sidebar.getChildren().addAll(
                patientsBtn,
                doctorsBtn,
                appointmentsBtn,
                medicationsBtn,
                logoutBtn
        );
        root.setLeft(sidebar);

        // Create a main content area with a welcome message
        VBox mainContent = new VBox();
        mainContent.setPadding(new Insets(15));
        mainContent.setSpacing(15);

        Label welcomeLabel = new Label("Welcome to the Hospital Management System");
        welcomeLabel.getStyleClass().add("h2");

        Label instructionsLabel = new Label("Select an option from the sidebar to manage hospital resources.");
        instructionsLabel.getStyleClass().add("lead");

        // Create a simple table to demonstrate data display
        TableView<String> recentActivityTable = new TableView<>();
        recentActivityTable.getStyleClass().add("table-striped");

        TableColumn<String, String> activityColumn = new TableColumn<>("Recent Activity");
        activityColumn.setPrefWidth(400);

        recentActivityTable.getColumns().add(activityColumn);
        recentActivityTable.setPlaceholder(new Label("No recent activity to display"));

        // Add main content components to layout
        mainContent.getChildren().addAll(
                welcomeLabel,
                instructionsLabel,
                new Label("Recent System Activity:"),
                recentActivityTable
        );
        root.setCenter(mainContent);

        // Create the scene with BootstrapFX styling
        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        primaryStage.setTitle("Hospital Management System");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set up button actions (just for demonstration)
        patientsBtn.setOnAction(e -> welcomeLabel.setText("Patients Management"));
        doctorsBtn.setOnAction(e -> welcomeLabel.setText("Doctors Management"));
        appointmentsBtn.setOnAction(e -> welcomeLabel.setText("Appointments Management"));
        medicationsBtn.setOnAction(e -> welcomeLabel.setText("Medications Management"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}