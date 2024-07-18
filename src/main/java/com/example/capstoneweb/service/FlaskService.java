package com.example.capstoneweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;


@Service
public class FlaskService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String FLASK_SERVER_URL = "http://localhost:5000";

    public String generateReport(String userMsg){
        String url = FLASK_SERVER_URL + "/generate-report";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("user_msg", userMsg);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);
        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody(); //이 메서드를 사용하여 플라스크 서버에 post요청을 보내고, 응답 본문을 String으로 받아 반환한다.
    }
    public byte[] downloadReport() {
        String url = FLASK_SERVER_URL + "/download-report";
        return restTemplate.getForObject(url, byte[].class);
    }


    }



