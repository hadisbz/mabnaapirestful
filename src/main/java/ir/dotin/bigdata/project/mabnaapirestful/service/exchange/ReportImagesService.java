package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.ReportImagesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.ReportImagesMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportImagesFileModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportImagesModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.ReportImagesFileRepository;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.ReportImagesRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.Objects;

@Service
public class ReportImagesService implements GenericService {
    private final MabnaConf mabnaConf;
    private final ReportImagesRepository repository;
    private final ReportImagesFileRepository reportImagesFileRepository;

    public ReportImagesService(MabnaConf mabnaConf, ReportImagesRepository repository, ReportImagesFileRepository reportImagesFileRepository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
        this.reportImagesFileRepository = reportImagesFileRepository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<ReportImagesResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/reportimages", filter, HttpMethod.GET, ReportImagesResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        ReportImagesModel model = ReportImagesMapper.map(responseInner);
                        repository.save(model);
                        try {
                            ResponseEntity<byte[]> file = mabnaConf.getResponseFile("/exchange/reportimages/" + model.getId() + "/content", MediaType.valueOf(model.getContentType().toUpperCase()));

                            reportImagesFileRepository.save(
                                    new ReportImagesFileModel(
                                            model.getId(),
                                            file.getBody()
                                    )
                            );
                        } catch (IOException | HttpClientErrorException e) {
                            e.printStackTrace();
                        }
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
