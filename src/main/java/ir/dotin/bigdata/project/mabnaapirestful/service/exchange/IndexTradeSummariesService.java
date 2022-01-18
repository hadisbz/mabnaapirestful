package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexTradeSummariesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.IndexTradeSummariesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexTradeSummariesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.IndexTradeSummariesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IndexTradeSummariesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final IndexTradeSummariesRepository repository;

    public IndexTradeSummariesService(MabnaConf mabnaConf, IndexTradeSummariesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<IndexTradeSummariesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/indextradesummaries", filter, HttpMethod.GET, IndexTradeSummariesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        IndexTradeSummariesModel model = IndexTradeSummariesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}

