package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentageActionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.PercentageActionTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageActionTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.PercentageActionTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PercentageActionTypesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final PercentageActionTypesRepository repository;

    public PercentageActionTypesService(MabnaConf mabnaConf, PercentageActionTypesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<PercentageActionTypesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/percentageactiontypes", filter, HttpMethod.GET, PercentageActionTypesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        PercentageActionTypesModel model = PercentageActionTypesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
