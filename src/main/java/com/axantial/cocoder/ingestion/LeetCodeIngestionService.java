package com.axantial.cocoder.ingestion;

import com.axantial.cocoder.dtos.models.ContestData;
import com.axantial.cocoder.enums.ContestPlatform;
import com.axantial.cocoder.ingestion.dtos.LeetCodeContest;
import com.axantial.cocoder.ingestion.dtos.LeetCodeData;
import com.axantial.cocoder.ingestion.response.LeetCodeResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeetCodeIngestionService implements ContestDataIngestionService {
    private final RestClient restClient;

    public LeetCodeIngestionService() {
        this.restClient = RestClient
            .builder()
            .baseUrl("https://leetcode.com/")
            .build();
    }

    @Override
    public List<ContestData> fetchUpcomingContests() {
        String graphqlQuery = """
            query {
                topTwoContests {
                    title
                    titleSlug
                    startTime
                    originStartTime
                    duration
                    cardImg
                }
            }
            """;

        // Create the JSON payload as a Map
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", graphqlQuery);
        // Empty variables object as per your curl command
        requestBody.put("variables", new HashMap<>());

        ResponseEntity<LeetCodeResponse> resp = restClient.post()
            .uri("/graphql")
            .body(requestBody)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .toEntity(LeetCodeResponse.class);

        assert resp.getBody() != null;

        LeetCodeResponse lcBody = resp.getBody();
        LeetCodeData lcData = lcBody.getData();
        List<LeetCodeContest> lcContests = lcData.getTopTwoContests();

        List<ContestData> contests = new ArrayList<>();

        for (LeetCodeContest c : lcContests) {
            String contestLink = "https://www.leetcode.com/contest/" + c.getTitleSlug();

            OffsetDateTime beginTime = Instant
                .ofEpochSecond(c.getOriginStartTime())
                .atOffset(ZoneOffset.ofHoursMinutes(5, 30));

            OffsetDateTime ceaseTime = Instant
                .ofEpochSecond(c.getOriginStartTime() + c.getDuration())
                .atOffset(ZoneOffset.ofHoursMinutes(5, 30));

            Duration duration = Duration.between(beginTime, ceaseTime);

            ContestData data = ContestData
                .builder()
                .displayName(c.getTitle())
                .platform(ContestPlatform.LeetCode)
                .beginTime(beginTime.toString())
                .ceaseTime(ceaseTime.toString())
                .duration(duration.toString())
                .contestLink(contestLink)
                .build();

            contests.add(data);
        }

        return contests;
    }
}
