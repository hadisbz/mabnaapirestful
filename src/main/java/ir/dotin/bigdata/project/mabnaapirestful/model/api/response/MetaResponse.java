package ir.dotin.bigdata.project.mabnaapirestful.model.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MetaResponse {
    private String type;
    private Long version;
    private String state;

    @JsonProperty("insert_date_time")
    private String insertDateTime;

    @JsonProperty("update_date_time")
    private String updateDateTime;

    @JsonProperty("delete_date_time")
    private String deleteDateTime;
}
