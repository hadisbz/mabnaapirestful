package ir.dotin.bigdata.project.mabnaapirestful.conf;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class MabnaConf {
    @Value("${mabna-url}")
    private String url;

    @Value("${mabna-auth}")
    private String auth;

    private final RestTemplate restTemplate;

    public MabnaConf(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getResponse(String path, HttpMethod httpMethod) {
        return restTemplate.exchange(
                url.concat(path),
                httpMethod,
                new HttpEntity<>(new HttpHeaders() {{
                    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
                    String authHeader = "Basic " + new String(encodedAuth);
                    set("Authorization", authHeader);
                }}),
                String.class
        );
    }
}
