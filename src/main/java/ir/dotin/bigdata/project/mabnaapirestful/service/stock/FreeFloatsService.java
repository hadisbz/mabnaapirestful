package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.FreeFloatsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.FreeFloatsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.FreeFloatsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.FreeFloatsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FreeFloatsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final FreeFloatsRepository repository;

    public FreeFloatsService(MabnaConf mabnaConf, FreeFloatsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<FreeFloatsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/FreeFloats", filter, HttpMethod.GET, FreeFloatsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        FreeFloatsModel model = FreeFloatsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
