package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.TradeDetailsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.TradeDetailsModel;

public class TradeDetailsMapper {
    public static TradeDetailsModel map(TradeDetailsResponse.TradeDetailsResponseInner tradeDetailsResponseInner){
        String tradeId=null;
        String instrumentId=null;
        if(tradeDetailsResponseInner.getTrade()!=null)
            tradeId = tradeDetailsResponseInner.getTrade().getId();

        if(tradeDetailsResponseInner.getInstrument()!=null)
            instrumentId=tradeDetailsResponseInner.getInstrument().getId();
        return new TradeDetailsModel (
                tradeDetailsResponseInner.getId(),
                tradeId,
                instrumentId,
                tradeDetailsResponseInner.getDateTime(),
                tradeDetailsResponseInner.getPersonBuyerCount(),
                tradeDetailsResponseInner.getCompanyBuyerCount(),
                tradeDetailsResponseInner.getPersonBuyVolume(),
                tradeDetailsResponseInner.getCompanyBuyVolume(),
                tradeDetailsResponseInner.getPersonSellerCount(),
                tradeDetailsResponseInner.getCompanySellerCount(),
                tradeDetailsResponseInner.getPersonSellVolume(),
                tradeDetailsResponseInner.getCompanySellVolume(),
                MetaMapper.map(tradeDetailsResponseInner.getMetaResponse())
        );
    }
}
