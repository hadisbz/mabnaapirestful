package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.BalancesheetsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.BalancesheetsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.BalancesheetsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BalancesheetsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BalancesheetsRepository repository;

    public BalancesheetsService(MabnaConf mabnaConf, BalancesheetsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BalancesheetsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/balancesheets?_expand=announcement_type,financial_view_type", filter, HttpMethod.GET, BalancesheetsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BalancesheetsModel model = BalancesheetsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
