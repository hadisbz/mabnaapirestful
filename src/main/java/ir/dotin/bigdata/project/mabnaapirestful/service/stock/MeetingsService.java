package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.MeetingsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.MeetingsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.MeetingsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.stock.MeetingsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class MeetingsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final MeetingsRepository repository;

    public MeetingsService(MabnaConf mabnaConf, MeetingsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<MeetingsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/meetings", filter, HttpMethod.GET, MeetingsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        MeetingsModel model = MeetingsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
