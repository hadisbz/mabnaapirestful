package ir.dotin.bigdata.project.mabnaapirestful.service.contracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractHistoryResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.contracts.ContractHistoryMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractHistoryModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.ContractHistoryRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ContractHistoryService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ContractHistoryRepository repository;

    public ContractHistoryService(MabnaConf mabnaConf, ContractHistoryRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ContractHistoryResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/option/contracthistory", filter, HttpMethod.GET, ContractHistoryResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ContractHistoryModel model = ContractHistoryMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
