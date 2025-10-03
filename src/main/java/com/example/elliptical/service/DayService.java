package com.example.elliptical.service;

import com.example.elliptical.model.Day;
import com.example.elliptical.repository.DayRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DayService {

    private final DayRepository dayRepository;

    public String createNewDay (Integer minutes, Integer seconds, Double distance, Integer maxForce, Integer minForce, Integer calories) {

        if (dayRepository.getByDate(LocalDate.now()).isPresent()) return "today already created";

        Day today = Day.builder()
                .date(LocalDate.now())
                .duration(Duration.ofMinutes(minutes).plusSeconds(seconds))
                .distance(distance)
                .calories(calories)
                .maxForce(maxForce)
                .minForce(minForce)
                .build();

        try {
            dayRepository.save(today);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    public Optional<Day> getToday() {
        return dayRepository.getByDate(LocalDate.now());
    }
}
