package org.example.memomaestro.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NoteDto {
    private Long id;
    private String record;
}
