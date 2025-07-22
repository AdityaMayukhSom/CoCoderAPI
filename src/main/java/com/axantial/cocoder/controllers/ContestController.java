package com.axantial.cocoder.controllers;

import com.axantial.cocoder.dtos.models.ContestData;
import com.axantial.cocoder.dtos.requests.ContestListRequest;
import com.axantial.cocoder.dtos.responses.ContestListResponse;
import com.axantial.cocoder.enums.ContestPlatform;
import com.axantial.cocoder.services.ContestDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContestController {
    private final ContestDataService contestDataService;

    public ContestController(ContestDataService _contestDataService) {
        this.contestDataService = _contestDataService;
    }

    @PostMapping("/api/v1/get-upcoming-contests")
    public ResponseEntity<ContestListResponse> getUpcomingContests(
        @RequestBody ContestListRequest contestListRequest
    ) {
        List<String> platformStrList = contestListRequest.getPlatforms();
        String platformCSV = String.join(", ", platformStrList);
        List<ContestPlatform> platforms = new ArrayList<>();
        for (String p : platformStrList) {
            platforms.add(ContestPlatform.valueOf(p));
        }
        List<ContestData> contests = contestDataService.fetchUpcomingContests(platforms);
        String message = String.format("Found %d contests for %s platforms", contests.size(), platformCSV);
        return ResponseEntity.ok(new ContestListResponse(message, contests));
    }
}
