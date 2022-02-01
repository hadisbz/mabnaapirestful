package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ShareHoldersItemsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ShareHoldersItemsModel;

public class ShareHoldersItemsMapper {
    public static ShareHoldersItemsModel map (ShareHoldersItemsResponse.ShareHoldersItemsResponseInner shareHoldersItemsResponseInner){
        String shareholderId=null;
        String entityId=null;

        if(shareHoldersItemsResponseInner.getShareholders()!=null)
            shareholderId=shareHoldersItemsResponseInner.getShareholders().getId();

        if(shareHoldersItemsResponseInner.getEntity()!=null)
           entityId = shareHoldersItemsResponseInner.getEntity().getId();

        return new ShareHoldersItemsModel(
                shareHoldersItemsResponseInner.getId(),
                shareholderId,
                entityId,
                shareHoldersItemsResponseInner.getPercentage(),
                MetaMapper.map(shareHoldersItemsResponseInner.getMetaResponse())
        );

    }
}
