package com.example.demo;

import org.json.*;

class XmlToJson{
    public static String xml= "<?xml version=\"1.0\" ?><root><test       attribute=\"text1\">javatpoint</test><test attribute=\"text2\">JTP</test></root>";
    public static void main(String[] args) {
        try {
            JSONObject json = XML.toJSONObject(xml);
            String jsonString = json.toString(4);
            System.out.println(jsonString);

        }catch (JSONException e) {
            System.out.println(e.toString());
        }
    }
}