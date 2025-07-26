package com.axantial.cocoder.ingestion.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeChefContest {
    @SerializedName("contest_code")
    String contestCode;

    @SerializedName("contest_name")
    String contestName;

    @SerializedName("contest_start_date")
    String contestStartDate;

    @SerializedName("contest_end_date")
    String contestEndDate;

    @SerializedName("contest_start_date_iso")
    String contestStartDateISO;

    @SerializedName("contest_end_date_iso")
    String contestEndDateISO;

    @SerializedName("contest_duration")
    String contestDuration;

    @SerializedName("distinct_users")
    Integer distinctUsers;
}
