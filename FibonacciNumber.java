package com.demo.xslt;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class FibonacciNumber {
    public static BigInteger calculate(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException(
                    "Fibonacci numbers are only defined for positive integers"
            );
        }
        BigInteger low = BigInteger.ONE;
        BigInteger high = BigInteger.ONE;

        for (int i = 3; i <= n; i++) {
            BigInteger temp = high;
            high = high.add(low);
            low = temp;
        }

        return high;
    }

    public int sum(int a, int b){
        return a +b;
    }

    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslSrc = new StreamSource("src/main/java/com/demo/xslt/CustomXsl.xsl");
        Transformer transformer = factory.newTransformer(xslSrc);
        StreamResult result = new StreamResult("src/main/java/com/demo/xslt/Result.xml");
        HashMap<String, String> mapData = new HashMap<>();
        mapData.put("1","Dinesh");
        mapData.put("2", "Rajiv");
        transformer.setParameter("mapData", mapData);
        transformer.transform(xslSrc, result);
    }

    public static String dateFormat(){
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss'Z'");

        String formatDateTime = dateTime.format(formatter);

        System.out.println("After : " + formatDateTime);

        return formatDateTime;
    }
}
