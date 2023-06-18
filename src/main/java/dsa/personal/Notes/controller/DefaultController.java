package dsa.personal.Notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import dsa.personal.Notes.entity.Note;
import dsa.personal.Notes.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class DefaultController {
    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);
    
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/")
    public String basePage() {
        return "home";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

    @GetMapping("/notes")
    public String getAllNotes(Model model, @RequestParam(required = false) String title) {
        logger.debug("In getAllNotes");
        List<Note> notes = new ArrayList<Note>();

        if(title == null) {
            noteRepository.findAll().forEach(notes::add);
        }
        else {
            noteRepository.findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(title, null).forEach(notes::add);
        }
        model.addAttribute("notes", notes);
        return "notes";
    }
    
    @GetMapping("/notes1")
    public String getAllNotes(Model model) {
        logger.debug("In getAllNotes");
        List<Note> notes = new ArrayList<Note>();
        noteRepository.findAll().forEach(notes::add);
        model.addAttribute("notes", notes);
        return "notes";
    }    
}

