package java8.fileapplication;

import java.io.*;

public class PlayFileApplication {

    public static void main(String[] args) throws IOException{

        FileApplication fileApplication = new FileApplication(
                new FileReader("D:\\GitHubSiit\\siitHomeworks\\homeworks\\src\\main\\java\\java8\\fileapplication\\MOCK_DATA.csv"),
                2,
                new FileWriter("D:\\GitHubSiit\\siitHomeworks\\homeworks\\src\\main\\java\\java8\\fileapplication\\MOCK_DATA_WRITE.csv"));
        fileApplication.convertInputToOutput();
            }
}
