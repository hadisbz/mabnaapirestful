package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.ParentResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CategoriesResponse {
    @JsonProperty("data")
    private List<CategoriesResponseInner> data;

    @Getter
    @ToString
    public static class CategoriesResponseInner{
        private String id;

        private ParentResponse parent;

        private String code;

        private String name;

        @JsonProperty("english_name")
        private String englishName;

        @JsonProperty("short_name")
        private String shortName;

        @JsonProperty("english_short_name")
        private String englishShortName;

        @JsonProperty("meta")
        private MetaResponse metaResponse;


    }

}
