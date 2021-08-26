package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NoteData {
    static List<Note> notes = new ArrayList<>(Arrays.asList(
            new Note(1L, "First title", "First content"),
            new Note(2L, "Second title", "Second content"),
            new Note(3L, "Third title", "Third content")
    ));
}
