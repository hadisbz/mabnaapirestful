package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CompanyContactInfosResponse {
    @JsonProperty("data")
    private List<CompanyContactInfosResponseInner> data;

    @Getter
    @ToString
    public static class CompanyContactInfosResponseInner {
        private CompaniesResponse.CompaniesResponseInner company;

        private CompanyContactInfoTypesResponse.CompanyContactInfoTypesResponseInner type;

        private String title;

        @JsonProperty("english_title")
        private String englishTitle;

        private String address;

        @JsonProperty("english_address")
        private String englishAddress;

        private String telephone;

        private String fax;

        private String email;

        private String website;

        private String id;

        private String comments;

        @JsonProperty("english_comments")
        private String englishComments;

        @JsonProperty("po_box")
        private  String poBox;

        @JsonProperty("postal_code")
        private String postalCode;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
