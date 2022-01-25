package ir.dotin.bigdata.project.mabnaapirestful.service.fund;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.fund.DividendPaymentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.fund.DividendPaymentsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.DividendPaymentsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.fund.DividendPaymentsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DividendPaymentsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final DividendPaymentsRepository repository;

    public DividendPaymentsService(MabnaConf mabnaConf, DividendPaymentsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<DividendPaymentsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/fund/dividendpayments", filter, HttpMethod.GET, DividendPaymentsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        DividendPaymentsModel model = DividendPaymentsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


