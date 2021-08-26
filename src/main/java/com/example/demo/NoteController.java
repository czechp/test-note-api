package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/notes")
@CrossOrigin("*")
class NoteController {
    @GetMapping()
    List<Note> findAll() {
        return NoteData.notes;
    }

    @GetMapping("/{noteId}")
    Note findById(
            @PathVariable(name = "noteId") final long noteId
    ) {
        return NoteData.notes
                .stream()
                .filter(note -> note.getId() == noteId)
                .findAny()
                .orElseThrow(() -> new NoteNotFoundException());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    void addNewNote(
            @RequestBody() Note note
    ) {
        note.setId(
                NoteData.notes
                        .stream()
                        .map(n -> n.getId())
                        .max(Long::compare)
                        .orElse(0L) + 1
        );
        NoteData.notes.add(note);
    }

    @DeleteMapping("/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteNoteById(
            @PathVariable(name = "noteId") final long noteId
    ) {
        Note note = NoteData.notes
                .stream()
                .filter(n -> n.getId() == noteId)
                .findAny()
                .orElseThrow(() -> new NoteNotFoundException());
        NoteData.notes.remove(note);
    }

    @PutMapping("/{noteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void modifyNote(
            @PathVariable(name="noteId") final long noteId,
            @RequestBody() final Note note
    ){
        Note persistedNote = NoteData.notes
                .stream()
                .filter(n -> n.getId() == noteId)
                .findAny()
                .orElseThrow(() -> new NoteNotFoundException());
        persistedNote.setTitle(note.getTitle());
        persistedNote.setContent(note.getContent());
    }


}
