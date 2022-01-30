package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.DividendPayoutsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.DividendPayoutsModel;

public class DividendPayoutsMapper {
    public static DividendPayoutsModel map(DividendPayoutsResponse.DividendPayoutsResponseInner dividendPayoutsResponseInner){
        String meetingId=null;
        String reportId = null;

        if(dividendPayoutsResponseInner.getMeeting()!=null)
            meetingId=dividendPayoutsResponseInner.getMeeting().getId();

        if(dividendPayoutsResponseInner.getReport()!=null)
            reportId=dividendPayoutsResponseInner.getReport().getId();

        return new DividendPayoutsModel(
                dividendPayoutsResponseInner.getId(),
                meetingId,
                reportId,
                dividendPayoutsResponseInner.getDate(),
                dividendPayoutsResponseInner.getAnnouncementDate(),
                MetaMapper.map(dividendPayoutsResponseInner.getMetaResponse())

        );
    }
}
