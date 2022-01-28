package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "reports")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReportsModel {
    @Id
    private String id;

    private String date;

    private String number;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "title_id")
    private String titleId;

    @Column(name = "fiscal_year")
    private String fiscalYear;

    @Column(name = "subtitles_id")
    private String subtitlesId;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "entity_type")
    private String entityType;


    @Embedded
    private MetaModel meta;

}
