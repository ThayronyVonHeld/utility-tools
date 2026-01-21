package com.sgr.utilitytools_v1.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class Navigator {

    private static AnchorPane contentArea;

    public static void setContentArea(AnchorPane pane) {
        contentArea = pane;
    }

    public static void navigate(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(
                    Navigator.class.getResource(fxmlPath)
            );

            contentArea.getChildren().setAll(root);
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadDashboard() {
    }
}
