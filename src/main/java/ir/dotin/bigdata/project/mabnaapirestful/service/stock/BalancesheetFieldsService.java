package ir.dotin.bigdata.project.mabnaapirestful.service.stock;


import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.stock.BalancesheetFieldsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.BalancesheetFieldsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetFieldsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.BalancesheetFieldsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BalancesheetFieldsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BalancesheetFieldsRepository repository;

    public BalancesheetFieldsService(MabnaConf mabnaConf, BalancesheetFieldsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BalancesheetFieldsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/balancesheetfields", filter, HttpMethod.GET, BalancesheetFieldsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BalancesheetFieldsModel model = BalancesheetFieldsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


