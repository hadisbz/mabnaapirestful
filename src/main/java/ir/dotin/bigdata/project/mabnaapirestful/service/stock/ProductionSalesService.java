package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProductionSalesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.ProductionSalesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProductionSalesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.ProductionSalesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class ProductionSalesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ProductionSalesRepository repository;

    public ProductionSalesService(MabnaConf mabnaConf, ProductionSalesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ProductionSalesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/productionsales?_expand=announcement_type", filter, HttpMethod.GET, ProductionSalesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ProductionSalesModel model = ProductionSalesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
