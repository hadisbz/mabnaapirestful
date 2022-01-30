package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.MeetingInvitesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.MeetingInvitesModel;

public class MeetingInvitesMapper {
    public static MeetingInvitesModel map(MeetingInvitesResponse.MeetingInvitesResponseInner meetingInvitesResponseInner){
        String companyId=null;
        String reportId=null;
        String statusId=null;
        String statusType=null;

        if(meetingInvitesResponseInner.getCompany()!=null)
            companyId=meetingInvitesResponseInner.getCompany().getId();

        if(meetingInvitesResponseInner.getReport()!=null)
            reportId=meetingInvitesResponseInner.getReport().getId();

        if(meetingInvitesResponseInner.getStatus()!=null){
            statusId=meetingInvitesResponseInner.getStatus().getId();
            statusType = meetingInvitesResponseInner.getStatus().getMetaResponse().getType();
        }

        return new MeetingInvitesModel(
                meetingInvitesResponseInner.getId(),
                companyId,
                reportId,
                statusId,
                statusType,
                meetingInvitesResponseInner.getDateTime(),
                meetingInvitesResponseInner.getFiscalYear(),
                meetingInvitesResponseInner.getAddress(),
                meetingInvitesResponseInner.getEnglishAddress(),
                meetingInvitesResponseInner.getSubject(),
                meetingInvitesResponseInner.getEnglishSubject(),
                meetingInvitesResponseInner.getComments(),
                meetingInvitesResponseInner.getEnglishComments(),
                MetaMapper.map(meetingInvitesResponseInner.getMetaResponse())
        );
    }
}
