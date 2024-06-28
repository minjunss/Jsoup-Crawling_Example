package com.Crawling.Crawling;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TeamRankingResponseDto {
    private String teamRank;
    private String logo;
    private String teamName;
    private String wins;
    private String losses;
    private String winRate;
    private String winDiff;
}
