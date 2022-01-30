package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.MeetingsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.MeetingsModel;

public class MeetingsMapper {
    public static MeetingsModel map(MeetingsResponse.MeetingsResponseInner meetingsResponseInner){
        String companyId=null;
        String reportId=null;
        String meetingTypeId=null;

        if(meetingsResponseInner.getCompany()!=null)
            companyId=meetingsResponseInner.getCompany().getId();

        if(meetingsResponseInner.getReport()!=null)
            reportId=meetingsResponseInner.getReport().getId();

        if(meetingsResponseInner.getType()!=null)
            meetingTypeId=meetingsResponseInner.getType().getId();

        return new MeetingsModel(
                meetingsResponseInner.getId(),
                companyId,
                reportId,
                meetingTypeId,
                meetingsResponseInner.getDate(),
                meetingsResponseInner.getFiscalYear(),
                MetaMapper.map(meetingsResponseInner.getMetaResponse())

                );

    }
}
