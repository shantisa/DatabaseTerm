package edu.cs.uga.DatabaseTermProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {
    @GetMapping({"/"}) // , "home"
    public String index(Model model) {
        return "home";
    }
}
