package test.webcrawler.ze.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.webcrawler.ze.jsoup.JsoupCrawler;
import test.webcrawler.ze.jsoup.MyConstants;
import test.webcrawler.ze.jsoup.WriteWorker;

@Slf4j
@RestController
public class HttpController {

    private final JsoupCrawler jsoupCrawler;
    private final WriteWorker writeworker;

    public HttpController(JsoupCrawler jsoupCrawler, WriteWorker writeworker) {
        this.jsoupCrawler = jsoupCrawler;
        this.writeworker = writeworker;
    }

    @GetMapping("/http")
    public HttpStatus httpRequest() throws Exception {
        writeworker.startWrite(MyConstants.URL, MyConstants.WORDS);
        return HttpStatus.OK;
    }

}