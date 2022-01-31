package ir.dotin.bigdata.project.mabnaapirestful.service.stock;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.MeetingInvitesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.stock.MeetingInvitesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.MeetingInvitesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.stock.MeetingInvitesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class MeetingInvitesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final MeetingInvitesRepository repository;

    public MeetingInvitesService(MabnaConf mabnaConf, MeetingInvitesRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<MeetingInvitesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/stock/MeetingInvites", filter, HttpMethod.GET, MeetingInvitesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        MeetingInvitesModel model = MeetingInvitesMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
