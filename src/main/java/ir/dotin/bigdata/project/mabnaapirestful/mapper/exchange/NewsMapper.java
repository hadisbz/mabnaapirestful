package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.NewsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.NewsModel;

public class NewsMapper {
    public static NewsModel map(NewsResponse.NewsResponseInner newsResponse) {
        String entityId = null;
        String entityType = null;
        String sourceId = null;

        if (newsResponse.getEntity() != null) {
            entityId = newsResponse.getEntity().getId();
            entityType = newsResponse.getEntity().getMetaResponse().getType();
        }

        if(newsResponse.getSource() != null)
            sourceId = newsResponse.getSource().getId();

        return new NewsModel(
                null,
                newsResponse.getId(),
                sourceId,
                entityId,
                entityType,
                newsResponse.getDate(),
                newsResponse.getTitle(),
                newsResponse.getText(),
                MetaMapper.map(newsResponse.getMetaResponse())
        );
    }
}
