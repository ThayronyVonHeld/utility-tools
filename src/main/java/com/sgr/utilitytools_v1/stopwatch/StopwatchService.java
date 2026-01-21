package com.sgr.utilitytools_v1.stopwatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class StopwatchService {

    private final Stopwatch stopwatch;
    private Timeline timeline;

    private Runnable onTick;
    private Runnable onFinish;

    public StopwatchService(Stopwatch stopwatch) {
        this.stopwatch = stopwatch;
    }

    public void start() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            stopwatch.decrement();

            if (onTick != null) onTick.run();

            if (stopwatch.isFinished()) {
                stop();
                if (onFinish != null) onFinish.run();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void stop() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    public void setOnTick(Runnable onTick) {
        this.onTick = onTick;
    }

    public void setOnFinish(Runnable onFinish) {
        this.onFinish = onFinish;
    }

    public Stopwatch getStopwatch() {
        return stopwatch;
    }
}
