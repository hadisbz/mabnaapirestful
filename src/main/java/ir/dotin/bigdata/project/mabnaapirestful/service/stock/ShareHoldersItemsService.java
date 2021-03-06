package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ShareHoldersItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.ShareHoldersItemsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ShareHoldersItemsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.ShareHoldersItemsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShareHoldersItemsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ShareHoldersItemsRepository repository;

    public ShareHoldersItemsService(MabnaConf mabnaConf, ShareHoldersItemsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ShareHoldersItemsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/shareholdersitems", filter, HttpMethod.GET, ShareHoldersItemsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ShareHoldersItemsModel model = ShareHoldersItemsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
