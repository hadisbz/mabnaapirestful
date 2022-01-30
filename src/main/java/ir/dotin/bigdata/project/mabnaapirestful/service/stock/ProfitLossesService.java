package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProfitLossesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock.ProfitLossesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProfitLossesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.ProfitLossesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProfitLossesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ProfitLossesRepository repository;

    public ProfitLossesService(MabnaConf mabnaConf, ProfitLossesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ProfitLossesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/profitlosses?_expand=announcement_type,financial_view_type&_count=1", filter, HttpMethod.GET, ProfitLossesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ProfitLossesModel model = ProfitLossesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
