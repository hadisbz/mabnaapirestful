package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.TheoreticalOpeningPricesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.TheoreticalOpeningPricesModel;

public class TheoreticalOpeningPricesMapper {
    public static TheoreticalOpeningPricesModel map(TheoreticalOpeningPricesResponse.TheoreticalOpeningPricesResponseInner theoreticalOpeningPricesResponseInner){
        String instrumentId=null;

        if(theoreticalOpeningPricesResponseInner.getInstrument()!=null)
            instrumentId=theoreticalOpeningPricesResponseInner.getInstrument().getId();

        return new TheoreticalOpeningPricesModel(
                theoreticalOpeningPricesResponseInner.getId(),
                instrumentId,
                theoreticalOpeningPricesResponseInner.getDateTime(),
                theoreticalOpeningPricesResponseInner.getPrice(),
                MetaMapper.map(theoreticalOpeningPricesResponseInner.getMetaResponse())
        );
    }
}
