package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Marathon;
import co2103.hw1.domain.Runner;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;





@Controller
public class RunnerController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new RunnerValidator());
    }

    @GetMapping("/runners")
    public String agents(Model model, @RequestParam int marathon) {

        Marathon CurrentMarathon = null;
        for (Marathon y : Hw1Application.marathons) {
            if (y.getId() == marathon) {
                CurrentMarathon = y;
            }
        }
        List<Runner> runners = CurrentMarathon.getRunners();
        model.addAttribute("runners", runners);
        model.addAttribute("marathonID", marathon);
        return "runners/list";
    }

    @RequestMapping("/newRunner")
    public String newRunner(Model model, @RequestParam int marathon) {
        model.addAttribute("runner", new Runner());
        model.addAttribute("marathonID", marathon);
        return "runners/form";
    }


    @PostMapping("/addRunner")
    public String addRunner(Model model, @Valid @ModelAttribute Runner runner, BindingResult result, @RequestParam int marathon) {
        if (result.hasErrors()) {
            model.addAttribute("marathonID", marathon);
            return "runners/form";
        }
        Marathon CurrentMarathon=null;
        for (Marathon y : Hw1Application.marathons) {
            if (y.getId() == marathon) {
                CurrentMarathon = y;
            }
        }
        CurrentMarathon.getRunners().add(runner);
        return "redirect:/marathons";
    }
}



