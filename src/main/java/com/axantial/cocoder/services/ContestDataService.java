package com.axantial.cocoder.services;

import com.axantial.cocoder.dtos.models.ContestData;
import com.axantial.cocoder.enums.ContestPlatform;
import com.axantial.cocoder.ingestion.CodeChefIngestionService;
import com.axantial.cocoder.ingestion.CodeforcesIngestionService;
import com.axantial.cocoder.ingestion.ContestDataIngestionService;
import com.axantial.cocoder.ingestion.LeetCodeIngestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ContestDataService {
    private static final Logger log = LoggerFactory.getLogger(ContestDataService.class);
    private final ContestDataIngestionService ccService;
    private final ContestDataIngestionService cfService;
    private final ContestDataIngestionService lcService;

    public ContestDataService(
        CodeChefIngestionService _ccService,
        LeetCodeIngestionService _lcService,
        CodeforcesIngestionService _cfService
    ) {
        this.ccService = _ccService;
        this.cfService = _cfService;
        this.lcService = _lcService;
    }


    public List<ContestData> fetchUpcomingContestsByPlatformNames(List<String> platformStrList) {
        List<ContestPlatform> platforms = new ArrayList<>();
        for (String p : platformStrList) {
            platforms.add(ContestPlatform.valueOf(p));
        }
        return this.fetchUpcomingContestsByPlatform(platforms);
    }

    public List<ContestData> fetchUpcomingContestsByPlatform(List<ContestPlatform> platforms) {
        List<CompletableFuture<List<ContestData>>> allFutures = new ArrayList<>();

        for (ContestPlatform platform : platforms) {
            log.info("Fetching upcoming contests for platform {}", platform.getDisplayName());
            CompletableFuture<List<ContestData>> incomingData = switch (platform) {
                case CodeChef -> CompletableFuture.supplyAsync(ccService::fetchUpcomingContests);
                case LeetCode -> CompletableFuture.supplyAsync(lcService::fetchUpcomingContests);
                case Codeforces -> CompletableFuture.supplyAsync(cfService::fetchUpcomingContests);
            };
            allFutures.add(incomingData);
        }

        List<ContestData> contestDataList = new ArrayList<>();
        for (CompletableFuture<List<ContestData>> future : allFutures) {
            contestDataList.addAll(future.join());
        }
        return contestDataList;
    }
}
