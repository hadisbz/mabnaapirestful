package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.ReportTitlesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.ReportTitlesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportTitlesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.ReportTitlesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReportTitlesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ReportTitlesRepository repository;

    public ReportTitlesService(MabnaConf mabnaConf, ReportTitlesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ReportTitlesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/reporttitles", filter, HttpMethod.GET, ReportTitlesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ReportTitlesModel model = ReportTitlesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}


