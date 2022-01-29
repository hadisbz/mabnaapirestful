package ir.dotin.bigdata.project.mabnaapirestful.service;


import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportImagesFileModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.ReportImagesFileRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

@Service
public class TestService {
    private final MabnaConf mabnaConf;

    public TestService(MabnaConf mabnaConf) {
        this.mabnaConf = mabnaConf;
    }

    public void test() throws IOException {
        ResponseEntity<String> response = mabnaConf.getResponse("/stock/balancesheets?_expand=announcement_type,financial_view_type&_count=1", null, HttpMethod.GET, String.class);
        System.out.println(response.getBody());
    }
}
