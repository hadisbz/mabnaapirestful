package ir.dotin.bigdata.project.mabnaapirestful.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MetaResponse {
    Long version;
    String state;

    @JsonProperty("insert_date_time")
    String insertDateTime;

    @JsonProperty("update_date_time")
    String updateDateTime;

    @JsonProperty("delete_date_time")
    String deleteDateTime;

    @JsonProperty("type")
    String type;
}
