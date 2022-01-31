package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.BidAsksResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.BidAsksModel;

public class BidAsksMapper {
    public static BidAsksModel map(BidAsksResponse.BidAsksResponseInner bidAsksResponseInner){
        String instrumentId=null;

        if(bidAsksResponseInner.getInstrument()!=null)
            instrumentId=bidAsksResponseInner.getInstrument().getId();

        return new BidAsksModel(
                bidAsksResponseInner.getId(),
                instrumentId,
                bidAsksResponseInner.getDateTime(),
                bidAsksResponseInner.getOrderRank(),
                bidAsksResponseInner.getAskCount(),
                bidAsksResponseInner.getAskOrder(),
                bidAsksResponseInner.getAskVolume(),
                bidAsksResponseInner.getAskPrice(),
                bidAsksResponseInner.getBidOrder(),
                bidAsksResponseInner.getBidVolume(),
                bidAsksResponseInner.getBidPrice(),
                MetaMapper.map(bidAsksResponseInner.getMetaResponse())
        );
    }
}
