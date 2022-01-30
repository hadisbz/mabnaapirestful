package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.FreeFloatsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.FreeFloatsModel;

public class FreeFloatsMapper {
    public static FreeFloatsModel map(FreeFloatsResponse.FreeFloatsResponseInner freeFloatsResponseInner){
        String companyId=null;
        if(freeFloatsResponseInner.getCompany()!=null)
            companyId = freeFloatsResponseInner.getCompany().getId();


        return new FreeFloatsModel(
                freeFloatsResponseInner.getId(),
                freeFloatsResponseInner.getDate(),
                companyId,
                freeFloatsResponseInner.getPercentage(),
                freeFloatsResponseInner.getComments(),
                freeFloatsResponseInner.getEnglishComments(),
                MetaMapper.map(freeFloatsResponseInner.getMetaResponse())
        );
    }
}
