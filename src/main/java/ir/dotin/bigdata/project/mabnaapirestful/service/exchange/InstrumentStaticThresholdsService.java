package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentStaticThresholdsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.InstrumentStaticThresholdsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentStaticThresholdsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.InstrumentStaticThresholdsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InstrumentStaticThresholdsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final InstrumentStaticThresholdsRepository repository;

    public InstrumentStaticThresholdsService(MabnaConf mabnaConf, InstrumentStaticThresholdsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<InstrumentStaticThresholdsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/instrumentstaticthresholds", filter, HttpMethod.GET, InstrumentStaticThresholdsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        InstrumentStaticThresholdsModel model = InstrumentStaticThresholdsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}