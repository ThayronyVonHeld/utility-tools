package com.sgr.utilitytools_v1.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/sgr/UtilityTools_v1/main/main.fxml"));

        Parent root = loader.load();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
