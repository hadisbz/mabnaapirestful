package ir.dotin.bigdata.project.mabnaapirestful.mapper.fund;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.fund.DividendPaymentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.DividendPaymentsModel;

public class DividendPaymentsMapper {
    public static DividendPaymentsModel map(DividendPaymentsResponse.DividendPaymentsResponseInner dividendPaymentsResponseInner) {
        String FundId = null;
        if (dividendPaymentsResponseInner.getFund() != null) {
            FundId = dividendPaymentsResponseInner.getFund().getId();
        }
        return new DividendPaymentsModel(
                dividendPaymentsResponseInner.getId(),
                FundId,
                dividendPaymentsResponseInner.getDate(),
                dividendPaymentsResponseInner.getDividend(),
                MetaMapper.map(dividendPaymentsResponseInner.getMetaResponse())
        );
    }

}
