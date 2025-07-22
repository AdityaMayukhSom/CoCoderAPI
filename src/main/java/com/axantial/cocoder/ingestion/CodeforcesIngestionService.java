package com.axantial.cocoder.ingestion;

import com.axantial.cocoder.dtos.models.ContestData;
import com.axantial.cocoder.enums.ContestPlatform;
import com.axantial.cocoder.ingestion.dtos.CodeforcesContest;
import com.axantial.cocoder.ingestion.response.CodeforcesResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class CodeforcesIngestionService implements ContestDataIngestionService {
    private final RestClient restClient;

    public CodeforcesIngestionService() {
        this.restClient = RestClient
            .builder()
            .baseUrl("https://codeforces.com/")
            .build();
    }

    @Override
    public List<ContestData> fetchUpcomingContests() {
        ResponseEntity<CodeforcesResponse> resp = restClient
            .get()
            .uri("/api/contest.list")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntity(CodeforcesResponse.class);

        assert resp.getBody() != null;

        List<CodeforcesContest> cfContests = resp.getBody().getContests();
        List<ContestData> contests = new ArrayList<>();

        for (CodeforcesContest c : cfContests) {
            if (!"BEFORE".equals(c.getPhase())) {
                continue;
            }

            String contestLink = "https://www.codeforces.com/contest/" + c.getId();

            OffsetDateTime beginTime = Instant
                .ofEpochSecond(c.getStartTimeSeconds())
                .atOffset(ZoneOffset.ofHoursMinutes(5, 30));

            OffsetDateTime ceaseTime = Instant
                .ofEpochSecond(c.getStartTimeSeconds() + c.getDurationSeconds())
                .atOffset(ZoneOffset.ofHoursMinutes(5, 30));

            Duration duration = Duration.between(beginTime, ceaseTime);

            ContestData data = ContestData
                .builder()
                .displayName(c.getName())
                .platform(ContestPlatform.Codeforces)
                .beginTime(beginTime)
                .ceaseTime(ceaseTime)
                .duration(duration)
                .contestLink(contestLink)
                .build();

            contests.add(data);
        }

        return contests;
    }
}
