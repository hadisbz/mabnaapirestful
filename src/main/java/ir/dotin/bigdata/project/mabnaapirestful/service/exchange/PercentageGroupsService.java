package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentageGroupsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange.PercentageGroupsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageGroupsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.PercentageGroupsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PercentageGroupsService implements GenericService{
    private final MabnaConf mabnaConf;
    private final PercentageGroupsRepository repository;

    public PercentageGroupsService(MabnaConf mabnaConf, PercentageGroupsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<PercentageGroupsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/percentagegroups", filter, HttpMethod.GET, PercentageGroupsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        PercentageGroupsModel model = PercentageGroupsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
