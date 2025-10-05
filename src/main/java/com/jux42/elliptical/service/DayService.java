package com.jux42.elliptical.service;

import com.jux42.elliptical.model.Day;
import com.jux42.elliptical.model.PerformanceCalculator;
import com.jux42.elliptical.repository.DayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class DayService {

    private final DayRepository dayRepository;

    public String createNewDay (LocalDate date, Integer minutes, Integer seconds, Double distance, Integer maxForce, Integer minForce, Integer calories) {

        if (dayRepository.getByDate(date).isPresent()) return "day already created";

        Day today = Day.builder()
                .date(date)
                .duration(Duration.ofMinutes(minutes).plusSeconds(seconds))
                .distance(distance)
                .calories(calories)
                .maxForce(maxForce)
                .minForce(minForce)
                .build();
        today.setPerformance(PerformanceCalculator.evaluate(today));

        try {
            dayRepository.save(today);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }

    }

    public String modifyDay(Integer day, Integer month, Integer year,Integer minutes, Integer seconds){
        return modifyDay(day, month, year, d -> d.setDuration(Duration.ofMinutes(minutes).plusSeconds(seconds)));
    }

    public String modifyDay(Integer day, Integer month, Integer year,Integer calories){
        return modifyDay(day, month, year, d -> d.setCalories(calories));
    }

    public String modifyDay(Integer day, Integer month, Integer year,Double distance){
        return modifyDay(day, month, year, d -> d.setDistance(distance));
    }

    private String modifyDay(Integer day, Integer month, Integer year, Consumer<Day> mutator) {
        LocalDate date = LocalDate.of(year, month, day);
        return dayRepository.getByDate(date)
                .map(d -> {
                    mutator.accept(d);
                    d.setPerformance(PerformanceCalculator.evaluate(d));
                    dayRepository.save(d);
                    return "successfully modified";
                })
                .orElse("no day found");
    }

    public Optional<Day> getToday() {
        return dayRepository.getByDate(LocalDate.now());
    }

    public Optional<Day> getOneDay(Integer day, Integer month, Integer year) {

        LocalDate date = LocalDate.of(year, month, day);
        return dayRepository.getByDate(date);
    }

    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }


}
