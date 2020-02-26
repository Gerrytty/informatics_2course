package ru.itis.notebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ru.itis.notebook.models.Note;
import ru.itis.notebook.repositories.NotesRepository;

import java.util.List;

@Component
public class SearchServiceImpl implements SearchService {

    private int current;

    private String s;

    @Autowired
    NotesRepository notesRepository;

    @Override
    public List<Note> search(String pattern, String page) throws IllegalAccessException {

        if (pattern != null) {
            s = pattern;
        }

        current = ru.itis.notebook.service.PageRequest.get(page, notesRepository.count(), current);

        return notesRepository.findByTitleContaining(s, PageRequest.of(current, 5)).getContent();
    }

}
