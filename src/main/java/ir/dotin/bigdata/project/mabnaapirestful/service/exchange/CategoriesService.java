package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.CategoriesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange.CategoriesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.CategoriesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.CategoriesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoriesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CategoriesRepository repository;

    public CategoriesService(MabnaConf mabnaConf, CategoriesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CategoriesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/categories", filter, HttpMethod.GET, CategoriesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CategoriesModel model = CategoriesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}



