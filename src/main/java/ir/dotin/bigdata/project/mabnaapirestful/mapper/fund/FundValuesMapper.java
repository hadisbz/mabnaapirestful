package ir.dotin.bigdata.project.mabnaapirestful.mapper.fund;

import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.fund.FundValuesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.FundValuesModel;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;

public class FundValuesMapper {
    public static FundValuesModel map(FundValuesResponse.FundValuesResponseInner fundValuesResponseInner) {
        String FundId = null;
        if (fundValuesResponseInner.getFund() != null) {
            FundId = fundValuesResponseInner.getFund().getId();
        }
        return new FundValuesModel(
                null,
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
