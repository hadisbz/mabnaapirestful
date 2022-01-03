package ir.dotin.bigdata.project.mabnaapirestful.service.bonds;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds.BondInterestPaymentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BondInterestPaymentsService implements GenericService {
    private final MabnaConf mabnaConf;

    public BondInterestPaymentsService(MabnaConf mabnaConf) {
        this.mabnaConf = mabnaConf;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BondInterestPaymentsResponse> occasionTypesResponse =
                mabnaConf.getResponse("/bond/interestpayments",null, HttpMethod.GET, BondInterestPaymentsResponse.class);
    }
}
