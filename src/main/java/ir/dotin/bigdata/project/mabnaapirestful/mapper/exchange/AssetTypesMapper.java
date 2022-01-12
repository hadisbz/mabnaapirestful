package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.AssetTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetTypesModel;


public class AssetTypesMapper {
    public static AssetTypesModel map(AssetTypesResponse.AssetTypesResponseInner AssetTypesResponseInner) {
        return new AssetTypesModel(
                null,
                AssetTypesResponseInner.getId(),
                AssetTypesResponseInner.getTitle(),
                AssetTypesResponseInner.getEnglishTitle(),
                AssetTypesResponseInner.getCode(),
                MetaMapper.map(AssetTypesResponseInner.getMetaResponse())
        );
    }
}
