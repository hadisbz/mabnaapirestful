package ir.dotin.bigdata.project.mabnaapirestful.service.contracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.contracts.ContractTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.ContractTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class ContractTypesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ContractTypesRepository repository;

    public ContractTypesService(MabnaConf mabnaConf, ContractTypesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ContractTypesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/option/contracttypes", filter, HttpMethod.GET, ContractTypesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ContractTypesModel model = ContractTypesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
