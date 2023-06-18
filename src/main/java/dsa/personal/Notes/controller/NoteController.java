package dsa.personal.Notes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dsa.personal.Notes.entity.Note;
import dsa.personal.Notes.repository.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/notes")
    public void addNote(@RequestBody Note inpNote) {
        noteRepository.save(inpNote);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        logger.debug("In getAllNotes");
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> getNote(@PathVariable Long noteId) {
        logger.debug("Optional<Note> getNote" + noteId);
        return noteRepository.findById(noteId);
    }

    @GetMapping("/notes/QBE")
    public List<Note> findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(@RequestBody Note inpNote) {
        logger.debug("Optional<Note> getNoteByQBE" + inpNote);
        return noteRepository.findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(inpNote.getTitle(), inpNote.getDetails());
    }
}
