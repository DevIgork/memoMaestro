package org.example.memomaestro.controller;

import lombok.RequiredArgsConstructor;
import org.example.memomaestro.dto.NoteDto;
import org.example.memomaestro.dto.NoteDtoUpdate;
import org.example.memomaestro.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping(value = "/notes")
@RequiredArgsConstructor
@RestController
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<NoteDto> getAll() {
        return noteService.getAll();
    }

    @GetMapping("/{id}")
    public NoteDto getById(@PathVariable Long id) {
        return noteService.getById(id);
    }

    @PostMapping
    public NoteDto create(@RequestBody NoteDtoUpdate noteDto) {
        return noteService.createNote(noteDto);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public NoteDto updateById(@PathVariable Long id, @RequestBody NoteDtoUpdate noteDto) {
        return noteService.updateById(id, noteDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }
}
