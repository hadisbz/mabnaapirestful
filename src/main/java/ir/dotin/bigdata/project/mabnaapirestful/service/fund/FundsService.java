package ir.dotin.bigdata.project.mabnaapirestful.service.fund;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.fund.FundsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.fund.FundsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.FundsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.fund.FundsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FundsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final FundsRepository repository;

    public FundsService(MabnaConf mabnaConf, FundsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<FundsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/fund/funds", filter, HttpMethod.GET, FundsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        FundsModel model = FundsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}

