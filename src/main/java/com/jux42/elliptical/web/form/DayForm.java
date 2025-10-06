package com.jux42.elliptical.web.form;

import lombok.Data;

import java.time.LocalDate;


@Data
public class DayForm {

    private LocalDate date = LocalDate.now();
    private Integer minutes;
    private Integer seconds;
    private Double distance;
    private Integer maxForce;
    private Integer minForce;
    private Integer calories;

}
