package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompaniesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.CompaniesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompaniesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.stock.CompaniesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CompaniesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CompaniesRepository repository;

    public CompaniesService(MabnaConf mabnaConf, CompaniesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CompaniesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/companies", filter, HttpMethod.GET, CompaniesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CompaniesModel model = CompaniesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}



