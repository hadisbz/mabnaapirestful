package ir.dotin.bigdata.project.mabnaapirestful.mapper;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.AnnouncementTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;

public class AnnouncementTypeMapper {
    public static AnnouncementTypeModel map(AnnouncementTypeResponse announcementTypeResponse){
        return new AnnouncementTypeModel(
                announcementTypeResponse.getId(),
                announcementTypeResponse.getTitle(),
                announcementTypeResponse.getEnglishTitle(),
                announcementTypeResponse.getMetaResponse().getType(),
                announcementTypeResponse.getMetaResponse().getVersion(),
                announcementTypeResponse.getMetaResponse().getState(),
                announcementTypeResponse.getMetaResponse().getInsertDateTime(),
                announcementTypeResponse.getMetaResponse().getUpdateDateTime(),
                announcementTypeResponse.getMetaResponse().getDeleteDateTime()

        );
    }
}
