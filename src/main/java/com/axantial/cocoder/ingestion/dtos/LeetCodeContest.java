package com.axantial.cocoder.ingestion.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeetCodeContest {
    @SerializedName("title")
    private String title;

    @SerializedName("titleSlug")
    private String titleSlug;

    @SerializedName("startTime")
    private Integer startTime;

    @SerializedName("originStartTime")
    private Integer originStartTime;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("cardImg")
    private String cardImg;
}
