package ir.dotin.bigdata.project.mabnaapirestful.model.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class FreeFloatsResponse {
    @JsonProperty("data")
    private List<FreeFloatsResponseInner> data;

    @Getter
    @ToString
    public static class FreeFloatsResponseInner{
        private String id;

        private String date;

        private CompaniesResponse.CompaniesResponseInner company;

        private double percent;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
