package com.ed.tenacityxml.rest_template;

import com.ed.tenacityxml.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

@Service
public class UserRestTemplate {

    @Value("${sofia.uri}")
    private String sofiaUri;

    private final RestTemplate restTemplate;

    public UserRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDTO getCurrentUser(Map<String, String> headers) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Authorization", headers.get("authorization"));
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<UserDTO> response = restTemplate.exchange(this.sofiaUri + "/user/current",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<UserDTO>() {}
        );

        return response.getBody();

//        return null;
    }

}
