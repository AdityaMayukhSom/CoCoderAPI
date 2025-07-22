package com.axantial.cocoder.ingestion.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeChefContest {
    @JsonProperty("contest_code")
    String contestCode;

    @JsonProperty("contest_name")
    String contestName;

    @JsonProperty("contest_start_date")
    String contestStartDate;

    @JsonProperty("contest_end_date")
    String contestEndDate;

    @JsonProperty("contest_start_date_iso")
    String contestStartDateISO;

    @JsonProperty("contest_end_date_iso")
    String contestEndDateISO;

    @JsonProperty("contest_duration")
    String contestDuration;

    @JsonProperty("distinct_users")
    Integer distinctUsers;
}
