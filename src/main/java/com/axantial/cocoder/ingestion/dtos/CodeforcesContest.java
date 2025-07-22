package com.axantial.cocoder.ingestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeforcesContest {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("phase")
    private String phase;

    @JsonProperty("frozen")
    private Boolean frozen;

    @JsonProperty("durationSeconds")
    private Integer durationSeconds;

    @JsonProperty("startTimeSeconds")
    private Integer startTimeSeconds;

    @JsonProperty("relativeTimeSeconds")
    private Integer relativeTimeSeconds;
}

