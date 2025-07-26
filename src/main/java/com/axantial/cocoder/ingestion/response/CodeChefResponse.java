package com.axantial.cocoder.ingestion.response;

import com.axantial.cocoder.ingestion.dtos.CodeChefBanner;
import com.axantial.cocoder.ingestion.dtos.CodeChefContest;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeChefResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("present_contests")
    private List<CodeChefContest> presentContests;

    @SerializedName("future_contests")
    private List<CodeChefContest> futureContests;

    @SerializedName("practice_contests")
    private List<CodeChefContest> practiceContests;

    @SerializedName("past_contests")
    private List<CodeChefContest> pastContests;

    @SerializedName("skill_tests")
    private List<CodeChefContest> skillTests;

    @SerializedName("banners")
    private List<CodeChefBanner> codeChefBanners;
}
