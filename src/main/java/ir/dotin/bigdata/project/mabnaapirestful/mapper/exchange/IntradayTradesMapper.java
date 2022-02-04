package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IntradayTradesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IntradayTradesModel;

public class IntradayTradesMapper {
    public static IntradayTradesModel map(IntradayTradesResponse.IntradayTradesResponseInner intradayTradesResponseInner){
        String tradeId=null;
        String instrumentId=null;

        if(intradayTradesResponseInner!=null)
            tradeId=intradayTradesResponseInner.getTrade().getId();

        if(intradayTradesResponseInner.getInstrument()!=null)
            instrumentId=intradayTradesResponseInner.getInstrument().getId();
        return new IntradayTradesModel(
                intradayTradesResponseInner.getId(),
                tradeId,
                instrumentId,
                intradayTradesResponseInner.getDateTime(),
                intradayTradesResponseInner.getClosePrice(),
                intradayTradesResponseInner.getRealClosePrice(),
                intradayTradesResponseInner.getVolume(),
                intradayTradesResponseInner.getValue(),
                intradayTradesResponseInner.getTradeCount(),
                intradayTradesResponseInner.getOpenPrice(),
                intradayTradesResponseInner.getLowPrice(),
                intradayTradesResponseInner.getHighPrice(),
                MetaMapper.map(intradayTradesResponseInner.getMetaResponse())
        );
    }


}
