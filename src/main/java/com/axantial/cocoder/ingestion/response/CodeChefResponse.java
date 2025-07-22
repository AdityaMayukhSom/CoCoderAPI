package com.axantial.cocoder.ingestion.response;

import com.axantial.cocoder.ingestion.dtos.CodeChefBanner;
import com.axantial.cocoder.ingestion.dtos.CodeChefContest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeChefResponse {
    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("present_contests")
    private List<CodeChefContest> presentContests;

    @JsonProperty("future_contests")
    private List<CodeChefContest> futureContests;

    @JsonProperty("practice_contests")
    private List<CodeChefContest> practiceContests;

    @JsonProperty("past_contests")
    private List<CodeChefContest> pastContests;

    @JsonProperty("skill_tests")
    private List<CodeChefContest> skillTests;

    @JsonProperty("banners")
    private List<CodeChefBanner> codeChefBanners;
}
