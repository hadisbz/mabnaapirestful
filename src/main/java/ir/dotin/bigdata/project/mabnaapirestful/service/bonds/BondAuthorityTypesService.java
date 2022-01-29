package ir.dotin.bigdata.project.mabnaapirestful.service.bonds;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.bonds.BondAuthorityTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.bonds.BondAuthorityTypesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.bonds.BondAuthorityTypesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.bonds.BondAuthorityTypesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BondAuthorityTypesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final BondAuthorityTypesRepository repository;

    public BondAuthorityTypesService(MabnaConf mabnaConf, BondAuthorityTypesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<BondAuthorityTypesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/bond/bondauthoritytypes", filter, HttpMethod.GET, BondAuthorityTypesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        BondAuthorityTypesModel model = BondAuthorityTypesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}

