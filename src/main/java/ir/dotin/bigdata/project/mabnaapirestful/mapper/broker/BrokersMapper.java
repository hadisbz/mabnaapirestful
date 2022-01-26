package ir.dotin.bigdata.project.mabnaapirestful.mapper.broker;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.broker.BrokersResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.BrokersModel;

public class BrokersMapper {
    public static BrokersModel map(BrokersResponse.BrokersResponseInner brokersResponseInner){
        String parentId = null;
        String ParentType = null;

        if(brokersResponseInner.getParent()!=null){
            parentId = brokersResponseInner.getParent().getId();
            ParentType = brokersResponseInner.getParent().getMetaResponse().getType();
        }

        return new BrokersModel(
                null,
                brokersResponseInner.getId(),
                brokersResponseInner.getCode(),
                brokersResponseInner.getName(),
                brokersResponseInner.getEnglishName(),
                brokersResponseInner.getShortName(),
                brokersResponseInner.getEnglishShortName(),
                parentId,
                ParentType,
                brokersResponseInner.getBicCode(),
                brokersResponseInner.getTradeCode(),
                brokersResponseInner.getNscCode(),
                MetaMapper.map(brokersResponseInner.getMetaResponse())
        );
    }
}
