package ir.dotin.bigdata.project.mabnaapirestful.mapper.fund;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.fund.RatingsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.fund.RatingsModel;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;


public class RatingsMapper {
    public static RatingsModel map(RatingsResponse.RatingsResponseInner ratingsResponseInner){
        String fundId= null;
        String creditRaterID=null;
        String creditRaterType=null;

        if(ratingsResponseInner.getFund()!=null)
            fundId=ratingsResponseInner.getFund().getId();

        if(ratingsResponseInner.getCreditRater()!=null){
            creditRaterID = ratingsResponseInner.getCreditRater().getId();
            creditRaterType = ratingsResponseInner.getCreditRater().getMetaResponse().getType();
        }
        return new RatingsModel (
                null,
                ratingsResponseInner.getId(),
                fundId,
                ratingsResponseInner.getDate(),
                ratingsResponseInner.getRating(),
                ratingsResponseInner.getRatingPeriod(),
                creditRaterID,
                creditRaterType,
                ratingsResponseInner.getPublishDate(),
                MetaMapper.map(ratingsResponseInner.getMetaResponse())




                );
    }
}