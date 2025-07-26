package com.axantial.cocoder.ingestion.response;

import com.axantial.cocoder.ingestion.dtos.CodeforcesContest;
import com.google.gson.annotations.SerializedName;
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
    @SerializedName("status")
    public String status;

    @SerializedName("result")
    public List<CodeforcesContest> contests;
}
