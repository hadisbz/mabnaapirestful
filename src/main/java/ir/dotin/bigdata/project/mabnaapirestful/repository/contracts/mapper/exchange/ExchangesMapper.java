package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ExchangesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ExchangesModel;

public class ExchangesMapper {
    public static ExchangesModel map(ExchangesResponse.ExchangesResponseInner ExchangesResponseInner){
        return new ExchangesModel(
                ExchangesResponseInner.getId(),
                ExchangesResponseInner.getCode(),
                ExchangesResponseInner.getTitle(),
                ExchangesResponseInner.getEnglishTitle(),
                MetaMapper.map(ExchangesResponseInner.getMetaResponse())
        );
    }
}
