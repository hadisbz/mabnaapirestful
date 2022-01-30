package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InitialPublicOfferingsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.InitialPublicOfferingsModel;

public class InitialPublicOfferingsMapper {
    public static InitialPublicOfferingsModel map(InitialPublicOfferingsResponse.InitialPublicOfferingsResponseInner initialPublicOfferingsResponseInner){
        String instrumentId=null;
        String instrumentType=null;

        if(initialPublicOfferingsResponseInner.getInstrument()!=null){
            instrumentId=initialPublicOfferingsResponseInner.getInstrument().getId();
            instrumentType=initialPublicOfferingsResponseInner.getInstrument().getMetaResponse().getType();
        }
        return new InitialPublicOfferingsModel(
                initialPublicOfferingsResponseInner.getId(),
                instrumentId,
                instrumentType,
                initialPublicOfferingsResponseInner.getStartDateTime(),
                initialPublicOfferingsResponseInner.getEndDateTime(),
                initialPublicOfferingsResponseInner.getMinPricePermit(),
                initialPublicOfferingsResponseInner.getMaxPricePermit(),
                initialPublicOfferingsResponseInner.getMinVolumePermit(),
                initialPublicOfferingsResponseInner.getMaxVolumePermit(),
                initialPublicOfferingsResponseInner.getStartTradingDate(),
                initialPublicOfferingsResponseInner.getAllotmentDate(),
                MetaMapper.map(initialPublicOfferingsResponseInner.getMetaResponse())
        );

    }
}
