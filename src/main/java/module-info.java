module com.sgr.utilitytools_v1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.jfoenix;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome6;

    opens com.sgr.utilitytools_v1.app to javafx.fxml;
    opens com.sgr.utilitytools_v1.dashboard to javafx.fxml;
    opens com.sgr.utilitytools_v1.clock to javafx.fxml;
    opens com.sgr.utilitytools_v1.clock.stopwatch to javafx.fxml;
    opens com.sgr.utilitytools_v1.clock.alarm to javafx.fxml;
    opens com.sgr.utilitytools_v1.clock.timer to javafx.fxml;



    exports com.sgr.utilitytools_v1.app;
}
