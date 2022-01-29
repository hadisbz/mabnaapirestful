package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.PercentageValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.PercentageValuesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageValuesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.PercentageValuesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PercentageValuesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final PercentageValuesRepository repository;

    public PercentageValuesService(MabnaConf mabnaConf, PercentageValuesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<PercentageValuesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/percentagevalues", filter, HttpMethod.GET, PercentageValuesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        PercentageValuesModel model = PercentageValuesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
