package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ExchangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ExchangesModel;

public class ExchangesMapper {
    public static ExchangesModel map(ExchangesResponse.ExchangesResponseInner ExchangesResponseInner){
        return new ExchangesModel(
                null,
                ExchangesResponseInner.getId(),
                ExchangesResponseInner.getCode(),
                ExchangesResponseInner.getTitle(),
                ExchangesResponseInner.getEnglishTitle(),
                MetaMapper.map(ExchangesResponseInner.getMetaResponse())
        );
    }
}
