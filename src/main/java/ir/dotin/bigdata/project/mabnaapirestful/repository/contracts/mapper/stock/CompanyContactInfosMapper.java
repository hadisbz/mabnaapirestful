package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompanyContactInfosResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompanyContactInfosModel;

public class CompanyContactInfosMapper {
    public static CompanyContactInfosModel map(CompanyContactInfosResponse.CompanyContactInfosResponseInner companyContactInfosResponseInner) {
        String companyId = null;
        String CompanyContactInfoTypesResponseId = null;

        if(companyContactInfosResponseInner.getCompany()!=null)
            companyId = companyContactInfosResponseInner.getCompany().getId();

        if(companyContactInfosResponseInner.getType()!=null)
            CompanyContactInfoTypesResponseId = companyContactInfosResponseInner.getType().getId();
        return new CompanyContactInfosModel(
                companyContactInfosResponseInner.getId(),
                companyId,
                CompanyContactInfoTypesResponseId,
                companyContactInfosResponseInner.getTitle(),
                companyContactInfosResponseInner.getEnglishTitle(),
                companyContactInfosResponseInner.getAddress(),
                companyContactInfosResponseInner.getEnglishAddress(),
                companyContactInfosResponseInner.getTelephone(),
                companyContactInfosResponseInner.getFax(),
                companyContactInfosResponseInner.getEmail(),
                companyContactInfosResponseInner.getWebsite(),
                companyContactInfosResponseInner.getComments(),
                companyContactInfosResponseInner.getEnglishComments(),
                companyContactInfosResponseInner.getPoBox(),
                companyContactInfosResponseInner.getPostalCode(),
                MetaMapper.map(companyContactInfosResponseInner.getMetaResponse())
        );
    }
}
