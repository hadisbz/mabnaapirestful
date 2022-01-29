package ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PercentageGroupsResponse {
    @JsonProperty("data")
    private List<PercentageGroupsResponseInner> data;

    @Getter
    @ToString
    public static class PercentageGroupsResponseInner {
        private String id;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        @JsonProperty("start_date")
        private  String startDate;

        @JsonProperty("end_date")
        private  String endDate;

        @JsonProperty("action_type")
        private PercentageActionTypesResponse.PercentageActionTypesResponseInner actionType;

        @JsonProperty("asset_type")
        private AssetTypesResponse.AssetTypesResponseInner assetType;

        private ExchangesResponse.ExchangesResponseInner exchange;

        private AssetsResponse.AssetsResponseInner asset;

        private CategoriesResponse.CategoriesResponseInner category;

        @JsonProperty("dealer_type")
        private PercentageDealerTypesResponse.PercentageDealerTypesResponseInner dealerType;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
