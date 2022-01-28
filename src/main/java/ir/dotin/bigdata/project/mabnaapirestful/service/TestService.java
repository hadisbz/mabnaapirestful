package ir.dotin.bigdata.project.mabnaapirestful.service;


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
        ResponseEntity<String> response = mabnaConf.getResponse("/stock/balancesheets?_count=1&_expand=announcement_type,financial_view_type.meta", null, HttpMethod.GET, String.class);
        System.out.println(response.getBody());
    }
}
