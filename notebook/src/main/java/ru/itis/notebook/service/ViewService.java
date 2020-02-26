package ru.itis.notebook.service;

import ru.itis.notebook.models.Note;
import java.util.List;

public interface ViewService {

    List<Note> show(String page) throws IllegalAccessException;

    long size();

}
