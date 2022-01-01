package ir.dotin.bigdata.project.mabnaapirestful.api.response.calenders;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;

@Getter
public class CalendarsResponse {
    private String id;

    private String title;

    @JsonProperty("english_title")
    private String englishTitle;

    @JsonProperty("meta")
    private MetaResponse metaResponse;
}
