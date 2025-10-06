package com.jux42.elliptical.controller.uicontroller;
import org.springframework.validation.annotation.Validated;

import com.jux42.elliptical.service.DayService;
import com.jux42.elliptical.web.form.DayForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/ui/days")
@RequiredArgsConstructor
public class UiCreateDayController {

    private final DayService dayService;

    @GetMapping("/new")
    public String newForm(Model model) {
        if (!model.containsAttribute("form")) {
            DayForm form = new DayForm();
            form.setDate(LocalDate.now());
            model.addAttribute("form", form);
        }
        return "pages/day-new";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute("form") DayForm form,
                         BindingResult br,
                         RedirectAttributes ra) {

        if (br.hasErrors()) {
            ra.addFlashAttribute("org.springframework.validation.BindingResult.form", br);
            ra.addFlashAttribute("form", form);
            return "redirect:/ui/days/new";
        }

        String result = dayService.createNewDay(
                form.getDate(),
                form.getMinutes(),
                form.getSeconds(),
                form.getDistance(),
                form.getMaxForce(),
                form.getMinForce(),
                form.getCalories()
        );

        ra.addFlashAttribute("message", result);
        return "redirect:/ui/days/all?created=1";
    }
}
