package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexIntradayValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.IndexIntradayValuesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexIntradayValuesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.IndexIntradayValuesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IndexIntradayValuesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final IndexIntradayValuesRepository repository;

    public   IndexIntradayValuesService(MabnaConf mabnaConf, IndexIntradayValuesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<IndexIntradayValuesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/indexintradayvalues", filter, HttpMethod.GET,   IndexIntradayValuesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        IndexIntradayValuesModel model =  IndexIntradayValuesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}

