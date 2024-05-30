package org.example.memomaestro.mapper;

import org.example.memomaestro.config.MapperConfig;
import org.example.memomaestro.dto.NoteDtoUpdate;
import org.example.memomaestro.dto.NoteDto;
import org.example.memomaestro.model.Note;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import java.util.List;


@Mapper(config = MapperConfig.class)
public interface NoteMapper {
    @Named("toDto")
    NoteDto toDto(Note note);

    Note toModel(NoteDtoUpdate noteDto);

    @IterableMapping(qualifiedByName = "toDto")
    List<NoteDto> toDtos(List<Note> notes);
}
