package com.sgr.utilitytools_v1.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Navigator {

    private static StackPane mainPane;

    public static void setMainPane(StackPane pane) {
        mainPane = pane;
    }

    public static void loadView(String fxml) {
        try {
            Parent root = FXMLLoader.load(
                    Navigator.class.getResource(fxml)
            );
            mainPane.getChildren().setAll(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

