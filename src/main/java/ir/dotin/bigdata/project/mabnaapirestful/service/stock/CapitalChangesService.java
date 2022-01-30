package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CapitalChangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CapitalChangesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock.CapitalChangesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.CapitalChangesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class CapitalChangesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CapitalChangesRepository repository;

    public CapitalChangesService(MabnaConf mabnaConf, CapitalChangesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CapitalChangesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/capitalchanges", filter, HttpMethod.GET, CapitalChangesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CapitalChangesModel model = CapitalChangesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
