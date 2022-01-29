package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompanyContactInfoTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompanyContactInfoTypesModel;

public class CompanyContactInfoTypesMapper {
    public static CompanyContactInfoTypesModel map(CompanyContactInfoTypesResponse.CompanyContactInfoTypesResponseInner companyContactInfoTypesResponseInner){
        return new CompanyContactInfoTypesModel(
                companyContactInfoTypesResponseInner.getId(),
                companyContactInfoTypesResponseInner.getTitle(),
                companyContactInfoTypesResponseInner.getEnglishTitle(),
                MetaMapper.map(companyContactInfoTypesResponseInner.getMetaResponse())
        );
    }
}
