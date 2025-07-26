package com.axantial.cocoder.ingestion.response;

import com.axantial.cocoder.ingestion.dtos.LeetCodeData;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeetCodeResponse {
    @SerializedName("data")
    private LeetCodeData data;
}
