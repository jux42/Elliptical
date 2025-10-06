package com.jux42.elliptical.web.view;

import com.jux42.elliptical.model.Day;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class DayViewMapper {

    public static DayView toView(Day day){
        return new DayView(
                day.getDate(),
                day.getFriendlyDuration(),
                day.getDistance(),
                day.getMaxForce(),
                day.getMinForce(),
                day.getCalories(),
                day.getPerformance()
        );
    }

}
