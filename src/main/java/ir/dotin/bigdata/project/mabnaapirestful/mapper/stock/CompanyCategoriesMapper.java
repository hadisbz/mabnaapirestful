package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.CompanyCategoriesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.CompanyCategoriesModel;

public class CompanyCategoriesMapper {
    public static CompanyCategoriesModel map(CompanyCategoriesResponse.CompanyCategoriesResponseInner companyCategoriesResponseInner){
        String companyId = null;
        String categoryId=null;
        if(companyCategoriesResponseInner.getCompany()!=null)
            companyId=companyCategoriesResponseInner.getCompany().getId();

        if(companyCategoriesResponseInner.getCategory()!=null)
            categoryId = companyCategoriesResponseInner.getCategory().getId();
        return new CompanyCategoriesModel(
                companyCategoriesResponseInner.getId(),
                companyId,
                categoryId,
                MetaMapper.map(companyCategoriesResponseInner.getMetaResponse())
        );
    }
}
