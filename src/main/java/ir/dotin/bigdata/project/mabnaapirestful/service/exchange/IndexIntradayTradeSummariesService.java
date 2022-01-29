package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.IndexIntradayTradeSummariesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.IndexIntradayTradeSummariesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexIntradayTradeSummariesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.IndexIntradayTradeSummariesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IndexIntradayTradeSummariesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final IndexIntradayTradeSummariesRepository repository;

    public IndexIntradayTradeSummariesService(MabnaConf mabnaConf, IndexIntradayTradeSummariesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<IndexIntradayTradeSummariesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/indexintradaytradesummaries", filter, HttpMethod.GET, IndexIntradayTradeSummariesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        IndexIntradayTradeSummariesModel model = IndexIntradayTradeSummariesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}

