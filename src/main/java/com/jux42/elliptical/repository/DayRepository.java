package com.jux42.elliptical.repository;

import com.jux42.elliptical.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Long> {

    Optional<Day> getByDate(LocalDate date);

}
