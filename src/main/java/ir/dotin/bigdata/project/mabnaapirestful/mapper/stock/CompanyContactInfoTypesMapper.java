package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompanyContactInfoTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompanyContactInfoTypesModel;

public class CompanyContactInfoTypesMapper {
    public static CompanyContactInfoTypesModel map(CompanyContactInfoTypesResponse.CompanyContactInfoTypesResponseInner CompanyContactInfoTypesResponseInner){
        return new CompanyContactInfoTypesModel(
                null,
                CompanyContactInfoTypesResponseInner.getTitle(),
                CompanyContactInfoTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(CompanyContactInfoTypesResponseInner.getMetaResponse())
        );
    }
}
