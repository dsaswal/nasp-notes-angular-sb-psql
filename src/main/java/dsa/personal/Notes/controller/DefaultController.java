package dsa.personal.Notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DefaultController {
    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);
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
