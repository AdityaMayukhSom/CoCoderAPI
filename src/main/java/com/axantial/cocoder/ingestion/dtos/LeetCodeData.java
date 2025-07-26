package com.axantial.cocoder.ingestion.dtos;

import com.google.gson.annotations.SerializedName;
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
    @SerializedName("topTwoContests")
    private List<LeetCodeContest> topTwoContests;
}
