package test.webcrawler.ze.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.webcrawler.ze.jsoup.JsoupCrawler;

@Slf4j
@RestController
public class HttpController {

    private final JsoupCrawler jsoupCrawler;

    public HttpController(JsoupCrawler jsoupCrawler) {
        this.jsoupCrawler = jsoupCrawler;
    }

    @GetMapping("/http")
    public HttpStatus httpRequest() throws Exception {
        jsoupCrawler.startCrawl();
        return HttpStatus.OK;
    }

}