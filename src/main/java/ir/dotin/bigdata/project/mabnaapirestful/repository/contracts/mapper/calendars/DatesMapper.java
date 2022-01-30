package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.DatesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.mapper.MetaMapper;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.DatesModel;

public class DatesMapper {
    public static DatesModel map(DatesResponse.DatesResponseInner datesResponseInner) {
        return new DatesModel(
                datesResponseInner.getId(),
                datesResponseInner.getCalendar().getId(),
                datesResponseInner.getOccasionType().getId(),
                datesResponseInner.getYear(),
                datesResponseInner.getMonth(),
                datesResponseInner.getDay(),
                datesResponseInner.getNotes(),
                MetaMapper.map(datesResponseInner.getMetaResponse())
        );
    }
}
