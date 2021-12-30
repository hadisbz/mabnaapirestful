package ir.dotin.bigdata.project.mabnaapirestful.api.response.bond;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Value;

@Value
public class BondInterestPaymentsResponse {
    public String id;

    @JsonProperty("bond")
    public BondResponse bondResponse;

    @JsonProperty("start_date")
    public String startDate;

    @JsonProperty("end_date")
    public String endDate;

    public double interest;

    @JsonProperty("meta")
    public MetaResponse metaResponse;
}
