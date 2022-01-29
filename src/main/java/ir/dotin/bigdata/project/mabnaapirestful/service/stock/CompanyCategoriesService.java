package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompanyCategoriesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.CompanyCategoriesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompanyCategoriesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.CompanyCategoriesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class CompanyCategoriesService implements GenericService{
    private final MabnaConf mabnaConf;
    private final CompanyCategoriesRepository repository;

    public CompanyCategoriesService(MabnaConf mabnaConf, CompanyCategoriesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CompanyCategoriesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/companycategories", filter, HttpMethod.GET, CompanyCategoriesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CompanyCategoriesModel model = CompanyCategoriesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
