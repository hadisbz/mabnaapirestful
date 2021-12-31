package ir.dotin.bigdata.project.mabnaapirestful.api.response.calenders;
import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import lombok.Getter;
@Getter
public class DatesResponse {
    private String id;

    @JsonProperty("calendar")
    private CalendarsResponse calendarsResponse;

    @JsonProperty("occasion_type")
    private OccasionTypesResponse occasionTypesResponse;

    private int year;

    private int month;

    private  int day;

    private String notes;

    @JsonProperty("meta")
    private MetaResponse metaResponse;



}
