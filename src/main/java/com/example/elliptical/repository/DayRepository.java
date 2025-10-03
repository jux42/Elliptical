package com.example.elliptical.repository;

import com.example.elliptical.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Long> {

    public Optional<Day> getByDate(LocalDate date);

}
