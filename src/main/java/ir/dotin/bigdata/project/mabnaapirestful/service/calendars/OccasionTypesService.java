package ir.dotin.bigdata.project.mabnaapirestful.service.calendars;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.Root;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calenders.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.model.OccasionTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.calendar.OccasionTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OccasionTypesService implements GenericService<OccasionTypesResponse> {
    private final MabnaConf mabnaConf;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final OccasionTypesRepository occasionTypesRepository;

    public OccasionTypesService(MabnaConf mabnaConf, ObjectMapper objectMapper, ModelMapper modelMapper, OccasionTypesRepository occasionTypesRepository) {
        this.mabnaConf = mabnaConf;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.occasionTypesRepository = occasionTypesRepository;
    }


    @Override
    public Root<OccasionTypesResponse> response() throws JsonProcessingException {
        ResponseEntity<String> response = mabnaConf.getResponse("/calendar/occasiontypes", HttpMethod.GET);
        Root root = objectMapper.readValue(response.getBody(), Root.class);


        root
                .getData()
                .forEach(occasionTypesResponse -> {
                            OccasionTypesModel occasionTypesModel = modelMapper.map(occasionTypesResponse, OccasionTypesModel.class);
                            occasionTypesRepository.save(occasionTypesModel);
                        }
                );

        return root;
    }
}
