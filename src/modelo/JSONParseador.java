/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Macias
 */
public class JSONParseador {

    private final JSONParser parser;
    private JSONArray parserArray;

    public JSONParseador() {
        parser = new JSONParser();
    }

    public ArrayList<String> parsearJSONArray(String json) throws ParseException {
        Object par = parser.parse(json);

        JSONArray msg = (JSONArray) par;
        JSONObject jsonObject;
        ArrayList<String> arrayList = new ArrayList<>();
        for (Object object : msg) {
            jsonObject = (JSONObject) object;
            arrayList.add((String) jsonObject.get("palabra"));
        } 
        return arrayList;
    }
    
    public String[] parsearJSONDiccionario(String json) throws ParseException {
        Object object = parser.parse(json);
        JSONObject jsonObject = (JSONObject) object;
        
        String[] arreglo = new String[2];
        arreglo[0] = (String)jsonObject.get("lema");
        arreglo[1] = (String)jsonObject.get("definicion");
        
        return arreglo;
    }

}
