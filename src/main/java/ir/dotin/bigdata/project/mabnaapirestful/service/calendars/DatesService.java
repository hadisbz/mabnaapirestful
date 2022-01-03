package ir.dotin.bigdata.project.mabnaapirestful.service.calendars;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.DatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.calendars.DatesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.DatesModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.OccasionTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.calendars.DatesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DatesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final DatesRepository datesRepository;

    public DatesService(MabnaConf mabnaConf, DatesRepository datesRepository) {
        this.mabnaConf = mabnaConf;
        this.datesRepository = datesRepository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<DatesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/calendar/dates", filter, HttpMethod.GET, DatesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(datesResponseInner -> {
                        DatesModel datesModel = DatesMapper.map(datesResponseInner);
                        datesRepository.save(datesModel);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
