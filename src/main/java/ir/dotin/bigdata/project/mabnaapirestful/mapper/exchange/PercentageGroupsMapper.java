package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.PercentageGroupsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageGroupsModel;

public class PercentageGroupsMapper {
    public static PercentageGroupsModel map(PercentageGroupsResponse.PercentageGroupsResponseInner percentageGroupsResponseInner){
        String actionTypeId=null;
        String assetTypeId=null;
        String exchangeId=null;
        String assetId=null;
        String categoryId=null;
        String dealerTypeId=null;

        if(percentageGroupsResponseInner.getActionType()!=null)
            actionTypeId=percentageGroupsResponseInner.getActionType().getId();

        if(percentageGroupsResponseInner.getAssetType()!=null)
            assetTypeId=percentageGroupsResponseInner.getAssetType().getId();

        if(percentageGroupsResponseInner.getExchange()!=null)
            exchangeId=percentageGroupsResponseInner.getExchange().getId();

        if(percentageGroupsResponseInner.getAsset()!=null)
            assetId=percentageGroupsResponseInner.getAsset().getId();

        if(percentageGroupsResponseInner.getCategory()!=null)
            categoryId=percentageGroupsResponseInner.getCategory().getId();

        if(percentageGroupsResponseInner.getDealerType()!=null)
            dealerTypeId=percentageGroupsResponseInner.getDealerType().getId();

        return new PercentageGroupsModel(
                null,
                percentageGroupsResponseInner.getId(),
                percentageGroupsResponseInner.getTitle(),
                percentageGroupsResponseInner.getEnglishTitle(),
                percentageGroupsResponseInner.getStartDate(),
                percentageGroupsResponseInner.getEndDate(),
                actionTypeId,
                assetTypeId,
                exchangeId,
                assetId,
                categoryId,
                dealerTypeId,
                MetaMapper.map(percentageGroupsResponseInner.getMetaResponse())

        );



    }
}
