package dsa.personal.Notes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dsa.personal.Notes.entity.Note;
import dsa.personal.Notes.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DefaultController {
    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    private NoteRepository noteRepository;

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

    @GetMapping("/notes")
    public String getAllNotes(Model model) {
        logger.debug("In getAllNotes");
        List<Note> notes = new ArrayList<Note>();
        noteRepository.findAll().forEach(notes::add);
        model.addAttribute("notes", notes);
        return "notes";
    }    
}
