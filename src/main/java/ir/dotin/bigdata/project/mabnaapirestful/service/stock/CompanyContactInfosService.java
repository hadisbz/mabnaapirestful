package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompanyContactInfosResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.CompanyContactInfosMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompanyContactInfosModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.stock.CompanyContactInfosRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CompanyContactInfosService implements GenericService {
    private final MabnaConf mabnaConf;
    private final CompanyContactInfosRepository repository;

    public CompanyContactInfosService(MabnaConf mabnaConf, CompanyContactInfosRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<CompanyContactInfosResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/companycontactinfos", filter, HttpMethod.GET, CompanyContactInfosResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        CompanyContactInfosModel model = CompanyContactInfosMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


