package ir.dotin.bigdata.project.mabnaapirestful.service.calendars;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.CalendarsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.calendars.CalendarsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.CalendarsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.calendars.CalendarsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CalendarsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CalendarsRepository repository;

    public CalendarsService(MabnaConf mabnaConf, CalendarsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CalendarsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/calendar/calendars", filter, HttpMethod.GET, CalendarsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CalendarsModel model = CalendarsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
