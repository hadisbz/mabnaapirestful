package ir.dotin.bigdata.project.mabnaapirestful.mapper.bonds;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds.InterestPaymentsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.bonds.InterestPaymentsModel;

public class InterestPaymentsMapper {
    public static InterestPaymentsModel map(InterestPaymentsResponse.InterestPaymentsResponseInner interestPaymentsResponseInner) {
        String bondId=null;
        if(interestPaymentsResponseInner.getBond()!=null)
            bondId=interestPaymentsResponseInner.getBond().getId();
        return new InterestPaymentsModel(
                interestPaymentsResponseInner.getId(),
                bondId,
                interestPaymentsResponseInner.getStartDate(),
                interestPaymentsResponseInner.getEndDate(),
                interestPaymentsResponseInner.getInterest(),
                MetaMapper.map(interestPaymentsResponseInner.getMetaResponse())


        );
    }

}
