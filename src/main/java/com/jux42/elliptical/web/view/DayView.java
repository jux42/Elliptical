package com.jux42.elliptical.web.view;

import com.jux42.elliptical.model.Performance;

import java.time.LocalDate;

public record DayView(
        LocalDate date,
        String friendlyDuration,
        Double distance,
        Integer maxForce,
        Integer minForce,
        Integer calories,
        Performance performance
) {}
