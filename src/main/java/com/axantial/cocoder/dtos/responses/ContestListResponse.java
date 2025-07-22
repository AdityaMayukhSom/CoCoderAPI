package com.axantial.cocoder.dtos.responses;

import com.axantial.cocoder.dtos.models.ContestData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContestListResponse {
    String message;
    List<ContestData> contests;
}
