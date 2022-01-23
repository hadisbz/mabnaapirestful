package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.InstrumentExchangeStatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.InstrumentExchangeStatesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentExchangeStatesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.InstrumentExchangeStatesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class InstrumentExchangeStatesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final InstrumentExchangeStatesRepository repository;

    public InstrumentExchangeStatesService(MabnaConf mabnaConf, InstrumentExchangeStatesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<InstrumentExchangeStatesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/instrumentexchangestates", filter, HttpMethod.GET, InstrumentExchangeStatesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        InstrumentExchangeStatesModel model = InstrumentExchangeStatesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
