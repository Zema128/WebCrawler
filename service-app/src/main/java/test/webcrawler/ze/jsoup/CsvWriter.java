package test.webcrawler.ze.jsoup;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.Map;

@Component
public class CsvWriter {

    public void write(List<Statistic> statistics){
        try(PrintWriter pw = new PrintWriter("out.csv")) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Statistic s : statistics) {
                stringBuilder.append(s.getUrl());
                stringBuilder.append(',');
                stringBuilder.append(s.getStatistic());
                stringBuilder.append(',');
                stringBuilder.append("Total: ");
                stringBuilder.append(s.getTotalCount());
                stringBuilder.append("\n");
                pw.write(stringBuilder.toString());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}