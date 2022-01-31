package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ProductionSaleItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.ProductionSaleItemsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProductionSaleItemsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.ProductionSaleItemsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class ProductionSaleItemsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ProductionSaleItemsRepository repository;

    public ProductionSaleItemsService(MabnaConf mabnaConf, ProductionSaleItemsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ProductionSaleItemsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            System.out.println(filter);
            response = mabnaConf.getResponse("/stock/productionsaleitems?_expand=type&", filter, HttpMethod.GET, ProductionSaleItemsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ProductionSaleItemsModel model = ProductionSaleItemsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
