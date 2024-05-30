package org.example.memomaestro.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.memomaestro.dto.NoteDto;
import org.example.memomaestro.dto.NoteDtoUpdate;
import org.example.memomaestro.exception.EntityNotFoundException;
import org.example.memomaestro.mapper.NoteMapper;
import org.example.memomaestro.model.Note;
import org.example.memomaestro.repository.NoteRepository;
import org.example.memomaestro.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Override
    public List<NoteDto> getAll() {
        return noteMapper.toDtos(noteRepository.findAll());
    }

    @Override
    public NoteDto getById(Long id) {
        return noteMapper.toDto(noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Note not found with id " + id)));
    }

    @Override
    public NoteDto createNote(NoteDtoUpdate note) {
        return noteMapper.toDto(noteRepository.save(noteMapper.toModel(note)));
    }

    @Override
    public NoteDto updateById(Long id, NoteDtoUpdate noteDto) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Note not found with id: " + id));
        note.setRecord(noteDto.getRecord());
        return noteMapper.toDto(noteRepository.save(note));
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
