package com.Crawling.Crawling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrawlingController {
    private final CrawlingService crawlingService;

    @GetMapping("/crawling/lolRankig")
    public ResponseEntity<?> lolRanking() {
        return ResponseEntity.ok(crawlingService.getESPORTS_LOL_RANKING());
    }
}
