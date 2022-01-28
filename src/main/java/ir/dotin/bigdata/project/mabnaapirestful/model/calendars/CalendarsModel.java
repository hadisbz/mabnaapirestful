package ir.dotin.bigdata.project.mabnaapirestful.model.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "calendars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarsModel {
    @Id
    private String id;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    @Embedded
    private MetaModel meta;
}
