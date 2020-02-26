package ru.itis.notebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ru.itis.notebook.models.Note;
import ru.itis.notebook.repositories.NotesRepository;

import java.util.List;

@Component
public class ViewServiceImpl implements ViewService {

    private int current = 0;

    @Autowired
    private NotesRepository notesRepository;

    @Override
    public List<Note> show(String page) throws IllegalAccessException {
        current = ru.itis.notebook.service.PageRequest.get(page, notesRepository.count(), current);
        return notesRepository.findAll(PageRequest.of(current, 5)).getContent();
    }

    public long size() {
        return notesRepository.count();
    }
}
