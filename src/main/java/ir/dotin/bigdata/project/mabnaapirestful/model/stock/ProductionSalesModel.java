package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "production_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionSalesModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="report_id")
    private String reportId;

    private String date;

    @Column(name="fiscal_year")
    private String fiscalYear;

    @Column(name="fiscal_period")
    private Long fiscalPeriod;

    @Column(name="is_audited")
    private Boolean isAudited;

    @Column(name="is_combined")
    private Boolean isCombined;

    @Column(name="is_represented")
    private Boolean isRepresented;

    private String comments;

    @Column(name="english_comments")
    private String englishComments;

    @Embedded
    private MetaModel meta;

    @Embedded
    private AnnouncementTypeModel announcementTypeModel;

}
