package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

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
    private String id;

    private String date;

    private String number;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "title_id")
    private String titleId;

    @Column(name = "fiscal_year")
    private String fiscalYear;

    @JoinTable(name = "report_subtitle_join_table")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ReportSubTitlesModel> subtitles;

    @Column(name = "entity_id")
    private String entityId;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "entity_type")
    private String entityType;

    @JoinTable(name="report_image_join_table")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ReportImagesModel> images;

    @Embedded
    private MetaModel meta;

}
