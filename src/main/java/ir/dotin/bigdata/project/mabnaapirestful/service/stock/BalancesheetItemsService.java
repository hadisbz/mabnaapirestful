package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.BalancesheetItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.BalancesheetItemsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetItemsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.BalancesheetItemsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BalancesheetItemsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BalancesheetItemsRepository repository;

    public BalancesheetItemsService(MabnaConf mabnaConf, BalancesheetItemsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BalancesheetItemsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/balancesheetitems", filter, HttpMethod.GET, BalancesheetItemsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BalancesheetItemsModel model = BalancesheetItemsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
