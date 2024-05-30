package org.example.memomaestro.service;

import org.example.memomaestro.dto.NoteDto;
import org.example.memomaestro.dto.NoteDtoUpdate;

import java.util.List;

public interface NoteService {
    List<NoteDto> getAll();

    NoteDto getById(Long id);

    NoteDto createNote(NoteDtoUpdate note);

    NoteDto updateById(Long id, NoteDtoUpdate note);

    void deleteById(Long noteId);
}
