package test.webcrawler.ze.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class JsoupCrawler {
    public void startCrawl() throws IOException {
        String url = "https://ru.wikipedia.org/wiki/Tesla";
        String targetName = "Tesla";

        Document doc = Jsoup.connect(url).get();

        Elements names = doc.getElementsContainingOwnText(targetName);
        ArrayList<String> sortNames = new ArrayList<>();

        ArrayList<String> strings = new ArrayList<>();
        for (Element e : names) {
            strings.add(e.text());
        }

        for (String s : strings) {
            String[] newstr = s.split(" ");
            for (String string : newstr) {
                if (string.equalsIgnoreCase(targetName)){
                    sortNames.add(string);
                }
            }
//            System.out.println(s);
        }
        System.out.println(sortNames);
        System.out.println("size = " + sortNames.size());
//        String elements = String.valueOf(doc.text().contains(targetName));
//        System.out.println(elements);
//
//        Elements pageElements = doc.select("a[href]");
//        Elements nameelements = doc.getElementsContainingText(targetName);
//
//        ArrayList<String> hyperLinks = new ArrayList<String>();
//        ArrayList<String> names = new ArrayList<>();
//
//
//        for (Element e : pageElements) {
//            hyperLinks.add("Text: " + e.text());
//            hyperLinks.add("Link: " + e.attr("href"));
//        }
//        for (String s : hyperLinks) {
//            System.out.println(s);
//        }
//
//        System.out.println(nameelements);
//        for (Element e: nameelements) {
//            names.add("Name: " + e.text());
//        }
//        for (String s : names) {
//            System.out.println(s);
//        }


    }
}
