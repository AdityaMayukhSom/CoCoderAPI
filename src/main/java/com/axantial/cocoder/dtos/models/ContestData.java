package com.axantial.cocoder.dtos.models;

import com.axantial.cocoder.enums.ContestPlatform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContestData {
    private ContestPlatform platform;
    private String displayName;
    private String beginTime;
    private String ceaseTime;
    private String duration;
    private String contestLink;
}
