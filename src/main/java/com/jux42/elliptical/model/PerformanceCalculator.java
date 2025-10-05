package com.jux42.elliptical.model;

public class PerformanceCalculator {
    public static Performance evaluate(Day day) {
        if (day.getDuration() == null || day.getCalories() == null || day.getDuration().isZero()) {
            return Performance.LOW;
        }

        long minutes = day.getDuration().toMinutes();
        double kcalPerMinute = (double) day.getCalories() / minutes;

        if (kcalPerMinute > 12) {
            return Performance.INTENSE;
        } else if (kcalPerMinute > 9) {
            return Performance.HIGH;
        } else if (kcalPerMinute > 6) {
            return Performance.MODERATE;
        } else {
            return Performance.LOW;
        }
    }
}
