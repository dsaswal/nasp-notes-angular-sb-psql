package dsa.personal.Notes.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public Optional<Note> getNote(@PathVariable("id") Long noteId) {
        logger.debug("Optional<Note> getNote" + noteId);
        return noteRepository.findById(noteId);
    }

    @PostMapping("/notes/QBE")
    public List<Note> findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(@RequestBody Note inpNote) {
        logger.debug("List<Note> NotesQBE" + inpNote);
        return noteRepository.findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(inpNote.getTitle(), inpNote.getDetails());
    }

    @GetMapping("/notes/query")
    public List<Note> findByTitleorDetails(@RequestParam("data") String strNoteData) throws JsonMappingException, JsonProcessingException, UnsupportedEncodingException {
        logger.debug("List<Note> findByTitleorDetails" + strNoteData);
        ObjectMapper objectMapper = new ObjectMapper();
        logger.debug("######### DECODED VALUE ########" + java.net.URLDecoder.decode(strNoteData, "UTF-8"));
        Note inpNote = objectMapper.readValue(java.net.URLDecoder.decode(strNoteData, "UTF-8"), Note.class);
        logger.debug("######### FROM INPUT ########" + inpNote);
        return noteRepository.findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(inpNote.getTitle(), inpNote.getDetails());
    }
}

