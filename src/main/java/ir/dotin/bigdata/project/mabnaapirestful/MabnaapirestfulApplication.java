package ir.dotin.bigdata.project.mabnaapirestful;

import ir.dotin.bigdata.project.mabnaapirestful.model.StudentModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MabnaapirestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MabnaapirestfulApplication.class, args);
    }


    @Bean
    public StudentModel studentModelBean(){
        return new StudentModel();
    }

}
