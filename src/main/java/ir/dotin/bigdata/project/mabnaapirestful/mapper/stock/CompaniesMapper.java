package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompaniesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompaniesModel;

public class CompaniesMapper {
    public static CompaniesModel map(CompaniesResponse.CompaniesResponseInner companiesResponseInner){
        String stateId = null;
        String exchangeId = null;
        if(companiesResponseInner.getState()!=null)
            stateId = companiesResponseInner.getState().getId();
        if(companiesResponseInner.getExchange()!=null)
            exchangeId = companiesResponseInner.getExchange().getId();
        return new CompaniesModel(
                null,
                companiesResponseInner.getId(),
                companiesResponseInner.getName(),
                companiesResponseInner.getEnglishName(),
                companiesResponseInner.getShortName(),
                companiesResponseInner.getEnglishShortName(),
                companiesResponseInner.getTradeSymbol(),
                companiesResponseInner.getEnglishTradeSymbol(),
                companiesResponseInner.getDescription(),
                companiesResponseInner.getFiscalyear(),
                stateId,
                exchangeId,
                MetaMapper.map(companiesResponseInner.getMetaResponse())
        );
    }
}
