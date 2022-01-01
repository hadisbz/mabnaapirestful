package ir.dotin.bigdata.project.mabnaapirestful.service.calendars;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.Root;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calenders.CalendarsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalendarsService implements GenericService<CalendarsResponse> {
    private final MabnaConf mabnaConf;
    private final ObjectMapper objectMapper;

    public CalendarsService(MabnaConf mabnaConf, ObjectMapper objectMapper) {
        this.mabnaConf = mabnaConf;
        this.objectMapper = objectMapper;
    }


    @Override
    public Root<CalendarsResponse> response() throws JsonProcessingException {
        ResponseEntity<String> response = mabnaConf.getResponse("/calendar/calendars", HttpMethod.GET);

        return objectMapper.readValue(response.getBody(), Root.class);
    }
}
