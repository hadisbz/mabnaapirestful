package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.IndexValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.IndexValuesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexValuesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.IndexValuesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IndexValuesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final IndexValuesRepository repository;

    public   IndexValuesService(MabnaConf mabnaConf, IndexValuesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<IndexValuesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/IndexValues", filter, HttpMethod.GET,   IndexValuesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        IndexValuesModel model =  IndexValuesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
