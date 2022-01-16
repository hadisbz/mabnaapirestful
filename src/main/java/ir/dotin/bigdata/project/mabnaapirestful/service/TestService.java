package ir.dotin.bigdata.project.mabnaapirestful.service;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.NewsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final MabnaConf mabnaConf;

    public TestService(MabnaConf mabnaConf) {
        this.mabnaConf = mabnaConf;
    }

    public void test(){
        ResponseEntity<String> response = mabnaConf.getResponse("/exchange/news", null, HttpMethod.GET, String.class);
        System.out.println(response.getBody());
    }
}
