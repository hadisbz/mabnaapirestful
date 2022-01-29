package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ProfitLossItemsResponse {
    @JsonProperty("data")
    private List<ProfitLossItemsResponseInner> data;

    @Getter
    @ToString
    public static class ProfitLossItemsResponseInner {
        private String id;

        @JsonProperty("profit_loss")
        private ProfitLossesResponse.ProfitLossesResponseInner profitLoss;

        private ProfitlossFieldsResponse.ProfitlossFieldsResponseInner field;

        private Long value;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
