package com.alex.dam.Utils;

import org.json.JSONException;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.*;
import java.util.*;

import org.json.*;
import org.json.simple.parser.ParseException;


public class JsonParser {

    //public String fisier="D:\\GitRepo\\cplusplus\\dam1\\src\\main\\java\\com\\alex\\dam\\adrese.json";

    public static JSONArray readJson(String fisier) throws Exception {
        //citire fisier

        String line;
        int i=0;
        FileReader fileReader = new FileReader(fisier);
        JSONParser jsonParser = new JSONParser();
        return (JSONArray) jsonParser.parse(fileReader);

        // BufferedReader bufferedReader = new BufferedReader(fileReader);

//        while((line = bufferedReader.readLine())!=null){
//            JSONObject obj = (JSONObject)new JSONParser().parse(line);
//            System.out.println(i++);
//            json.add(obj);
//        }
//
//        bufferedReader.close();

       // return json;
    }


}

