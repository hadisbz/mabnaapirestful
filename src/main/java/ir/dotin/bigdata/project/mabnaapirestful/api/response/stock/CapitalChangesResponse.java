package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.security.PrivateKey;
import java.util.List;

@Getter
@ToString
public class CapitalChangesResponse {
    @JsonProperty("data")
    private List<CapitalChangesResponseInner> data;

    @Getter
    @ToString
    public static class CapitalChangesResponseInner {
        private String id;

        private CompaniesResponse.CompaniesResponseInner company;

        private ReportsResponse.ReportsResponseInner report;

        private String date;

        private MeetingsResponse.MeetingsResponseInner meeting;

        @JsonProperty("previous_capital")
        private Long previousCapital;

        @JsonProperty("new_capital")
        private Long newCapital;

        @JsonProperty("contribution_percent")
        private Double contributionPercent;

        @JsonProperty("reserve_percent")
        private Double reservePercent;

        @JsonProperty("premium_percent")
        private Double premiumPercent;

        @JsonProperty("underwriting_end_report")
        private ReportsResponse.ReportsResponseInner underwritingEndReport;

        @JsonProperty("underwriting_end_date")
        private String underwritingEndDate;

        @JsonProperty("registration_report")
        private ReportsResponse.ReportsResponseInner registrationReport;

        @JsonProperty("registration_date")
        private String registrationDate;

        @JsonProperty("stock_certificate_receive_report")
        private ReportsResponse.ReportsResponseInner stockCertificateReceiveReport;

        @JsonProperty("stock_certificate_receive_date")
        private String stockCertificateReceiveDate;

        @JsonProperty("warrant_sell_date")
        private String warrantSellDate;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
