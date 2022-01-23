package ir.dotin.bigdata.project.mabnaapirestful.model.api.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.api.response.exchange.CategoriesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CompanyCategoriesResponse {
    @JsonProperty("data")
    private List<CompanyCategoriesResponseInner> data;


    @Getter
    @ToString
    public static class CompanyCategoriesResponseInner{
        private String id;

        private CompaniesResponse.CompaniesResponseInner company;

        private CategoriesResponse.CategoriesResponseInner category;

        @JsonProperty("meta")
        private MetaResponse metaResponse;

    }
}
