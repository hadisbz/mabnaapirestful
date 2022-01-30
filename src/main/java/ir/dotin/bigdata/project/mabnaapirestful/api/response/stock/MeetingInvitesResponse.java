package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.StatusResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString

public class MeetingInvitesResponse {
    @JsonProperty("data")
    private List<MeetingInvitesResponseInner> data;

    @Getter
    @ToString
    public static class MeetingInvitesResponseInner {
        private String id;

        private CompaniesResponse.CompaniesResponseInner company;

        private ReportsResponse.ReportsResponseInner report;

        private StatusResponse status;

        @JsonProperty("date_time")
        private String dateTime;

        @JsonProperty("fiscal_year")
        private String fiscalYear;

        private String address;

        @JsonProperty("english_address")
        private String englishAddress;

        private String subject;

        @JsonProperty("english_subject")
        private String englishSubject;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
