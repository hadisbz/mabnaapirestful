package ir.dotin.bigdata.project.mabnaapirestful.service.fund;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.fund.RatingsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.fund.RatingsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.RatingsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.fund.RatingsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RatingsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final RatingsRepository repository;

    public RatingsService(MabnaConf mabnaConf, RatingsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<RatingsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/fund/ratings", filter, HttpMethod.GET, RatingsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        RatingsModel model = RatingsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}

