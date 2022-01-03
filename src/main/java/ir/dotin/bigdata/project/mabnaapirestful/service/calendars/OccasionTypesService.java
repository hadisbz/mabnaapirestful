package ir.dotin.bigdata.project.mabnaapirestful.service.calendars;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.CalendarsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.calendars.OccasionTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.CalendarsModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.OccasionTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.calendars.OccasionTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OccasionTypesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final OccasionTypesRepository occasionTypesRepository;

    public OccasionTypesService(MabnaConf mabnaConf, OccasionTypesRepository occasionTypesRepository) {
        this.mabnaConf = mabnaConf;
        this.occasionTypesRepository = occasionTypesRepository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<OccasionTypesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/calendar/occasiontypes",filter, HttpMethod.GET, OccasionTypesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(occasionTypesInner -> {
                        OccasionTypesModel occasionTypesModel = OccasionTypesMapper.map(occasionTypesInner);
                        occasionTypesRepository.save(occasionTypesModel);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
