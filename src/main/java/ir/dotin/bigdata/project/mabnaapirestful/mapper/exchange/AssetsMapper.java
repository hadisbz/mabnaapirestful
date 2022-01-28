package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.CategoriesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetsModel;

import java.util.stream.Collectors;

public class AssetsMapper {
    public static AssetsModel map(AssetsResponse.AssetsResponseInner assetsResponseInner){
        String assetTypeId=null;
        String exchangeId=null;
        String assetStateId=null;
        String companyId=null;
        String fundId=null;
        String mortgageLoanId=null;
        String entityId=null;
        String entityType=null;

        if(assetsResponseInner.getType()!=null)
            assetTypeId=assetsResponseInner.getType().getId();

        if(assetsResponseInner.getExchange()!=null)
            exchangeId=assetsResponseInner.getExchange().getId();

        if(assetsResponseInner.getState()!=null)
            assetStateId=assetsResponseInner.getState().getId();

        if(assetsResponseInner.getStock()!=null)
            if(assetsResponseInner.getStock().getCompany()!=null)
                companyId=assetsResponseInner.getStock().getCompany().getId();

        if(assetsResponseInner.getFund()!=null)
            fundId = assetsResponseInner.getFund().getId();

        if(assetsResponseInner.getMortgageLoan()!=null)
            mortgageLoanId  = assetsResponseInner.getMortgageLoan().getId();

        if(assetsResponseInner.getEntity()!=null){
            entityId = assetsResponseInner.getEntity().getId();
            entityType=assetsResponseInner.getEntity().getMetaResponse().getType();
        }

        return new AssetsModel(
                null,
                assetsResponseInner.getId(),
                assetTypeId,
                assetsResponseInner.getTradeSymbol(),
                assetsResponseInner.getEnglishTradeSymbol(),
                assetsResponseInner.getName(),
                assetsResponseInner.getEnglishName(),
                assetsResponseInner.getShortName(),
                assetsResponseInner.getEnglishShortName(),
                exchangeId,
                assetStateId,
                companyId,
                fundId,
                mortgageLoanId,
                assetsResponseInner.getFingilishName(),
                assetsResponseInner.getFingilishShortName(),
                assetsResponseInner.getFingilishTradeSymbol(),
                assetsResponseInner.getStateChangeDate(),
                assetsResponseInner.getStateDescription(),
                assetsResponseInner.getEnglishStateDescription(),
                entityId,
                entityType,
                null,
                MetaMapper.map(assetsResponseInner.getMetaResponse())
        );

    }
}
