package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.PercentagesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.PercentagesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentagesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.PercentagesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PercentagesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final PercentagesRepository repository;

    public PercentagesService(MabnaConf mabnaConf, PercentagesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<PercentagesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/percentages", filter, HttpMethod.GET, PercentagesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        PercentagesModel model = PercentagesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
