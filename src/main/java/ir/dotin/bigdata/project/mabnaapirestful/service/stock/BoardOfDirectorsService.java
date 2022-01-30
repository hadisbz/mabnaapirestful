package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.BoardOfDirectorsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock.BoardOfDirectorsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BoardOfDirectorsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.BoardOfDirectorsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BoardOfDirectorsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BoardOfDirectorsRepository repository;

    public BoardOfDirectorsService(MabnaConf mabnaConf, BoardOfDirectorsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BoardOfDirectorsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/boardofdirectors", filter, HttpMethod.GET, BoardOfDirectorsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BoardOfDirectorsModel model = BoardOfDirectorsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
