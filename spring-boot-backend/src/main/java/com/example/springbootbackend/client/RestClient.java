package com.example.springbootbackend.client;

import com.example.springbootbackend.entity.ResponseClass;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    private RestTemplate rest = new RestTemplate();;
    private HttpHeaders headers = new HttpHeaders();
    private HttpStatus status;
    @Value("${app.odata.username}")
    private String odataUsername;
    @Value("${app.odata.password}")
    private String odataPassword;

    public RestClient() {
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json, text/plain, */*");
    }

    public ResponseEntity<ResponseClass> get(String uri) {
        setBasicAuthorization();
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        try {
            return rest.exchange(uri, HttpMethod.GET, requestEntity, ResponseClass.class);
        } catch(HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(new ResponseClass());
        }
    }

    public void setBasicAuthorization() {
        byte[] plainCredsBytes = new StringBuilder(odataUsername + ':' + odataPassword).toString().getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        this.headers.set("Authorization", "Basic" + " " + base64Creds);
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
