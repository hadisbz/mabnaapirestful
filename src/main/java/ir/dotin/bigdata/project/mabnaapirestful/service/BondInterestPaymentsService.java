package ir.dotin.bigdata.project.mabnaapirestful.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.bond.BondInterestPaymentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.Root;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BondInterestPaymentsService implements GenericService<BondInterestPaymentsResponse> {
    private final MabnaConf mabnaConf;
    private final ObjectMapper objectMapper;

    public BondInterestPaymentsService(MabnaConf mabnaConf, ObjectMapper objectMapper) {
        this.mabnaConf = mabnaConf;
        this.objectMapper = objectMapper;
    }

    @Override
    public Root<BondInterestPaymentsResponse> response() throws JsonProcessingException {
        ResponseEntity<String> response = mabnaConf.getResponse("/bond/interestpayments", HttpMethod.GET);
        System.out.println(response.getBody());
        return objectMapper.readValue(response.getBody(), Root.class);
    }
}
