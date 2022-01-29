package ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
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

        private Long year;

        private Long month;

        private Long day;

        private String notes;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}