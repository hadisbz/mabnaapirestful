package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.MarketMessagesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.MarketMessagesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.MarketMessagesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.MarketMessagesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MarketMessagesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final MarketMessagesRepository repository;

    public MarketMessagesService(MabnaConf mabnaConf, MarketMessagesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<MarketMessagesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/marketmessages", filter, HttpMethod.GET, MarketMessagesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        MarketMessagesModel model = MarketMessagesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
