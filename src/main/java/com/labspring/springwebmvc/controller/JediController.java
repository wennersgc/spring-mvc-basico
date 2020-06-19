package com.labspring.springwebmvc.controller;

import com.labspring.springwebmvc.model.Jedi;
import com.labspring.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    @GetMapping("/jedi")
    public ModelAndView getJedi() {
       final ModelAndView modelAndView = new ModelAndView();

       modelAndView.setViewName("jedi");
       modelAndView.addObject("allJedi", this.repository.getAll());

       return modelAndView;
    }

    @GetMapping("/new-jedi")
    public String newJedi(Model model) {
        model.addAttribute("jedi", new Jedi());
        return "new-jedi";
    }

    @PostMapping("/jedi")
    public String createJedi(@Validated @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "new-jedi";
        }

        this.repository.add(jedi);
        redirect.addFlashAttribute("message", "Jedi criado com sucesso");

        return "redirect:jedi";
    }

}
