package com.example.springbootbackend;

import com.example.springbootbackend.entity.ResponseClass;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json, text/plain, */*");
        setBasicAuthorization("GISDEMO", "2kj3h542kj533");
    }

    public ResponseEntity<ResponseClass> get(String uri) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<ResponseClass> responseEntity = rest.exchange(uri, HttpMethod.GET, requestEntity, ResponseClass.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity;
    }

    public void setBasicAuthorization(String username, String password) {
        byte[] plainCredsBytes = new StringBuilder(username + ':' + password).toString().getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        this.headers.set("Authorization", "Basic" + " " + base64Creds);
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
