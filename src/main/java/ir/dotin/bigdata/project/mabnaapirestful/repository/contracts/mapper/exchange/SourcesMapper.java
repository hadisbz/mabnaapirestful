package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.SourcesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.SourcesModel;

public class SourcesMapper {
    public static SourcesModel map(SourcesResponse.SourcesResponseInner sourcesResponseInner) {
        return new SourcesModel(
                sourcesResponseInner.getId(),
                sourcesResponseInner.getTitle(),
                sourcesResponseInner.getEnglishTitle(),
                MetaMapper.map(sourcesResponseInner.getMetaResponse())
        );
    }
}
