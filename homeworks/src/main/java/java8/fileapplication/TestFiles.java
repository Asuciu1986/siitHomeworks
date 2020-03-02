package java8.fileapplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestFiles {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter("D:\\GitHubSiit\\siitHomeworks\\homeworks\\src\\main\\java\\java8\\fileapplication\\MOCK_DATA_WRITE.csv"));
            writer.write("Ana are mere si pere");
            writer.write("Ioana are nuci");
            System.out.println();
        }
        catch (IOException e){
            System.out.println("Eroare");
        }

        finally{
            writer.close();
        }

    }
}
