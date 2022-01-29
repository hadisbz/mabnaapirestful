package ir.dotin.bigdata.project.mabnaapirestful.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.MeetingTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.MeetingTypesModel;
public class MeetingTypesMapper {
    public static MeetingTypesModel map(MeetingTypesResponse.MeetingTypesResponseInner MeetingTypesResponseInner){
        return new MeetingTypesModel(
                MeetingTypesResponseInner.getId(),
                MeetingTypesResponseInner.getTitle(),
                MetaMapper.map(MeetingTypesResponseInner.getMetaResponse())
        );
    }

}
