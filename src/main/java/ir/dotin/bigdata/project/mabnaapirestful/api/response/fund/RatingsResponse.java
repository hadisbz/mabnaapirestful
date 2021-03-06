package ir.dotin.bigdata.project.mabnaapirestful.api.response.fund;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class RatingsResponse {
    @JsonProperty("data")
    private List<RatingsResponseInner> data;

    @Getter
    @ToString
    public static class RatingsResponseInner {
        private String id;

        private FundsResponse.FundsResponseInner fund;

        private String date;

        private Long rating;

        @JsonProperty("rating_period")
        private Long ratingPeriod;

        @JsonProperty("credit_rater")
        private EntityResponse creditRater;

        @JsonProperty("publish_date")
        private String publishDate;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
