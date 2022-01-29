package ir.dotin.bigdata.project.mabnaapirestful.service.contracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.contracts.ContractsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.contracts.ContractsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.ContractsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ContractsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ContractsRepository repository;

    public ContractsService(MabnaConf mabnaConf, ContractsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ContractsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/option/contracts", filter, HttpMethod.GET, ContractsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ContractsModel model = ContractsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}




