package com.axantial.cocoder.ingestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeetCodeData {
    @JsonProperty("topTwoContests")
    private List<LeetCodeContest> topTwoContests;
}
