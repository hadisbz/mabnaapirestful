package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompaniesResponse;
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
