package ru.itis.notebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.notebook.dto.NoteDto;
import ru.itis.notebook.models.Note;
import ru.itis.notebook.service.AddNoteService;
import ru.itis.notebook.service.SearchService;
import ru.itis.notebook.service.ViewService;

import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private AddNoteService service;

    @Autowired
    private ViewService viewService;

    @Autowired
    private SearchService searchService;

    @RequestMapping("/add")
    public String add() {
        return "addNote";
    }

    @RequestMapping("/notes/{page}")
    public String getNotes(Model model, @PathVariable String page) {

        try {
            List<Note> list = viewService.show(page);
            model.addAttribute("notes", list);
            model.addAttribute("size", viewService.size());

            return "allNotes";

        } catch (IllegalAccessException e) {
            return "wrongParam";
        }

    }

    @RequestMapping("/addNote")
    public String addNote(@ModelAttribute NoteDto noteDto) {
        service.add(noteDto);
        return "redirect:notes";
    }

    @RequestMapping("/search/{page}")
    public String search(@ModelAttribute NoteDto noteDto, Model model,
                         @PathVariable String page) {

        try {
            List<Note> list = searchService.search(noteDto.getTitle(), page);
            model.addAttribute("size", list.size());
            model.addAttribute("notes", list);

            return "allNotes";

        } catch (IllegalAccessException e) {
            return "wrongParam";
        }

    }
}
