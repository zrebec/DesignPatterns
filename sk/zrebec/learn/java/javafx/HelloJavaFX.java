package sk.zrebec.learn.java.javafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Label for Welcome message
        Label labelWelcomeMessage = new Label();
        labelWelcomeMessage.setTextFill(Color.GREEN); // Set text color to green
        labelWelcomeMessage.setText("Hello, Java!");

        // Label for actual datetime
        Label labelTimestamp = new Label();
        labelTimestamp.setTextFill(Color.YELLOW); // Set text color to green
        labelTimestamp.setText("Hello, Java!");

        VBox root = new VBox(10); // Create VBox with 10px spacing between elements
        root.getChildren().addAll(labelWelcomeMessage, labelTimestamp);
        root.setStyle("-fx-background-color: black"); // Set the root pane to black background
        root.setAlignment(Pos.CENTER); // Center the elements inside the VBox
        Scene scene = new Scene(root, 600, 200);

        // Bind font size to the minimum of scene width and height divided by a scaling factor
        double scalingFactor = 10.0;

        // Example for using lambda functions
        labelWelcomeMessage.fontProperty().bind(Bindings.createObjectBinding(
            () -> new Font(Math.min(scene.getWidth(), scene.getHeight()) / scalingFactor),
            scene.widthProperty(), scene.heightProperty()));

        labelTimestamp.fontProperty().bind(Bindings.createObjectBinding(
            () -> new Font(Math.min(scene.getWidth(), scene.getHeight()) / (scalingFactor * 1.5)),
            scene.widthProperty(), scene.heightProperty()));

        // Set Date and Time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Update time every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime currentTime = LocalTime.now();
            String formattedTime = currentTime.format(formatter);
            labelTimestamp.setText("Hello, JavaFX! The current time is: " + formattedTime);
        }));

        // Set cyclic timeline
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        // Show primary stage
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
