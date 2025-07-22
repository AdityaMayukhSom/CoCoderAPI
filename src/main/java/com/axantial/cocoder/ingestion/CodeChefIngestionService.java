package com.axantial.cocoder.ingestion;

import com.axantial.cocoder.dtos.models.ContestData;
import com.axantial.cocoder.enums.ContestPlatform;
import com.axantial.cocoder.ingestion.dtos.CodeChefContest;
import com.axantial.cocoder.ingestion.response.CodeChefResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CodeChefIngestionService implements ContestDataIngestionService {
    private final RestClient restClient;

    public CodeChefIngestionService() {
        this.restClient = RestClient
            .builder()
            .baseUrl("https://www.codechef.com/")
            .build();
    }

    @Override
    public List<ContestData> fetchUpcomingContests() {
        ResponseEntity<CodeChefResponse> resp = restClient
            .post()
            .uri(uriBuilder -> uriBuilder
                .path("/api/list/contests/all")
                .queryParam("sort_by", "START")
                .queryParam("sorting_order", "asc")
                .queryParam("offset", "0")
                .queryParam("mode", "all")
                .build()
            )
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .toEntity(CodeChefResponse.class);

        assert resp.getBody() != null;

        List<CodeChefContest> codeChefContests = resp.getBody().getFutureContests();
        List<ContestData> contestDataList = new ArrayList<>();

        for (CodeChefContest c : codeChefContests) {
            String contestLink = "https://www.codechef.com/" + c.getContestCode();

            OffsetDateTime beginTime = OffsetDateTime.parse(c.getContestStartDateISO());
            OffsetDateTime ceaseTime = OffsetDateTime.parse(c.getContestEndDateISO());

            Duration duration = Duration.between(beginTime, ceaseTime);

            ContestData data = ContestData
                .builder()
                .displayName(c.getContestName())
                .platform(ContestPlatform.CodeChef)
                .beginTime(beginTime)
                .ceaseTime(ceaseTime)
                .duration(duration)
                .contestLink(contestLink)
                .build();

            contestDataList.add(data);
        }

        return contestDataList;
    }
}
