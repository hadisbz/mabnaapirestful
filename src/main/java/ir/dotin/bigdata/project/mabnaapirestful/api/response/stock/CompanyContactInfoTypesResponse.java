package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString

public class CompanyContactInfoTypesResponse {
    @JsonProperty("data")
    private List<CompanyContactInfoTypesResponseInner> data;

    @Getter
    @ToString
    public static class CompanyContactInfoTypesResponseInner {

        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
