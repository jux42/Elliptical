package com.jux42.elliptical.controller.uicontroller;

import com.jux42.elliptical.service.DayService;
import com.jux42.elliptical.web.view.DayViewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ui")
@RequiredArgsConstructor

public class UiController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "pages/dashboard";
    }

    @GetMapping("/stats")
    public String stats() {
        return "pages/stats";
    }

    private final DayService dayService;

    @GetMapping ("/days/all")
    public String listDays(@RequestParam(required = false) Integer created, Model model) {
        var days = dayService.getAllDays().stream().map(DayViewMapper::toView).toList();
        model.addAttribute("days", days);
        if (created != null) model.addAttribute("message", "Day created");
        return "pages/days";
    }

    @GetMapping("/days/detail")
    public String dayDetail(@RequestParam int day, @RequestParam int month, @RequestParam int year, Model model) {
        return dayService.getOneDay(day, month, year)
                .map(d -> {
                    model.addAttribute("day", DayViewMapper.toView(d));
                    return "pages/day-detail";
                })
                .orElse("pages/not-found");
    }

    @GetMapping("/days/search")
    public String searchDayForm() {
        return "pages/day-search";
    }

    @GetMapping("/settings")
    public String settings() {
        return "pages/settings";
    }
}
