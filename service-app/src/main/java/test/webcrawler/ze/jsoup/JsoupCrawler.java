package test.webcrawler.ze.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class JsoupCrawler {
    private final CsvWriter csvWriter;

    public JsoupCrawler(CsvWriter csvWriter) {
        this.csvWriter = csvWriter;
    }

    public Statistic startCrawl(Document doc, String[] words) throws IOException {
        LinkedHashMap<String, Integer> values = new LinkedHashMap<>();
        Statistic statistic = new Statistic();
        if (words != null){
            for (String targetName : words) {
                Elements names = doc.getElementsContainingOwnText(targetName);
                statistic.setTotalCount(statistic.getTotalCount() + names.size());
                values.put(targetName, names.size());
                System.out.println("names size = " + names.size());
            }
        }
        statistic.setStatistic(values);
        return statistic;
    }

    public Statistic searchUrls(Document doc, Statistic statistic){
        Elements pageNames = doc.select("a[href]");
        List<String> urls = new ArrayList<>();
        for (Element e : pageNames) {
            urls.add(e.absUrl("href"));
        }
        statistic.setUrls(urls);
        System.out.println("Size: " + statistic.getUrls().size());
        return statistic;
    }
}