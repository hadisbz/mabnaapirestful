package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.AssetsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.AssetsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AssetsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final AssetsRepository repository;

    public AssetsService(MabnaConf mabnaConf, AssetsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<AssetsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/assets", filter, HttpMethod.GET, AssetsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        AssetsModel model = AssetsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
