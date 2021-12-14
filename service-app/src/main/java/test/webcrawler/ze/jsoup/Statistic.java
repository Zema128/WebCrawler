package test.webcrawler.ze.jsoup;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Data
public class Statistic {
    private String url;
    private LinkedHashMap<String, Integer> statistic;
    private int totalCount;
    private List<String> urls;
    public void addUrl(String url){
        this.urls.add(url);
    }
}
