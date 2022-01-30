package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.EpsesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.EpsesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.EpsesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.EpsesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EpsesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final EpsesRepository repository;

    public EpsesService(MabnaConf mabnaConf, EpsesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<EpsesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/epses", filter, HttpMethod.GET, EpsesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        EpsesModel model = EpsesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
