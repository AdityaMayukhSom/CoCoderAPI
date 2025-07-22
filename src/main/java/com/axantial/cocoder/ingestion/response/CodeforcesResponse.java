package com.axantial.cocoder.ingestion.response;

import com.axantial.cocoder.ingestion.dtos.CodeforcesContest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeforcesResponse {
    @JsonProperty("status")
    public String status;
    
    @JsonProperty("result")
    public List<CodeforcesContest> contests;
}
