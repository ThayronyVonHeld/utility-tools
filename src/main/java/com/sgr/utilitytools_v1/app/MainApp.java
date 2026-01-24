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
                getClass().getResource("/com/sgr/utilitytools_v1/view/main/main.fxml"));

        Parent root = loader.load();

<<<<<<< HEAD
        FXMLLoader loader = new FXMLLoader(url);
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.setTitle("Utility Tools");
        stage.show();
=======
        mainStage.setScene(new Scene(root, 1024, 600));
        mainStage.setTitle("Utility Tools");
        mainStage.show();
>>>>>>> fff0f94c2e0346bb28604d1133bb2dec77091b89
    }

    public static void main(String[] args) {
        launch(args);
    }
}