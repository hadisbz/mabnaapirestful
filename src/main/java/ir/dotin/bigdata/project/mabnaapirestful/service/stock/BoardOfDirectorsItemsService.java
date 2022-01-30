package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.BoardOfDirectorsItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.BoardOfDirectorsItemsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BoardOfDirectorsItemsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.stock.BoardOfDirectorsItemsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BoardOfDirectorsItemsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BoardOfDirectorsItemsRepository repository;

    public BoardOfDirectorsItemsService(MabnaConf mabnaConf, BoardOfDirectorsItemsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BoardOfDirectorsItemsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/boardofdirectorsitems", filter, HttpMethod.GET, BoardOfDirectorsItemsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BoardOfDirectorsItemsModel model = BoardOfDirectorsItemsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
