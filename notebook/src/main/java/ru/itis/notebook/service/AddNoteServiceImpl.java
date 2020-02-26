package ru.itis.notebook.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import ru.itis.notebook.dto.NoteDto;
import ru.itis.notebook.models.Note;
import ru.itis.notebook.repositories.NotesRepository;

@Component
public class AddNoteServiceImpl implements AddNoteService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public void add(NoteDto noteDto) {
        notesRepository.save(Note.builder().title(noteDto.getTitle()).body(noteDto.getBody()).build());
    }

}
