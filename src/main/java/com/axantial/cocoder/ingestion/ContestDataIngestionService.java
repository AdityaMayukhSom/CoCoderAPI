package com.axantial.cocoder.ingestion;

import com.axantial.cocoder.dtos.models.ContestData;

import java.util.List;

public interface ContestDataIngestionService {
    List<ContestData> fetchUpcomingContests();
}
