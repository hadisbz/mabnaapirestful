package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.BoardOfDirectorsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BoardOfDirectorsModel;

public class BoardOfDirectorsMapper {
    public static BoardOfDirectorsModel map(BoardOfDirectorsResponse.BoardOfDirectorsResponseInner boardOfDirectorsResponseInner){
        String companyId=null;
        String meetingId=null;
        String reportId=null;

        if(boardOfDirectorsResponseInner.getCompany()!=null)
            companyId = boardOfDirectorsResponseInner.getCompany().getId();

        if(boardOfDirectorsResponseInner.getMeeting()!=null)
            meetingId=boardOfDirectorsResponseInner.getMeeting().getId();

        if(boardOfDirectorsResponseInner.getReport()!=null)
            reportId=boardOfDirectorsResponseInner.getReport().getId();

        return new BoardOfDirectorsModel(
                boardOfDirectorsResponseInner.getId(),
                companyId,
                meetingId,
                reportId,
                boardOfDirectorsResponseInner.getDate(),
                boardOfDirectorsResponseInner.getComments(),
                boardOfDirectorsResponseInner.getEnglishComments(),
                MetaMapper.map(boardOfDirectorsResponseInner.getMetaResponse())
        );
    }
}
