package org.launchcode.Ch15Lecture.controllers;

import org.launchcode.Ch15Lecture.data.DinoData;
import org.launchcode.Ch15Lecture.models.Dinosaur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("dino")
public class DinoController {

    @GetMapping
    public String dino(Model model) {
        model.addAttribute("allDinos", DinoData.getAllDinos());
        return "dino/index";
    }

    @GetMapping("add")
    public String displayAddDinoForm(Model model) {
        model.addAttribute("dinosaur", new Dinosaur());
        return "dino/add";
    }

    @PostMapping("add")
    public String processAddDinoForm(Model model, @ModelAttribute @Valid Dinosaur newDinoObj,
                                    Errors errors) {

        if(errors.hasErrors()) {
            model.addAttribute("errorMsg","The species must contain at least 3 characters!");
            return "dino/add";
        }

        DinoData.addDino(newDinoObj);
        //model.addAttribute("allDinos", DinoData.getAllDinos());
        //return "dino/index";
        return "redirect:"; //send get request back to root path from this controller
    }

}