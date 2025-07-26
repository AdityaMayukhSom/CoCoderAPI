package com.axantial.cocoder.ingestion.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeforcesContest {
    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("phase")
    private String phase;

    @SerializedName("frozen")
    private Boolean frozen;

    @SerializedName("durationSeconds")
    private Integer durationSeconds;

    @SerializedName("startTimeSeconds")
    private Integer startTimeSeconds;

    @SerializedName("relativeTimeSeconds")
    private Integer relativeTimeSeconds;
}

