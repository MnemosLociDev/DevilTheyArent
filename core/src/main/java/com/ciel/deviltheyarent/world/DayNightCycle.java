package com.ciel.deviltheyarent.world;

public class DayNightCycle {

    public enum Phase {
        NIGHT,
        DAY,
    }

    private float nightDuration = 30f;
    private float dayDuration = 20f;
    private float timer;
    private Phase currentPhase;

    public DayNightCycle() {
        currentPhase = Phase.NIGHT;
        timer = nightDuration;
    }

    public void update(float delta) {
        timer -= delta;
        if (timer <= 0) {
            if (currentPhase == Phase.NIGHT) {
                currentPhase = Phase.DAY;
                timer = dayDuration;
            } else {
                currentPhase = Phase.NIGHT;
                timer = nightDuration;
            }
        }
    }

    public Phase getPhase() {
        return currentPhase;
    }

    public float getTimer() {
        return timer;
    }

    public boolean isDay() {
        return currentPhase == Phase.DAY;
    }

    public boolean isNight() {
        return currentPhase == Phase.NIGHT;
    }
}
