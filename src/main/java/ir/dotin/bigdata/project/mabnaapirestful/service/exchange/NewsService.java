package ir.dotin.bigdata.project.mabnaapirestful.service.exchange;
import com.fasterxml.jackson.core.JsonProcessingException;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.NewsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.service.GenericService;
import ir.dotin.bigdata.project.mabnaapirestful.conf.MabnaConf;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange.NewsMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.NewsModel;
import ir.dotin.bigdata.project.mabnaapirestful.repository.exchange.NewsRepository;
import ir.dotin.bigdata.project.mabnaapirestful.util.FilterResultsMabnaApi;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NewsService implements GenericService {
    private final MabnaConf mabnaConf;
    private final NewsRepository repository;

    public NewsService(MabnaConf mabnaConf, NewsRepository repository) {
        this.mabnaConf = mabnaConf;
        this.repository = repository;
    }

    @Override
    public void save() throws JsonProcessingException {
        ResponseEntity<NewsResponse> response;
        int skip = 0;
        do {
            String filter = FilterResultsMabnaApi.filterByCountAndOptionalSkip(100, skip);
            response = mabnaConf.getResponse("/exchange/news", filter, HttpMethod.GET, NewsResponse.class);

            Objects.requireNonNull(response.getBody()).getData().forEach(responseInner -> {
                        NewsModel model = NewsMapper.map(responseInner);
                        repository.save(model);
                    }
            );
            skip += 100;
        } while (!response.getBody().getData().isEmpty());
    }
}
