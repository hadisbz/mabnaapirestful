package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentGroupsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange.InstrumentGroupsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentGroupsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.InstrumentGroupsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InstrumentGroupService implements GenericService {
    private final MabnaConf mabnaConf;
    private final InstrumentGroupsRepository repository;

    public InstrumentGroupService(MabnaConf mabnaConf, InstrumentGroupsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<InstrumentGroupsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/instrumentgroups", filter, HttpMethod.GET, InstrumentGroupsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        InstrumentGroupsModel model = InstrumentGroupsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
