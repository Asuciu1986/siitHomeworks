package io.skibiathlon;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        CSVParse csvParse = new CSVParse();
        csvParse.setFilePath("D:\\GitHubSiit\\siitHomeworks\\homeworks\\src\\main\\java\\io\\skibiathlon\\skiori.csv");
        csvParse.parseCSV();
        System.out.println(csvParse.getBiathlonSkiersResults().topThree().toString());
        //System.out.println(csvParse.getBiathlonSkiersResults().toString());
        //System.out.println(csvParse.getBiathlonSkiersResults().topTwo());

    }
}
