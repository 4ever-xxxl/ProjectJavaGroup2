package com.example.entity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
public class MyFunction {
//    public List<String> getKeys(List<?> data) {
//        List<String> keys = new ArrayList<>();
//        if (data != null && !data.isEmpty()) {
//            Class<?> clazz = data.get(0).getClass();
//            Field[] fields = clazz.getDeclaredFields();
//            for (Field field : fields) {
//                keys.add(field.getName());
//            }
//        }
//        return keys;
//    }




    public Map<String, List<Map<String, Object>>> ReadJSON(String filename) {
        Gson gson = new Gson();
        Type listType = new TypeToken<Map<String, List<Map<String, Object>>>>(){}.getType();
        String BaseURL="src/main/resources/sqlJSON/";
        try (Reader reader = Files.newBufferedReader(Paths.get(BaseURL+filename+".json"))) {
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}

