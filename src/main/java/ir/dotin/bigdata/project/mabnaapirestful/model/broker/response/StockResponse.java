package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock.CompaniesResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StockResponse {
    @JsonProperty("company")
    private CompaniesResponse.CompaniesResponseInner company;

}
