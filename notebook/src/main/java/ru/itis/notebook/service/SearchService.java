package ru.itis.notebook.service;

import ru.itis.notebook.models.Note;

import java.util.List;

public interface SearchService {

    List<Note> search(String text, String page) throws IllegalAccessException;
}
