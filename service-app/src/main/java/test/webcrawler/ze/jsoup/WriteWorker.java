package test.webcrawler.ze.jsoup;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class WriteWorker {

    private final JsoupCrawler jsoupCrawler;
    private final CsvWriter csvWriter;
    private List<Statistic> statistics;

    public WriteWorker(JsoupCrawler jsoupCrawler, CsvWriter csvWriter) {
        this.statistics = new ArrayList<>();
        this.jsoupCrawler = jsoupCrawler;
        this.csvWriter = csvWriter;
    }
    public void startWrite(String url, String[] words) throws IOException {
        read(url, words);
        for (int count = 0; count != 10; count++ ){
            repeatRead(this.statistics.get(count), words);
        }
        csvWriter.write(statistics);
    }

    public void repeatRead(Statistic statistic, String[] words) throws IOException {
        for (String url : statistic.getUrls()) {
            read(url, words);
        }
    }

    @Transactional
    public boolean read(String url, String[] words) throws IOException {
        for (String closeUrls : MyConstants.CLOSEDURLS) {
            if (url.equalsIgnoreCase(closeUrls)){
                return false;
            }
        }
        try {
            Document doc = Jsoup.connect(url).get();
            Statistic statistic = jsoupCrawler.startCrawl(doc, words);
            statistic.setUrl(url);
            this.statistics.add(jsoupCrawler.searchUrls(doc, statistic));
            MyConstants.CLOSEDURLS.add(url);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}