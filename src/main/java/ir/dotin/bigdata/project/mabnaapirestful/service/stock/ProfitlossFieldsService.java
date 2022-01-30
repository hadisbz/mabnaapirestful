package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProfitlossFieldsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.ProfitlossFieldsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProfitlossFieldsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.stock.ProfitlossFieldsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProfitlossFieldsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ProfitlossFieldsRepository repository;

    public ProfitlossFieldsService(MabnaConf mabnaConf, ProfitlossFieldsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ProfitlossFieldsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/profitlossfields", filter, HttpMethod.GET, ProfitlossFieldsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ProfitlossFieldsModel model = ProfitlossFieldsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


