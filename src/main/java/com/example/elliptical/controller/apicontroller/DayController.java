package com.example.elliptical.controller.apicontroller;

import com.example.elliptical.model.Day;
import com.example.elliptical.service.DayService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                              @RequestParam Integer calories){

        return ResponseEntity.ok(dayService.createNewDay(minutes, seconds, distance, maxForce, minForce, calories ));
    }

    @GetMapping("today")
    public ResponseEntity<Day> getToday() {
         Optional<Day> today = dayService.getToday();
         if(today.isEmpty()){
             return ResponseEntity.noContent().build();
         }
         today.get().friendlyDuration();
         return ResponseEntity.ok(today.get());
    }
}
