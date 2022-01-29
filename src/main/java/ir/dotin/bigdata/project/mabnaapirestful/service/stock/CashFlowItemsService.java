package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.CashFlowItemsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.CashFlowItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CashFlowItemsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.CashFlowItemsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CashFlowItemsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CashFlowItemsRepository repository;

    public CashFlowItemsService(MabnaConf mabnaConf, CashFlowItemsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CashFlowItemsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/cashflowitems", filter, HttpMethod.GET, CashFlowItemsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CashFlowItemsModel model = CashFlowItemsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
