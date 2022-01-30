package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetCategoriesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetCategoriesModel;

public class AssetCategoriesMapper {
    public static AssetCategoriesModel map(AssetCategoriesResponse.AssetCategoriesResponseInner assetCategoriesResponseInner){
        String assetId=null;
        String categoryId=null;

        if(assetCategoriesResponseInner.getAsset()!=null)
            assetId = assetCategoriesResponseInner.getAsset().getId();

        if(assetCategoriesResponseInner.getCategory()!=null)
            categoryId=assetCategoriesResponseInner.getCategory().getId();

        return new AssetCategoriesModel(
                assetCategoriesResponseInner.getId(),
                assetId,
                categoryId,
                MetaMapper.map(assetCategoriesResponseInner.getMetaResponse())
        );
    }
}
