package ir.dotin.bigdata.project.mabnaapirestful.mapper.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.exchange.PercentageValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageValuesModel;

public class PercentageValuesMapper {
    public static PercentageValuesModel map(PercentageValuesResponse.PercentageValuesResponseInner percentageValuesResponseInner){
        String percentageGroupId=null;
        String percentageId=null;

        if(percentageValuesResponseInner.getPercentageGroup()!=null)
            percentageGroupId=percentageValuesResponseInner.getPercentageGroup().getId();

        if(percentageValuesResponseInner.getPercentage()!=null)
            percentageId=percentageValuesResponseInner.getPercentage().getId();

        return new PercentageValuesModel(
                percentageValuesResponseInner.getId(),
                percentageGroupId,
                percentageId,
                percentageValuesResponseInner.getValue(),
                percentageValuesResponseInner.getMin(),
                percentageValuesResponseInner.getMax(),
                MetaMapper.map(percentageValuesResponseInner.getMetaResponse())
        );
    }
}
