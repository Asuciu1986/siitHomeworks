package io.skibiathlon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class CSVParseTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void parseCSV() throws IOException {

        File csvFile = tempFolder.newFile("test.csv");
        try(PrintWriter printWriter = new PrintWriter(csvFile)){
            printWriter.write("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo\n" +
                    "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo\n" +
                    "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx");
        }


        CSVParse csvParse = new CSVParse();
        csvParse.setFilePath(csvFile.getPath());
        csvParse.parseCSV();
//        assertEquals()
//        csvParse.getBiathlonSkiersResults().topThree()

        assertEquals("[BiathlonSkier{name='Piotr Smitzer', initialTime=00:30:10, standingTime=00:30:10}, BiathlonSkier{name='Jimmy Smiles', initialTime=00:29:15, standingTime=00:30:15}, BiathlonSkier{name='Umar Jorgson', initialTime=00:30:27, standingTime=00:30:57}]",
                csvParse.getBiathlonSkiersResults().topThree().toString());

    }

    @Test(expected = IOException.class)
    public void parseCSV1() throws IOException {

        CSVParse csvParse = new CSVParse();
        csvParse.setFilePath("nimic");

        csvParse.parseCSV();

    }


}