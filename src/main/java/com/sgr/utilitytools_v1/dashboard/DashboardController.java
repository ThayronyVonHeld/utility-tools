package com.sgr.utilitytools_v1.dashboard;

import com.sgr.utilitytools_v1.navigation.Navigator;

public class DashboardController {

    public void abrirAlarm() {
        Navigator.navigate("/alarm/alarm.fxml");
    }

    public void abrirCronometro() {
        Navigator.navigate("/alarm/stopwatch.fxml");
    }
}
