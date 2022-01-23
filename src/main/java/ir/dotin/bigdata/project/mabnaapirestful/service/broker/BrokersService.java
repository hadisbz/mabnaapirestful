package ir.dotin.bigdata.project.mabnaapirestful.service.broker;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.broker.BrokersResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.broker.BrokersMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.BrokersModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.broker.BrokersRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BrokersService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BrokersRepository repository;

    public BrokersService(MabnaConf mabnaConf, BrokersRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BrokersResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/broker/brokers", filter, HttpMethod.GET, BrokersResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BrokersModel model = BrokersMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


