package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.SourcesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.calendars.OccasionTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.SourcesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.OccasionTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.SourcesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.calendars.SourcesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SourcesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final SourcesRepository repository;

    public SourcesService(MabnaConf mabnaConf, SourcesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<SourcesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/sources",filter, HttpMethod.GET, SourcesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        SourcesModel model = SourcesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
