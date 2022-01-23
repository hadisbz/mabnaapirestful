package ir.dotin.bigdata.project.mabnaapirestful.mapper.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.OccasionTypesModel;

public class OccasionTypesMapper {
    public static OccasionTypesModel map(OccasionTypesResponse.OccasionTypesInner occasionTypesInner){
        return new OccasionTypesModel(
                null,
                occasionTypesInner.getId(),
                occasionTypesInner.getTitle(),
                occasionTypesInner.getEnglishTitle(),
                MetaMapper.map(occasionTypesInner.getMeta())
        );
    }
}
