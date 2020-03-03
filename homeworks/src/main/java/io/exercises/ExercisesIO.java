package io.exercises;


import sun.security.x509.AttributeNameEnumeration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExercisesIO {

    public static void main(String[] args) throws IOException {

        for (String fisier : getListOfFilesAndFolders("D:\\Java")
        ) {
            System.out.println(fisier);
        }

        for (String fisier : getListOfFilesAndFoldersWithExtension("D:\\Java", ".docx")
        ) {
            System.out.println(fisier);
        }

        System.out.println(checkFileExistence("D:\\"));
        System.out.println(checkReadAndWritePermission("Z:\\"));
        System.out.println(pathIsFileOrFolder("D:\\Java\\Head First Java - Kathy Sierra _ Bert Rates.pdf"));
        System.out.println(compareFilesLexicographically("D:\\Java\\Head First Java - Kathy Sierra _ Bert Rates.pdf", "D:\\Java\\Java_8.pptx"));
        System.out.println(lastModificationTime("D:\\Java\\Java_8.pptx"));
        //System.out.println(readInputFromConsole());
        System.out.println(fileSize("D:\\Java\\Java_8.pptx", "kb"));
        System.out.println(Arrays.toString(readFileInByteArray("D:\\Java\\new.txt")));
        for (String s:readLineByLine("D:\\Java\\new.txt")
             ) {
            System.out.println(s);
        }
        System.out.println(readATextFile("D:\\Java\\new.txt"));
        String[] lines = readAFileIntoArray("D:\\Java\\new.txt");
        for (String s:lines
             ) {
            System.out.println(s);

        }

    }

    public static List<String> getListOfFilesAndFolders(String path) {

        File cale = new File(path);

        List<String> listaFisiere = new ArrayList<String>(Arrays.asList(cale.list()));
        return listaFisiere;
    }

    public static List<String> getListOfFilesAndFoldersWithExtension(String path, String pattern) {
        List<String> listaFisiere = new ArrayList<>();
        try (Stream<Path> pathStream = Files.walk(Paths.get(path))) {
            listaFisiere = pathStream.map(x -> x.toString())
                    .filter(f -> f.endsWith(pattern))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaFisiere;
    }

    public static boolean checkFileExistence(String path) {

        return Files.exists(Paths.get(path));
    }

    public static boolean checkReadAndWritePermission(String path) {

        return Files.isReadable(Paths.get(path)) && Files.isWritable(Paths.get(path));
    }

    public static String pathIsFileOrFolder(String path) {

        boolean isDirectory = Files.isDirectory(Paths.get(path));
        if (isDirectory) {
            return "Directory";
        } else {
            return "File";
        }
    }

    public static String compareFilesLexicographically(String path1, String path2) {

        File file1 = new File(path1);
        File file2 = new File(path2);

        int compare = file1.compareTo(file2);
        if (compare == 0) {
            return "Equal Files";
        } else if (compare < 0) {
            return "Second File is greater";
        } else {
            return "First file is greater";
        }
    }

    public static String lastModificationTime(String path) throws IOException {

        return Files.getLastModifiedTime(Paths.get(path)).toString();
    }

    public static String readInputFromConsole() throws IOException {

        String text = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            text = reader.readLine();
        }

        return text;
    }

    public static double fileSize(String path, String unitOfMeasure) throws IOException {
        File file = new File(path);
        double size = (double) Files.size(Paths.get(path));
        double sizeToReturn = 0;
        System.out.println(size);

        switch (unitOfMeasure) {

            case "bytes":
                sizeToReturn = size;
                break;

            case "kb":
                sizeToReturn = size / 1024;
                break;

            case "mb":
                sizeToReturn = size / 1024 / 1024;
        }

        return sizeToReturn;
    }


    public static byte[] readFileInByteArray(String path) {

        File file = new File(path);
        //length in byte
        int len = (int) file.length();
        byte[] byteArray = new byte[len];
        try (InputStream inputStream = new FileInputStream(file)) {
            inputStream.read(byteArray);
            for (byte b : byteArray) {
                System.out.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }


    public static List<String> readLineByLine(String path){

        List<String> linesList = new ArrayList<>();
        String line=null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){

            while((line = bufferedReader.readLine())!=null){
                linesList.add(line);

            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return linesList;
    }

    public static String readATextFile(String path) throws IOException {
        return new String(Files.readAllBytes((Paths.get(path))));
    }

    public static String[] readAFileIntoArray(String path) {
        String[] lines=null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            lines = bufferedReader.lines()
                    .toArray(String[]::new);
        } catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }


}
