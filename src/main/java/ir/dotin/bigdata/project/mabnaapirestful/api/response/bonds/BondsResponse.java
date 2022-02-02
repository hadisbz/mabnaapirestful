package ir.dotin.bigdata.project.mabnaapirestful.api.response.bonds;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.NameResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.PaymentIntervalResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.TypeResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ExchangesResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class BondsResponse {
        @JsonProperty("data")
        private List<BondsResponseInner> data;

        @Getter
        @ToString
        public static class BondsResponseInner{
                private String id;

                private String name;

                @JsonProperty("short_name")
                private String shortName;

                @JsonProperty("issue_date")
                private String issueDate;

                @JsonProperty("mature_date")
                private String matureDate;

                @JsonProperty("underwriting_start_date")
                private String underwritingStartDate;

                @JsonProperty("underwriting_end_date")
                private String underwritingEndDate;

                @JsonProperty("nominal_price")
                private Double nominalPrice;

                @JsonProperty("interest_rate")
                private Double interestRate;

                @JsonProperty("payment_interval")
                private PaymentIntervalResponse paymentInterval;

                private String description;

                @JsonProperty("total_bonds")
                private Long totalBonds;

                @JsonProperty("trade_symbol")
                private String tradeSymbol;

                @JsonProperty("english_trade_symbol")
                private String englisheTradeSymbol;

                @JsonProperty("category_code")
                private String categoryCode;

                @JsonProperty("adjusted_rate")
                private Double adjustedRate;

                @JsonProperty("legislation_description")
                private String legislationDescription;

                @JsonProperty("ministry_approval_description")
                private String ministryApprovalDescription;

                @JsonProperty("guaranty_description")
                private String guarantyDescription;

                @JsonProperty("certificate_authority")
                private String certificateAuthority;

                @JsonProperty("bond_underwriting_type")
                private TypeResponse bondUnderwritingType;

                @JsonProperty("bond_coupon_type")
                private TypeResponse bondCouponType;

                private TypeResponse type;

                private ExchangesResponse.ExchangesResponseInner exchange;

                private NameResponse publisher;

                private NameResponse guarantor;

                @JsonProperty("certificate_type")
                private TypeResponse certificateType;

                @JsonProperty("meta")
                private MetaResponse metaResponse;


        }

}
