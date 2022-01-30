package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.AnnouncementTypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class EpsesResponse {
    @JsonProperty("data")
    private List<EpsesResponseInner> data;

    @Getter
    @ToString
    public static class EpsesResponseInner{
        private String id;

        private CompaniesResponse.CompaniesResponseInner company;

        private MeetingsResponse.MeetingsResponseInner meeting;

        private ReportsResponse.ReportsResponseInner report;

        @JsonProperty("announcement_type")
        private String announcementType;

        private String date;

        @JsonProperty("fiscal_year")
        private String fiscalYear;

        @JsonProperty("fiscal_period")
        private Integer fiscalPeriod;

        @JsonProperty("is_audited")
        private Boolean isAudited;

        @JsonProperty("is_combined")
        private Boolean isCombined;

        @JsonProperty("is_represented")
        private Boolean isRepresented;

        private Long capital;

        @JsonProperty("impure_realized_eps")
        private Long impureRealizedEps;

        @JsonProperty("pure_realized_eps")
        private Long pureRealizedEps;

        @JsonProperty("impure_dps")
        private Long impureDps;

        @JsonProperty("pure_dps")
        private Long pureDps;

        @JsonProperty("impure_forecast_eps")
        private Long impureForecastEps;

        @JsonProperty("pure_forecast_eps")
        private Long pureForecastEps;

        @JsonProperty("meta")
        private MetaResponse metaResponse;


    }




}
