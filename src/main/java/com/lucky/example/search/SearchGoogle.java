package com.lucky.example.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SearchGoogle {
    @Autowired
    @Qualifier("googleSearchRestTemplate")
    RestTemplate restTemplate;

    private static final String SEARCH_URL = "https://www.google.com/search=";
    public void search(String searchQuery){
        ResponseEntity<String> response = restTemplate.getForEntity(SEARCH_URL +searchQuery,String.class);
        log.info(response+"");
    }
}
