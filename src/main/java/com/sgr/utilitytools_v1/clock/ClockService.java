package com.sgr.utilitytools_v1.clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

public class ClockService {

    private static ClockService instance;

    private final IntegerProperty tick = new SimpleIntegerProperty(0);
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
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> onTick())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void onTick() {
        tick.set(tick.get() + 1);

        // 🔥 AQUI VAI O PODER DEPOIS
        // timerService.update();
        // stopwatchService.update();
        // alarmService.check();
    }

    public IntegerProperty tickProperty() {
        return tick;
    }

    public int getTick() {
        return tick.get();
    }

    public void start() {
        if (timeline != null) timeline.play();
    }

    public void stop() {
        if (timeline != null) timeline.stop();
    }
}