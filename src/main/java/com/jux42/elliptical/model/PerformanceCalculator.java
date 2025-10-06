package com.jux42.elliptical.model;

public class PerformanceCalculator {
    public static Performance evaluate(Day day) {
        if (day.getDuration() == null || day.getCalories() == null || day.getDuration().isZero()) {
            return Performance.LOW;
        }

        long minutes = day.getDuration().toMinutes();
        double kcalPerMinute = (double) day.getCalories() / minutes;


        return kcalPerMinute > 12 ? Performance.INTENSE
                : kcalPerMinute > 9 ? Performance.HIGH
                : kcalPerMinute > 6 ? Performance.MODERATE
                : Performance.LOW;
    }
}
