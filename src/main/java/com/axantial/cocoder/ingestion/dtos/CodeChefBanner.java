package com.axantial.cocoder.ingestion.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeChefBanner {
    @SerializedName("image")
    String image;

    @SerializedName("link")
    String link;
}
