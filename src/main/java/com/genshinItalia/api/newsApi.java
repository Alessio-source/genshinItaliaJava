package com.genshinItalia.api;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

@RestController
public class newsApi {

    @RequestMapping("/api/v1/news")
    public String getNews(@RequestParam String key) throws IOException {

        List<String> keys = Arrays.asList("bdGW7phynRHVbXpF3319QIQPKtCoJ72nObLribDqcpUUgFxR5w1mc7BbSlkjnQtclE4PSNzMJS00KaclhuPJXNNfcn3MXBUycPtuNPTlhMZAiw3H9ufQLlUw9pDM6TD9bBITsh3TeJQETkHeHH5r4x", "g3nsh1nIt4l14_2022!");

        if(keys.stream().filter(k -> k.equals(key)).findAny().orElse(null) == null) {
            return "{'Error': '403', 'Message': 'Permission Denied'}";
        } else {
            String jsonToReturn = "";
            URL news = new URL("https://news.google.com/rss/search?q=genshinimpact&hl=it&gl=IT&ceid=IT:it");
            URLConnection yc = news.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONObject json = XML.toJSONObject(inputLine);
                jsonToReturn += json.toString(4);
            }
            in.close();
            return jsonToReturn;
        }
    }
}
