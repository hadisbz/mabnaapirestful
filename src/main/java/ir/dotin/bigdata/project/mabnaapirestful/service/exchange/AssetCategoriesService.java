package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetCategoriesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange.AssetCategoriesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetCategoriesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.AssetCategoriesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AssetCategoriesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final AssetCategoriesRepository repository;

    public AssetCategoriesService(MabnaConf mabnaConf, AssetCategoriesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<AssetCategoriesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/assetcategories", filter, HttpMethod.GET, AssetCategoriesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        AssetCategoriesModel model = AssetCategoriesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }

}
