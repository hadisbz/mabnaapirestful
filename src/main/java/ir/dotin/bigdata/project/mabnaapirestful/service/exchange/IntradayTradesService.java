package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IntradayTradesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.IntradayTradesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IntradayTradesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.IntradayTradesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IntradayTradesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final IntradayTradesRepository repository;

    public IntradayTradesService(MabnaConf mabnaConf, IntradayTradesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<IntradayTradesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/intradaytrades", filter, HttpMethod.GET, IntradayTradesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        IntradayTradesModel model = IntradayTradesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
