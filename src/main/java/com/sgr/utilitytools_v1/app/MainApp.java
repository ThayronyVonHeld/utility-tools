package com.sgr.utilitytools_v1.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        var url = MainApp.class.getResource(
                "/com/sgr/utilitytools_v1/dashboard/dashboard.fxml"
        );

        System.out.println("FXML URL = " + url);

        FXMLLoader loader = new FXMLLoader(url);
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.setTitle("Utility Tools");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
