package sk.zrebec.learn.java.javafx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label();
        label.setTextFill(Color.GREEN); // Set text color to green
        label.setText("Hello, Java!");
        label.setFont(new Font(24)); // Set font size

        StackPane root = new StackPane(label);
        root.setStyle("-fx-background-color: black"); // Set the root pane to black background
        Scene scene = new Scene(root, 600, 200);


        primaryStage.setTitle("Hello JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set Date and Time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Update time every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalTime currentTime = LocalTime.now();
            String formattedTime = currentTime.format(formatter);
            label.setText("Hello, JavaFX! The current time is: " + formattedTime);
        }));

        // Set cyclic timeline
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
