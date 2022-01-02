package ir.dotin.bigdata.project.mabnaapirestful.service.bonds;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.Root;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds.BondInterestPaymentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BondInterestPaymentsService implements GenericService<BondInterestPaymentsResponse> {
    private final MabnaConf mabnaConf;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public BondInterestPaymentsService(MabnaConf mabnaConf, ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.mabnaConf = mabnaConf;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public Root<BondInterestPaymentsResponse> response() throws JsonProcessingException {
        ResponseEntity<String> response = mabnaConf.getResponse("/bond/interestpayments", HttpMethod.GET);
        return objectMapper.readValue(response.getBody(), Root.class);
    }
}
