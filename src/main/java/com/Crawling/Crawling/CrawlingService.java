package com.Crawling.Crawling;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CrawlingService {
    private final String NAVER_ESPORTS_LOL_HOME = "https://game.naver.com/esports/League_of_Legends/home";

    public List<TeamRankingResponseDto> getESPORTS_LOL_RANKING() {
        List<TeamRankingResponseDto> lolRankingList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(NAVER_ESPORTS_LOL_HOME).get();
            Elements teamRankElements = doc.select("tbody.ranking_item_area__11qTP tr");
            for (Element teamElement : teamRankElements) {
                lolRankingList.add(
                        TeamRankingResponseDto.builder()
                                .teamRank(teamElement.select("td.ranking_name__t6-v5 strong.ranking_rank__1YjIT").text())
                                .logo(teamElement.select("img").attr("src"))
                                .teamName(teamElement.select("td.ranking_name__t6-v5 span.ranking_text__3Q3qr").text())
                                .wins(teamElement.select("td:nth-child(2) span.ranking_num___owTL").text())
                                .losses(teamElement.select("td:nth-child(2) span.ranking_num___owTL").text())
                                .winRate(teamElement.select("td:nth-child(4) span.ranking_num___owTL").text())
                                .winDiff(teamElement.select("td:nth-child(5) span.ranking_num___owTL").text())
                                .build()
                );
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return lolRankingList;
    }

}
