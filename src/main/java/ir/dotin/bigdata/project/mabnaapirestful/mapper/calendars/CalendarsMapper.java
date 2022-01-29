package ir.dotin.bigdata.project.mabnaapirestful.mapper.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.calendars.CalendarsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.mapper.MetaMapper;
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
