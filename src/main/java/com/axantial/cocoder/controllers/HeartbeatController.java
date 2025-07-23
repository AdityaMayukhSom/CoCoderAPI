package com.axantial.cocoder.controllers;

import com.axantial.cocoder.dtos.responses.HeartbeatResponse;
import com.axantial.cocoder.dtos.responses.PingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v1") // Base path for the heartbeat endpoint
public class HeartbeatController {

    @GetMapping("/heartbeat")
    public ResponseEntity<HeartbeatResponse> getHeartbeat() {
        OffsetDateTime serverTime = OffsetDateTime.now();
        long uptimeMillis = ManagementFactory.getRuntimeMXBean().getUptime();
        String message = "Application is running smoothly and responding.";
        HeartbeatResponse response = new HeartbeatResponse("OK", message, serverTime, uptimeMillis);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ping")
    public ResponseEntity<PingResponse> ping() {
        return ResponseEntity.ok(new PingResponse("pong"));
    }
}