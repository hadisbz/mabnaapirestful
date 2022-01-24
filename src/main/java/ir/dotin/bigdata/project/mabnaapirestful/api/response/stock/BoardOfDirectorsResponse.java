package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BoardOfDirectorsResponse {
    @JsonProperty("data")
    private List<BoardOfDirectorsResponseInner> data;

    @Getter
    @ToString
    public static class BoardOfDirectorsResponseInner {
        private String id;

        private CompaniesResponse.CompaniesResponseInner company;

        private MeetingsResponse.MeetingsResponseInner meeting;

        private ReportsResponse.ReportsResponseInner report;

        private String date;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        @JsonProperty("meta")
        private MetaResponse metaResponse;


    }
}
