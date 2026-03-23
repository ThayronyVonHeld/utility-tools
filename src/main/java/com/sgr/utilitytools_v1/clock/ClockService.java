package com.sgr.utilitytools_v1.clock;

import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ClockService {
    private static ClockService instance;
    private final IntegerProperty secondsActive = new SimpleIntegerProperty(0);
    private Timeline timeline;

    private ClockService() {
        setupTimeline();
    }

    public static ClockService getInstance() {
        if (instance == null) {
            instance = new ClockService();
        }
        return instance;
    }

    private void setupTimeline() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            secondsActive.set(secondsActive.get() + 1);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public IntegerProperty secondsActiveProperty() {
        return secondsActive;
    }
}
