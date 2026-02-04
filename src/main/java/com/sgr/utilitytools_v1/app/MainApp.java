package com.sgr.utilitytools_v1.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/sgr/utilitytools_v1/main/main.fxml"));

        Parent root = loader.load();

        mainStage.setScene(new Scene(root, 1024, 600));
        mainStage.setTitle("Utility Tools");
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}