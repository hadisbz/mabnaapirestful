package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.DividendPayoutsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.DividendPayoutsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.DividendPayoutsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.DividendPayoutsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DividendPayoutsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final DividendPayoutsRepository repository;

    public DividendPayoutsService(MabnaConf mabnaConf, DividendPayoutsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<DividendPayoutsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/dividendpayouts", filter, HttpMethod.GET, DividendPayoutsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        DividendPayoutsModel model = DividendPayoutsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
