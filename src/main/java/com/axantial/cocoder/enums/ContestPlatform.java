package com.axantial.cocoder.enums;

import lombok.Getter;

@Getter
public enum ContestPlatform {
    CodeChef("CodeChef"),
    LeetCode("LeetCode"),
    Codeforces("Codeforces");

    private final String displayName;

    ContestPlatform(String displayName) {
        this.displayName = displayName;
    }
}
