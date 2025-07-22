package com.axantial.cocoder.ingestion.response;

import com.axantial.cocoder.ingestion.dtos.LeetCodeData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeetCodeResponse {
    @JsonProperty("data")
    private LeetCodeData data;
}
