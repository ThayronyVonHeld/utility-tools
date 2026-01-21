module com.sgr.utilitytools_v1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sgr.utilitytools_v1.dashboard to javafx.fxml;
    opens com.sgr.utilitytools_v1.app to javafx.fxml;

    exports com.sgr.utilitytools_v1.app;
}
