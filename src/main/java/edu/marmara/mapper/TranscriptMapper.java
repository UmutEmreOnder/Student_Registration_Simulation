package edu.marmara.mapper;

import edu.marmara.dto.TranscriptGetDTO;
import edu.marmara.model.Transcript;

public interface TranscriptMapper {
    Transcript mapTo(TranscriptGetDTO transcriptGetDTO);
    TranscriptGetDTO mapTo(Transcript transcript);
}
