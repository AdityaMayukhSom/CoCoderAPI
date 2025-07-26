package com.axantial.cocoder.controllers;

import com.axantial.cocoder.dtos.models.ContestData;
import com.axantial.cocoder.dtos.requests.ContestListRequest;
import com.axantial.cocoder.dtos.responses.ContestListResponse;
import com.axantial.cocoder.services.ContestDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ContestController {
    private final ContestDataService contestDataService;

    @GetMapping("/get-upcoming-contests")
    public ResponseEntity<ContestListResponse> getUpcomingContests(
        @RequestParam(name = "platform") List<String> platformStrList
    ) {
        List<ContestData> contests = contestDataService.fetchUpcomingContestsByPlatformNames(platformStrList);
        String platformCSV = String.join(",", platformStrList);
        String message = String.format("Found %d contests for %s platforms", contests.size(), platformCSV);
        return ResponseEntity.ok(new ContestListResponse(message, contests));
    }

    @PostMapping("/get-upcoming-contests")
    public ResponseEntity<ContestListResponse> getUpcomingContests(
        @RequestBody ContestListRequest contestListRequest
    ) {
        List<String> platformStrList = contestListRequest.getPlatforms();
        List<ContestData> contests = contestDataService.fetchUpcomingContestsByPlatformNames(platformStrList);
        String platformCSV = String.join(",", platformStrList);
        String message = String.format("Found %d contests for %s platforms", contests.size(), platformCSV);
        return ResponseEntity.ok(new ContestListResponse(message, contests));
    }
}
