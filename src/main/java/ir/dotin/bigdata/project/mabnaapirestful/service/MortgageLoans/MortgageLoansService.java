package ir.dotin.bigdata.project.mabnaapirestful.service.MortgageLoans;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.mortgageLoans.MortgageLoansResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MortgageLoans.MortgageloansMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.mortgageLoans.MortgageLoansModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.mortgageLoans.MortgageLoansRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MortgageLoansService implements GenericService {
    private final MabnaConf mabnaConf;
    private final MortgageLoansRepository repository;

    public   MortgageLoansService(MabnaConf mabnaConf, MortgageLoansRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<MortgageLoansResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/mortgageloan/mortgageloans", filter, HttpMethod.GET,   MortgageLoansResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                MortgageLoansModel model =  MortgageloansMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}

