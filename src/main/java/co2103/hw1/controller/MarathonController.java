package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Marathon;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarathonController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new MarathonsValidator());
    }

    @GetMapping("/marathons")
    public String agents(Model model) {
        model.addAttribute("marathons", Hw1Application.marathons);
        return "marathons/list";
    }
    @RequestMapping("/newMarathon")
    public String newMarathon(Model model) {
        model.addAttribute("marathon", new Marathon());
        return "marathons/form";
    }
    @PostMapping("/addMarathon")
    public String addMarathon(@Valid @ModelAttribute Marathon marathon, BindingResult result) {
        if (result.hasErrors()) {
            return "marathons/form";
        }
        Hw1Application.marathons.add(marathon);
        return "redirect:/marathons";
    }
}
