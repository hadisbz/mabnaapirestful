package ir.dotin.bigdata.project.mabnaapirestful.model.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "dates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatesModel {
    @Id
    private String id;

    @Column(name = "calendar_id")
    private String calendarId;

    @Column(name = "occasion_type_id")
    private String occasionTypesId;

    private Long year;

    private Long month;

    private Long day;

    private String notes;

    @Embedded
    private MetaModel metaModel;
}
