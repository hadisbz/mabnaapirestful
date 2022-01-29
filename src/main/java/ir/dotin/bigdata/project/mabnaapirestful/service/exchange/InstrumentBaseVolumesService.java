package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.InstrumentBaseVolumesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.InstrumentBaseVolumesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InstrumentBaseVolumesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.InstrumentBaseVolumesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InstrumentBaseVolumesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final InstrumentBaseVolumesRepository repository;

    public InstrumentBaseVolumesService(MabnaConf mabnaConf, InstrumentBaseVolumesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<InstrumentBaseVolumesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/instrumentbasevolumes", filter, HttpMethod.GET, InstrumentBaseVolumesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        InstrumentBaseVolumesModel model = InstrumentBaseVolumesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
