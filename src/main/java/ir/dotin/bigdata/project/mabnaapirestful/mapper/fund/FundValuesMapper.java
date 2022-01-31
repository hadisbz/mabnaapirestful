package ir.dotin.bigdata.project.mabnaapirestful.mapper.fund;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.fund.FundValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.FundValuesModel;

public class FundValuesMapper {
    public static FundValuesModel map(FundValuesResponse.FundValuesResponseInner fundValuesResponseInner) {
        String FundId = null;
        if (fundValuesResponseInner.getFund() != null) {
            FundId = fundValuesResponseInner.getFund().getId();
        }
        return new FundValuesModel(
                fundValuesResponseInner.getId(),
                FundId,
                fundValuesResponseInner.getDate(),
                fundValuesResponseInner.getBidPrice(),
                fundValuesResponseInner.getRedemptionPrice(),
                fundValuesResponseInner.getStatisticalPrice(),
                fundValuesResponseInner.getBidCount(),
                fundValuesResponseInner.getRedemptionCount(),
                fundValuesResponseInner.getNav(),
                fundValuesResponseInner.getUnits(),
                MetaMapper.map(fundValuesResponseInner.getMetaResponse())
        );
    }

}
