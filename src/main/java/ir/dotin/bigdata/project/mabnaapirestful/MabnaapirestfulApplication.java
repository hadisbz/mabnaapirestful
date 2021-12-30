package ir.dotin.bigdata.project.mabnaapirestful;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MabnaapirestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MabnaapirestfulApplication.class, args);
    }


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
