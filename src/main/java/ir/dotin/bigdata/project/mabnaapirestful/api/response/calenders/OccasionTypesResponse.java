package ir.dotin.bigdata.project.mabnaapirestful.api.response.calenders;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class OccasionTypesResponse {
    private String id;

    private String title;

    @JsonProperty("english_title")
    private String englishTitle;

    @JsonProperty("meta")
    private MetaResponse meta;
}