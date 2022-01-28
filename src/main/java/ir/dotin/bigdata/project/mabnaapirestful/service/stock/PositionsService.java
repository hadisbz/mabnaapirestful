package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.PositionsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.PositionsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.PositionsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.PositionsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PositionsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final PositionsRepository repository;

    public PositionsService(MabnaConf mabnaConf, PositionsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<PositionsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/positions", filter, HttpMethod.GET, PositionsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        PositionsModel model = PositionsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
