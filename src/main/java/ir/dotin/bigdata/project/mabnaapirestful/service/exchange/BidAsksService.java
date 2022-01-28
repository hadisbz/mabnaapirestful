package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.BidAsksResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.BidAsksMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.BidAsksModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.BidAsksRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BidAsksService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BidAsksRepository repository;

    public BidAsksService(MabnaConf mabnaConf, BidAsksRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BidAsksResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/bidasks", filter, HttpMethod.GET, BidAsksResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BidAsksModel model = BidAsksMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
