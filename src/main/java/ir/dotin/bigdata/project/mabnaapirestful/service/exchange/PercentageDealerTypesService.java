package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentageDealerTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.PercentageDealerTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageDealerTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.PercentageDealerTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PercentageDealerTypesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final PercentageDealerTypesRepository repository;

    public PercentageDealerTypesService(MabnaConf mabnaConf, PercentageDealerTypesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<PercentageDealerTypesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/percentagedealertypes", filter, HttpMethod.GET, PercentageDealerTypesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        PercentageDealerTypesModel model = PercentageDealerTypesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
