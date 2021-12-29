package ir.dotin.bigdata.project.mabnaapirestful.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.BondAuthorityTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.DataGenericResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BondAuthorityTypesService implements GenericService<BondAuthorityTypesResponse> {
    private final MabnaConf mabnaConf;
    private final ObjectMapper objectMapper;

    public BondAuthorityTypesService(MabnaConf mabnaConf, ObjectMapper objectMapper) {
        this.mabnaConf = mabnaConf;
        this.objectMapper = objectMapper;
    }

    @Override
    public DataGenericResponse<BondAuthorityTypesResponse> response() throws JsonProcessingException {
        ResponseEntity<String> response = mabnaConf.getResponse("/bond/bondauthoritytypes", HttpMethod.GET);
        DataGenericResponse<BondAuthorityTypesResponse> dataGenericResponse = new DataGenericResponse<BondAuthorityTypesResponse>(
                objectMapper.readValue(response.getBody(), BondAuthorityTypesResponse.class)
        );
        return dataGenericResponse;
    }
}
