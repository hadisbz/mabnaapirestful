package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.ShareHoldersResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ShareHoldersModel;

public class ShareHoldersMapper {
    public static ShareHoldersModel map(ShareHoldersResponse.ShareHoldersResponseInner shareHoldersResponseInner){
        String companyId=null;
        String reportId = null;
        if(shareHoldersResponseInner.getCompany()!=null)
            companyId = shareHoldersResponseInner.getCompany().getId();

        if(shareHoldersResponseInner.getReport()!=null)
            reportId=shareHoldersResponseInner.getReport().getId();
        return new ShareHoldersModel(
                shareHoldersResponseInner.getId(),
                shareHoldersResponseInner.getDate(),
                companyId,
                reportId,
                shareHoldersResponseInner.getComments(),
                shareHoldersResponseInner.getEnglishComments(),
                MetaMapper.map(shareHoldersResponseInner.getMetaResponse())
        );
    }
}
