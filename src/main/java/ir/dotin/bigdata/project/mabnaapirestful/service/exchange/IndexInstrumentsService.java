package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexInstrumentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.IndexInstrumentsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexInstrumentsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.IndexInstrumentsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IndexInstrumentsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final IndexInstrumentsRepository repository;

    public IndexInstrumentsService(MabnaConf mabnaConf, IndexInstrumentsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<IndexInstrumentsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/indexinstruments", filter, HttpMethod.GET, IndexInstrumentsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        IndexInstrumentsModel model = IndexInstrumentsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
