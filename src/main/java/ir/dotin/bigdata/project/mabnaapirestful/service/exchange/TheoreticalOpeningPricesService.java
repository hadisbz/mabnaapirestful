package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.TheoreticalOpeningPricesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.TheoreticalOpeningPricesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.TheoreticalOpeningPricesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.TheoreticalOpeningPricesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TheoreticalOpeningPricesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final TheoreticalOpeningPricesRepository repository;

    public TheoreticalOpeningPricesService(MabnaConf mabnaConf, TheoreticalOpeningPricesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<TheoreticalOpeningPricesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/theoreticalopeningprices", filter, HttpMethod.GET, TheoreticalOpeningPricesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        TheoreticalOpeningPricesModel model = TheoreticalOpeningPricesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }


}
