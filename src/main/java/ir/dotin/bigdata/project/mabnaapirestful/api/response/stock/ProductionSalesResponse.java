package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.AnnouncementTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.FinancialViewTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ProductionSalesResponse {
    @JsonProperty("data")
    private List<ProductionSalesResponseInner> data;

    @Getter
    @ToString
    public static class ProductionSalesResponseInner {
        private String id;

        private CompaniesResponse.CompaniesResponseInner company;

        private ReportsResponse.ReportsResponseInner report;

        @JsonProperty("announcement_type")
        private AnnouncementTypeResponse announcementType;

        private String date;

        @JsonProperty("fiscal_year")
        private String fiscalYear;

        @JsonProperty("fiscal_period")
        private Long fiscalPeriod;

        @JsonProperty("is_audited")
        private Boolean isAudited;

        @JsonProperty("is_combined")
        private Boolean isCombined;

        @JsonProperty("is_represented")
        private Boolean isRepresented;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
