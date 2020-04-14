package java8.fileapplication;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class FileApplication {

    private Reader inputFilename;

    private int month;

    private Writer outputFilename;

    public FileApplication(Reader inputFilename, int month, Writer outputFilename) {
        this.inputFilename = inputFilename;
        this.month = month;
        this.outputFilename = outputFilename;
    }

    public Reader getInputFilename() {
        return inputFilename;
    }

    public void setInputFilename(Reader inputFilename) {
        this.inputFilename = inputFilename;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Writer getOutputFilename() {
        return outputFilename;
    }

    public void setOutputFilename(Writer outputFilename) {
        this.outputFilename = outputFilename;
    }

    public void convertInputToOutput() throws IOException {

        try (BufferedReader reader = new BufferedReader(inputFilename)) {
            try (BufferedWriter writer = new BufferedWriter(outputFilename)) {
                reader.lines()
                        .map(line -> Arrays.asList(line.split(",")))
                        .filter(line -> LocalDate.parse(line.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonthValue() == month)
                        .map(strings -> strings.get(0) + "," + strings.get(1))
                        .sorted()
                        .forEach(s -> {
                            try {
                                writer.write(s + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

            }
            catch (FileNotFoundException e){
                //e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
        }

//        try(BufferedWriter writer = new BufferedWriter(outputFilename)){
//
//            writer = stream.
//        }
    }


}
