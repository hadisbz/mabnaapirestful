package ir.dotin.bigdata.project.mabnaapirestful.model.calendars;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.CalendarsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.calendars.OccasionTypesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    @Column(name = "calendar_id")
    private String calendarId;

    @Column(name = "occasion_type_id")
    private String occasionTypesId;

    private Integer year;

    private Integer month;

    private Integer day;

    private String notes;

    @Embedded
    private MetaModel metaModel;
}
