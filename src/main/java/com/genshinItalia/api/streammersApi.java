package com.genshinItalia.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genshinItalia.entity.Streammer;
import com.genshinItalia.services.StreammersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class streammersApi {
    @Autowired
    private StreammersService streammersServices;

    @RequestMapping("api/v1/streammers")
    public String streammers(@RequestParam String key) throws JsonProcessingException {
        List<String> keys = Arrays.asList("bdGW7phynRHVbXpF3319QIQPKtCoJ72nObLribDqcpUUgFxR5w1mc7BbSlkjnQtclE4PSNzMJS00KaclhuPJXNNfcn3MXBUycPtuNPTlhMZAiw3H9ufQLlUw9pDM6TD9bBITsh3TeJQETkHeHH5r4x", "g3nsh1nIt4l14_2022!");

        if(keys.stream().filter(k -> k.equals(key)).findAny().orElse(null) == null) {
            Map<String, String> error = new HashMap<>();
            error.put("Error", "403");
            error.put("Message", "Permission Denied");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(error);
        } else {
            List<Streammer> streammers = streammersServices.getAllStreamers();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(streammers);
        }
    }
}
