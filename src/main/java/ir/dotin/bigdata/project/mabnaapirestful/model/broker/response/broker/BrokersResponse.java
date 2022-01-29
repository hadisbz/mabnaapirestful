package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.broker;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.broker.response.ParentResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class BrokersResponse {
    @JsonProperty("data")
    private List<BrokersResponseInner> data;

    @Getter
    @ToString
    public static class BrokersResponseInner {
        private String id;

        private String code;

        private String name;

        @JsonProperty("english_name")
        private String englishName;

        @JsonProperty("short_name")
        private String shortName;

        @JsonProperty("english_short_name")
        private String englishShortName;

       private ParentResponse parent;

       @JsonProperty("bic_code")
       private String bicCode;

       @JsonProperty("trade_code")
       private String tradeCode;

       @JsonProperty("nsc_code")
       private String nscCode;

        @JsonProperty("meta")
        private MetaResponse metaResponse;
    }

}
