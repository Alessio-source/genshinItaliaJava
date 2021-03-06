package com.genshinItalia.api;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class newsApi {

    @RequestMapping("/api/v1/news")
    public String getNews(@RequestParam String key) throws IOException {

        List<String> keys = Arrays.asList("bdGW7phynRHVbXpF3319QIQPKtCoJ72nObLribDqcpUUgFxR5w1mc7BbSlkjnQtclE4PSNzMJS00KaclhuPJXNNfcn3MXBUycPtuNPTlhMZAiw3H9ufQLlUw9pDM6TD9bBITsh3TeJQETkHeHH5r4x", "g3nsh1nIt4l14_2022!");

        if(keys.stream().filter(k -> k.equals(key)).findAny().orElse(null) == null) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", "403");
            error.put("Message", "Permission Denied");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(error);
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
