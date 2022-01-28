package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.SourcesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.SourcesModel;

public class SourcesMapper {
    public static SourcesModel map(SourcesResponse.SourcesResponseInner sourcesResponseInner) {
        return new SourcesModel(
                null,
                sourcesResponseInner.getId(),
                sourcesResponseInner.getTitle(),
                sourcesResponseInner.getEnglishTitle(),
                MetaMapper.map(sourcesResponseInner.getMetaResponse())
        );
    }
}
