package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.TradesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.TradesModel;

public class TradesMapper {
    public static TradesModel map(TradesResponse.TradesResponseInner tradesResponseInner){
        String instrumentId=null;

        if(tradesResponseInner.getInstrument()!=null)
            instrumentId=tradesResponseInner.getInstrument().getId();

        return new TradesModel(
                tradesResponseInner.getId(),
                instrumentId,
                tradesResponseInner.getDateTime(),
                tradesResponseInner.getOpenPrice(),
                tradesResponseInner.getHighPrice(),
                tradesResponseInner.getLowPrice(),
                tradesResponseInner.getRealClosePrice(),
                tradesResponseInner.getRealClosePriceChange(),
                tradesResponseInner.getClosePrice(),
                tradesResponseInner.getClosePriceChange(),
                tradesResponseInner.getBuyerCount(),
                tradesResponseInner.getVolume(),
                tradesResponseInner.getValue(),
                tradesResponseInner.getTradeCount(),
                tradesResponseInner.getAdjustedClosePrice(),
                MetaMapper.map(tradesResponseInner.getMetaResponse())

        );
    }
}
