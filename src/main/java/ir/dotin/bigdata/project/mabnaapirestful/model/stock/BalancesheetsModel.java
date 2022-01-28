package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "balancesheets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalancesheetsModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="meeting_id")
    private String meetingId;

    @Column(name="report_id")
    private String reportId;

    @Column(name="announcement_type_id")
    private String announcementTypeID;

    @Column(name="announcement_type_title")
    private String announcementTypeTitle;

    @Column(name="announcement_type_english_title")
    private String announcementTypeEnglishTitle;

    @Column(name="announcement_type_meta_type")
    private String announcementTypeMetaType;


    @Column(name="financial_view_type_id")
    private String financialViewTypeID;

    @Column(name="financial_view_type_title")
    private String financialViewTypeTitle;

    @Column(name="financial_view_type_english_title")
    private String financialViewTypeEnglishTitle;

    @Column(name="financial_view_type_meta_type")
    private String financialViewTypeMetaType;

    private String date;

    @Column(name="fiscal_year")
    private String fiscalYear;

    @Column(name="fiscal_period")
    private Integer fiscalPeriod;

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
}
