package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.InstrumentStatesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentStatesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.InstrumentStatesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InstrumentStatesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final InstrumentStatesRepository repository;

    public InstrumentStatesService(MabnaConf mabnaConf, InstrumentStatesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<InstrumentStatesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/instrumentstates", filter, HttpMethod.GET, InstrumentStatesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        InstrumentStatesModel model = InstrumentStatesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
