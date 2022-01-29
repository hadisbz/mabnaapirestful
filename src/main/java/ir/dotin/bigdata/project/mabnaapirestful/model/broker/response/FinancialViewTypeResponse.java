package ir.dotin.bigdata.project.mabnaapirestful.model.broker.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FinancialViewTypeResponse {
    private String id;

    private String title;

    @JsonProperty("english_title")
    private String englishTitle;

    @JsonProperty("meta")
    private MetaResponse metaResponse;
}
