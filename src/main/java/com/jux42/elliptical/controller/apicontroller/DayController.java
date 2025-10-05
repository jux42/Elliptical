package com.jux42.elliptical.controller.apicontroller;

import com.jux42.elliptical.model.Day;
import com.jux42.elliptical.service.DayService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DayController {

    private final DayService dayService;

    @PostMapping("today")
    public ResponseEntity<String> createToday(@RequestParam Integer minutes,
                                              @RequestParam Integer seconds,
                                              @RequestParam Double distance,
                                              @RequestParam Integer maxForce,
                                              @RequestParam Integer minForce,
                                              @RequestParam Integer calories) {

        return ResponseEntity.ok(dayService.createNewDay(LocalDate.now(), minutes, seconds, distance, maxForce, minForce, calories));
    }

    @PostMapping("someday")
    public ResponseEntity<String> createSomeday(@RequestParam Integer day,
                                                @RequestParam Integer month,
                                                @RequestParam Integer year,
                                                @RequestParam Integer minutes,
                                                @RequestParam Integer seconds,
                                                @RequestParam Double distance,
                                                @RequestParam Integer maxForce,
                                                @RequestParam Integer minForce,
                                                @RequestParam Integer calories) {

        LocalDate date = LocalDate.of(year, month, day);

        return ResponseEntity.ok(dayService.createNewDay(date,minutes, seconds, distance, maxForce, minForce, calories));
    }


    @GetMapping("today")
    public ResponseEntity<Day> getToday() {
        Optional<Day> today = dayService.getToday();
        if (today.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        today.get().friendlyDuration();
        return ResponseEntity.ok(today.get());
    }

    @GetMapping("day/{day}/{month}/{year}")
    public ResponseEntity<Day> getOneDay(@PathVariable Integer day,
                                         @PathVariable Integer month,
                                         @PathVariable Integer year) {
        Optional<Day> oneDay = dayService.getOneDay(day, month, year);
        if (oneDay.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        oneDay.get().friendlyDuration();
        return ResponseEntity.ok(oneDay.get());

    }

    @GetMapping("days")
    public ResponseEntity<List<Day>> getAllDays() {
        return ResponseEntity.ok(dayService.getAllDays());
    }

    @PutMapping("day/duration/{day}/{month}/{year}/{minutes}/{seconds}")
    public ResponseEntity<String> modifyDay(@PathVariable Integer day,
                                            @PathVariable Integer month,
                                            @PathVariable Integer year,
                                            @PathVariable Integer minutes,
                                            @PathVariable Integer seconds
                                            ) {
        return ResponseEntity.ok(dayService.modifyDay(day, month, year, minutes, seconds));
    }

    @PutMapping("day/distance/{day}/{month}/{year}/{distance}")
    public ResponseEntity<String> modifyDay(@PathVariable Integer day,
                                            @PathVariable Integer month,
                                            @PathVariable Integer year,
                                            @PathVariable Double distance){
        return ResponseEntity.ok(dayService.modifyDay(day, month, year, distance));
    }

    @PutMapping("day/calories/{day}/{month}/{year}/{calories}")
    public ResponseEntity<String> modifyDay(@PathVariable Integer day,
                                            @PathVariable Integer month,
                                            @PathVariable Integer year,
                                            @PathVariable Integer calories){
        return ResponseEntity.ok(dayService.modifyDay(day, month, year, calories));
    }
}
