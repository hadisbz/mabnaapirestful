package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.CategoriesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.CategoriesModel;

public class CategoriesMapper {
    public static CategoriesModel map(CategoriesResponse.CategoriesResponseInner categoriesResponseInner){
        String parentId = null;
        String parentType = null;
        if(categoriesResponseInner.getParent() != null) {
            parentId = categoriesResponseInner.getParent().getId();
            parentType = categoriesResponseInner.getParent().getMetaResponse().getType();
        }
        return new CategoriesModel(
                categoriesResponseInner.getId(),
                parentId,
                parentType,
                categoriesResponseInner.getCode(),
                categoriesResponseInner.getName(),
                categoriesResponseInner.getEnglishName(),
                categoriesResponseInner.getShortName(),
                categoriesResponseInner.getEnglishShortName(),
                MetaMapper.map(categoriesResponseInner.getMetaResponse())
        );
    }
}
