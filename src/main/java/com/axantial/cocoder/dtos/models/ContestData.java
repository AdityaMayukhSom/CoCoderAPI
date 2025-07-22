package com.axantial.cocoder.dtos.models;

import com.axantial.cocoder.enums.ContestPlatform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContestData {
    private ContestPlatform platform;
    private String displayName;
    private OffsetDateTime beginTime;
    private OffsetDateTime ceaseTime;
    private Duration duration;
    private String contestLink;
}
