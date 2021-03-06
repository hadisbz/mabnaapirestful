package ir.dotin.bigdata.project.mabnaapirestful.service.contracts;
import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractStylesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.contracts.ContractStylesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractStylesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.ContractStylesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ContractStylesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ContractStylesRepository repository;

    public ContractStylesService(MabnaConf mabnaConf, ContractStylesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ContractStylesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/option/contractstyles", filter, HttpMethod.GET, ContractStylesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ContractStylesModel model = ContractStylesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
