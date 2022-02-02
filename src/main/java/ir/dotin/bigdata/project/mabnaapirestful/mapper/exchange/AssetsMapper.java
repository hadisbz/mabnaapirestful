package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetsModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.CategoriesModel;

import java.util.List;
import java.util.stream.Collectors;

public class AssetsMapper {
    public static AssetsModel map(AssetsResponse.AssetsResponseInner assetsResponseInner){
        String assetTypeId=null;
        String exchangeId=null;
        String assetStateId=null;
        String companyId=null;
        String bondId =null;
        String fundId=null;
        String mortgageLoanId=null;
        String entityId=null;
        String entityType=null;
        List<CategoriesModel> categoriesModelList = null;

        if(assetsResponseInner.getCategoriesResponses() != null)
            categoriesModelList = assetsResponseInner.getCategoriesResponses().stream().map(CategoriesMapper::map).collect(Collectors.toList());

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

        if(assetsResponseInner.getBond()!=null)
            bondId=assetsResponseInner.getBond().getId();

        return new AssetsModel(
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
                bondId,
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
                categoriesModelList,
                MetaMapper.map(assetsResponseInner.getMetaResponse())
        );

    }
}
