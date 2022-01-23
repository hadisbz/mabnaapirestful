package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name = "reports")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReportsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

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
