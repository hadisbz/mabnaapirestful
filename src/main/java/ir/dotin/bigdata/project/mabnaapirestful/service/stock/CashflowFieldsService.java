package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CashflowFieldsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.CashflowFieldsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CashflowFieldsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.CashflowFieldsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CashflowFieldsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CashflowFieldsRepository repository;

    public CashflowFieldsService(MabnaConf mabnaConf, CashflowFieldsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CashflowFieldsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/cashflowfields", filter, HttpMethod.GET, CashflowFieldsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CashflowFieldsModel model = CashflowFieldsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


