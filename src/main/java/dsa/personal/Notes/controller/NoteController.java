package dsa.personal.Notes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dsa.personal.Notes.entity.Note;
import dsa.personal.Notes.repository.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

    private NoteRepository noteRepository;

    @PostMapping("/notes")
    public void addNote(@RequestBody Note inpNote) {
        noteRepository.save(inpNote);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

}
