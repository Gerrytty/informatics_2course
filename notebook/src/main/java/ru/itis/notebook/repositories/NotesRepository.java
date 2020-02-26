package ru.itis.notebook.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.notebook.models.Note;


public interface NotesRepository extends JpaRepository<Note, Long> {
    Page<Note> findByTitleContaining(String pattern, Pageable pageable);
}
