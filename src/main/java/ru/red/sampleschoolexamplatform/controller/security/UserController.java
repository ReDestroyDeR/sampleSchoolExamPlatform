package ru.red.sampleschoolexamplatform.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cabinet")
public class UserController {

    @GetMapping
    public ModelAndView getCabinet() {
        return null;
    }
}
