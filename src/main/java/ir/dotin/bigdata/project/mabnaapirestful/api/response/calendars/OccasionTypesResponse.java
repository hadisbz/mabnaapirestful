package ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class OccasionTypesResponse {
    @JsonProperty("data")
    private List<OccasionTypesInner> data;

    @Getter
    @ToString
    public static class OccasionTypesInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        @JsonProperty("meta")
        private MetaResponse meta;
    }
}