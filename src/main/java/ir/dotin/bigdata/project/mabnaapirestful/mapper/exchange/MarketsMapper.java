package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.MarketsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.MarketsModel;

public class MarketsMapper {
    public static MarketsModel map(MarketsResponse.MarketsResponseInner marketsResponseInner){
        return new MarketsModel(
                null,
                marketsResponseInner.getId(),
                marketsResponseInner.getCode(),
                marketsResponseInner.getTitle(), marketsResponseInner.getEnglishTitle(),
                MetaMapper.map(marketsResponseInner.getMetaResponse())
        );
    }
}
