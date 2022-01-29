package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.CashFlowsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.CashFlowsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CashFlowsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.CashFlowsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CashFlowsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CashFlowsRepository repository;

    public CashFlowsService(MabnaConf mabnaConf, CashFlowsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CashFlowsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/cashflows?_expand=announcement_type,financial_view_type", filter, HttpMethod.GET, CashFlowsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CashFlowsModel model = CashFlowsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
