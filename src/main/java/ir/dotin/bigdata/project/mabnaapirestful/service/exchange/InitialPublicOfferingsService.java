package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InitialPublicOfferingsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange.InitialPublicOfferingsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InitialPublicOfferingsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.InitialPublicOfferingsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InitialPublicOfferingsService implements GenericService{
    private final MabnaConf mabnaConf;
    private final InitialPublicOfferingsRepository repository;

    public InitialPublicOfferingsService(MabnaConf mabnaConf, InitialPublicOfferingsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<InitialPublicOfferingsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/initialpublicofferings", filter, HttpMethod.GET, InitialPublicOfferingsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        InitialPublicOfferingsModel model = InitialPublicOfferingsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
