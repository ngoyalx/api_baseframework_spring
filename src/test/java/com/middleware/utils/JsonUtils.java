package com.middleware.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

@Component
public class JsonUtils {

    public String readJSONFileAsString(String fileName){
        JSONParser jsonParser = new JSONParser();
        Object obj;
        JSONObject testJSON = new JSONObject();
        try (FileReader reader = new FileReader(fileName)) {
            obj = jsonParser.parse(reader);
            testJSON = (JSONObject)obj;
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return testJSON.toString();
    }

    public void writeJSONFile(JSONObject jsonObject, String fileName){
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonObject.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName){
        File file = new File(fileName);
        file.delete();
    }
}
