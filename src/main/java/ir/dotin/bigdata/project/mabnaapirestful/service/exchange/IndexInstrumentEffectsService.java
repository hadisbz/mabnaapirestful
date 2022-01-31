package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexInstrumentEffectsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.IndexInstrumentEffectsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexInstrumentEffectsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.IndexInstrumentEffectsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IndexInstrumentEffectsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final IndexInstrumentEffectsRepository repository;

    public IndexInstrumentEffectsService(MabnaConf mabnaConf, IndexInstrumentEffectsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<IndexInstrumentEffectsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/indexinstrumenteffects", filter, HttpMethod.GET, IndexInstrumentEffectsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        IndexInstrumentEffectsModel model = IndexInstrumentEffectsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
