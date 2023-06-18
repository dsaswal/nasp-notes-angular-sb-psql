package dsa.personal.Notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dsa.personal.Notes.entity.Note;
import java.util.List;
// import dsa.personal.Notes.entity.Tag;
// import dsa.personal.Notes.entity.Topic;

public interface NoteRepository extends JpaRepository<Note, Long> {
    
    List<Note> findByTitle(String title);

    // List<Note> findByTagId(Integer tagId);

    // List<Note> findByQBE(Note note);
}
