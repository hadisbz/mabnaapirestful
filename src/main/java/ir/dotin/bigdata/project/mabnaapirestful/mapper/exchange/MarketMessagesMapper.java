package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.MarketMessagesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.MarketMessagesModel;

public class MarketMessagesMapper {
    public static MarketMessagesModel map(MarketMessagesResponse.MarketMessagesResponseInner marketMessagesResponseInner) {
        return new MarketMessagesModel(
                null,
                marketMessagesResponseInner.getId(),
                marketMessagesResponseInner.getDateTime(),
                marketMessagesResponseInner.getTitle(),
                marketMessagesResponseInner.getText(),
                MetaMapper.map(marketMessagesResponseInner.getMetaResponse())
        );
    }
}
