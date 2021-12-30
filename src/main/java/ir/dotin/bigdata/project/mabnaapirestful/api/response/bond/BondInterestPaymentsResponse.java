package ir.dotin.bigdata.project.mabnaapirestful.api.response.bond;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;

@Getter
public class BondInterestPaymentsResponse {
    @JsonProperty("bond")
    private BondResponse bondResponse;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("end_date")
    private String endDate;

    private Double interest;

    private String id;

    @JsonProperty("meta")
    private MetaResponse metaResponse;
}
