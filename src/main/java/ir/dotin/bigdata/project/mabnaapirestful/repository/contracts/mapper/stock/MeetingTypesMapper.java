package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.stock;

import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.MeetingTypesResponse;
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
