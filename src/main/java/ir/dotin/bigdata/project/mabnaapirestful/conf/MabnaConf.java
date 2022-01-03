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
    @Value("${mabna-uri}")
    private String uri;

    @Value("${mabna-auth}")
    private String auth;

    private final RestTemplate restTemplate = new RestTemplate();

    public<T> ResponseEntity<T> getResponse(String path, String filter, HttpMethod httpMethod, Class<T> clazz) {
        StringBuilder finalURI = new StringBuilder(uri.concat(path));

        if(filter != null && !filter.isEmpty())
            finalURI.append("?").append(filter);

        return restTemplate.exchange(
                finalURI.toString(),
                httpMethod,
                new HttpEntity<>(new HttpHeaders() {{
                    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
                    String authHeader = "Basic " + new String(encodedAuth);
                    set("Authorization", authHeader);
                }}),
                clazz
        );
    }
}
