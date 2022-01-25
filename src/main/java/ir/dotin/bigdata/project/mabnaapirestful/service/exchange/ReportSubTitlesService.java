package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportSubTitlesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.ReportSubTitlesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportSubTitlesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.ReportSubTitlesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReportSubTitlesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ReportSubTitlesRepository repository;

    public ReportSubTitlesService(MabnaConf mabnaConf, ReportSubTitlesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ReportSubTitlesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/reportsubtitles", filter, HttpMethod.GET, ReportSubTitlesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ReportSubTitlesModel model = ReportSubTitlesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}



