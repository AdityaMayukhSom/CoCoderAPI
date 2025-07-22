package com.axantial.cocoder.ingestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeetCodeContest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("titleSlug")
    private String titleSlug;

    @JsonProperty("startTime")
    private Integer startTime;

    @JsonProperty("originStartTime")
    private Integer originStartTime;

    @JsonProperty("duration")
    private Integer duration;

    @JsonProperty("cardImg")
    private String cardImg;
}
