package ir.dotin.bigdata.project.mabnaapirestful.model.api.response.calendars;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class DatesResponse {
    @JsonProperty("data")
    private List<DatesResponseInner> data;

    @Getter
    @ToString
    public static class DatesResponseInner {
        @JsonProperty("calendar")
        private CalendarsResponse.CalendarsResponseInner calendar;

        @JsonProperty("occasion_type")
        private OccasionTypesResponse.OccasionTypesInner occasionType;

        private String id;

        private Integer year;

        private Integer month;

        private Integer day;

        private String notes;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}