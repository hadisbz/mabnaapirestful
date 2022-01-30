package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ExchangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange.ExchangesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ExchangesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.ExchangesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ExchangesService implements GenericService{
    private final MabnaConf mabnaConf;
    private final ExchangesRepository repository;

    public ExchangesService(MabnaConf mabnaConf, ExchangesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ExchangesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/exchanges", filter, HttpMethod.GET, ExchangesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ExchangesModel model = ExchangesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
