package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.UnitsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock.UnitsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.UnitsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.UnitsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UnitsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final UnitsRepository repository;

    public UnitsService(MabnaConf mabnaConf, UnitsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<UnitsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/units", filter, HttpMethod.GET, UnitsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        UnitsModel model = UnitsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
