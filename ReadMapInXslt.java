package com.example.demo;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.util.HashMap;
import java.util.Map;

public class ReadMapInXslt {
    public static void main(String[] args) {
        try{
            String inputXSL = "./src/main/java/com/example/demo/test.xsl";
            TransformerFactory factory = TransformerFactory.newInstance();
            StreamSource xslStream = new StreamSource(inputXSL);
            Transformer transformer = factory.newTransformer(xslStream);
            Map<String, String> mapData = new HashMap<>();
            mapData.put("103", "188 E 6th Street");
            transformer.setParameter("mapData", mapData);
            System.out.println(transformer.getParameter("mapData"));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}

