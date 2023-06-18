package dsa.personal.Notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    
    @GetMapping("/ping")
    public String ping() {
        return "Grüezi !";
    }

    @GetMapping("/")
    public String basePage() {
        return "Grüezi ! Du bist zu Hause.";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "Wir haben ein Problem.";
    }
}
