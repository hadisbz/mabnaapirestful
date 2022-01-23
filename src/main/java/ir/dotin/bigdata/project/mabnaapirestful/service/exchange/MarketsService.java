package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.MarketsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.MarketsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.MarketsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.MarketsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MarketsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final MarketsRepository repository;

    public MarketsService(MabnaConf mabnaConf, MarketsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<MarketsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/markets", filter, HttpMethod.GET, MarketsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        MarketsModel model = MarketsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


