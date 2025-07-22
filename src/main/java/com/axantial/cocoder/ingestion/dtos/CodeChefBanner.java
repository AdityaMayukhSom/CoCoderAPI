package com.axantial.cocoder.ingestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeChefBanner {
    @JsonProperty("image")
    String image;

    @JsonProperty("link")
    String link;
}
