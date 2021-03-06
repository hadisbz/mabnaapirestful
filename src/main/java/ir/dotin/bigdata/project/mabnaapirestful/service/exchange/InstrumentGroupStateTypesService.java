package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentGroupStateTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.InstrumentGroupStateTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentGroupStateTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.InstrumentGroupStateTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InstrumentGroupStateTypesService implements GenericService{
    private final MabnaConf mabnaConf;
    private final InstrumentGroupStateTypesRepository repository;

    public InstrumentGroupStateTypesService(MabnaConf mabnaConf, InstrumentGroupStateTypesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<InstrumentGroupStateTypesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/instrumentgroupstatetypes", filter, HttpMethod.GET, InstrumentGroupStateTypesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        InstrumentGroupStateTypesModel model = InstrumentGroupStateTypesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
