package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.MarketsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.MarketsModel;

public class MarketsMapper {
    public static MarketsModel map(MarketsResponse.MarketsResponseInner marketsResponseInner){
        return new MarketsModel(
                marketsResponseInner.getId(),
                marketsResponseInner.getCode(),
                marketsResponseInner.getTitle(), marketsResponseInner.getEnglishTitle(),
                MetaMapper.map(marketsResponseInner.getMetaResponse())
        );
    }
}
