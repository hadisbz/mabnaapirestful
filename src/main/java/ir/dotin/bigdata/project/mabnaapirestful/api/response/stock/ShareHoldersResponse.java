package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class ShareHoldersResponse {
    @JsonProperty("data")
    private List<ShareHoldersResponseInner> data;

    @Getter
    @ToString
    public static class ShareHoldersResponseInner{
        private String id;

        private String date;

        private CompaniesResponse.CompaniesResponseInner company;

        private ReportsResponse.ReportsResponseInner report;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }

}
