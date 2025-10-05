package com.jux42.elliptical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Duration duration;
    private Double distance;
    private Integer maxForce;
    private Integer minForce;
    private Integer calories;
    private String friendlyDuration;

    @Enumerated(EnumType.STRING)
    private Performance performance;

    public void friendlyDuration() {
        this.friendlyDuration = this.duration.toMinutes() + " minutes " + this.duration.toSecondsPart() + " seconds";
    }



}
