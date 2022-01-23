package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.PersonsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.PersonsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PersonsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.PersonsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final PersonsRepository repository;

    public PersonsService(MabnaConf mabnaConf, PersonsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<PersonsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/persons", filter, HttpMethod.GET, PersonsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        PersonsModel model = PersonsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}