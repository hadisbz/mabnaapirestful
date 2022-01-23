package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.stock.ShareHoldersResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.ShareHoldersMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ShareHoldersModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.ShareHoldersRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class ShareHoldersService implements GenericService{
    private final MabnaConf mabnaConf;
    private final ShareHoldersRepository repository;

    public ShareHoldersService(MabnaConf mabnaConf, ShareHoldersRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ShareHoldersResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/shareholders", filter, HttpMethod.GET, ShareHoldersResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ShareHoldersModel model = ShareHoldersMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
