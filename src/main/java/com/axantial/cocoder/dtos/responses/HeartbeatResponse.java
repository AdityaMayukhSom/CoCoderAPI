package com.axantial.cocoder.dtos.responses;


import lombok.Data;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class HeartbeatResponse {
    private final String status;
    private final String message;
    private final String serverTime;
    private final String uptime;

    public HeartbeatResponse(final String _status, final String _message, final OffsetDateTime _serverTime, final long _uptimeMillis) {
        this.status = _status;
        this.message = _message;
        this.serverTime = _serverTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME); // ISO 8601 format
        this.uptime = Duration.ofMillis(_uptimeMillis).toString();
    }
}