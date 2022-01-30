package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.MeetingTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock.MeetingTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.MeetingTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.MeetingTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MeetingTypesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final MeetingTypesRepository repository;

    public MeetingTypesService(MabnaConf mabnaConf, MeetingTypesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<MeetingTypesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/meetingtypes", filter, HttpMethod.GET, MeetingTypesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        MeetingTypesModel model = MeetingTypesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
