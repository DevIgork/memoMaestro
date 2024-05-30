package org.example.memomaestro.repository;

import org.example.memomaestro.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
