package ir.dotin.bigdata.project.mabnaapirestful.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.ProductionSaleTypeResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ProductionSaleItemsResponse {
    @JsonProperty("data")
    private List<ProductionSaleItemsResponseInner> data;

    @Getter
    @ToString
    public static class ProductionSaleItemsResponseInner {
        private String id;

        @JsonProperty("production_sale")
        private ProductionSalesResponse.ProductionSalesResponseInner productionSale;

        private ProductsResponse.ProductsResponseInner product;

        private UnitsResponse.UnitsResponseInner unit;

        @JsonProperty("production_count")
        private Double productionCount;

        @JsonProperty("sale_count")
        private Double sale_count;

        @JsonProperty("sale_amount")
        private Double saleAmount;

        private ProductionSaleTypeResponse type;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }
}
