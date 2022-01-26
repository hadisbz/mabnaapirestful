package ir.dotin.bigdata.project.mabnaapirestful.api.response.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NameRespons {
    private String name;

    @JsonProperty("english_name")
    private String englishName;
}
