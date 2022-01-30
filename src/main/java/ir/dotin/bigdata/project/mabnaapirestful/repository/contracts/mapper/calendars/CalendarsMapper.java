package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.CalendarsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.CalendarsModel;

public class CalendarsMapper {
    public static CalendarsModel map(CalendarsResponse.CalendarsResponseInner calendarsResponseInner){
        return new CalendarsModel(
                calendarsResponseInner.getId(),
                calendarsResponseInner.getTitle(),
                calendarsResponseInner.getEnglishTitle(),
                MetaMapper.map(calendarsResponseInner.getMetaResponse())
        );
    }
}
