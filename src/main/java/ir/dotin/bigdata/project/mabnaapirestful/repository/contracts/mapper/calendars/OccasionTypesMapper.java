package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.OccasionTypesModel;

public class OccasionTypesMapper {
    public static OccasionTypesModel map(OccasionTypesResponse.OccasionTypesInner occasionTypesInner){
        return new OccasionTypesModel(
                occasionTypesInner.getId(),
                occasionTypesInner.getTitle(),
                occasionTypesInner.getEnglishTitle(),
                MetaMapper.map(occasionTypesInner.getMeta())
        );
    }
}
