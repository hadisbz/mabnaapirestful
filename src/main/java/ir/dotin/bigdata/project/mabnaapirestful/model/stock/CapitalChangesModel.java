package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "capital_changes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapitalChangesModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="report_id")
    private String reportId;

    private String date;

    @Column(name = "meeting_id")
    private String meetingId;

    @Column(name ="previous_capital")
    private Long previousCapital;

    @Column(name ="new_capital")
    private Long newCapital;

    @Column(name ="contribution_percent")
    private Double contributionPercent;

    @Column(name ="reserve_percent")
    private Double reservePercent;

    @Column(name ="premium_percent")
    private Double premiumPercent;

    @Column(name ="underwriting_end_report_id")
    private String underwritingEndReportId;

    @Column(name ="underwriting_end_date")
    private String underwritingEndDate;

    @Column(name ="registration_report_id")
    private String registrationReportId;

    @Column(name ="registration_date")
    private String registrationDate;

    @Column(name ="stock_certificate_receive_report_id")
    private String stockCertificateReceiveReportId;

    @Column(name ="stock_certificate_receive_date")
    private String stockCertificateReceiveDate;

    @Column(name ="warrant_sell_date")
    private String warrantSellDate;

    private String comments;

    @Column(name ="english_comments")
    private String englishComments;

    @Embedded
    private MetaModel meta;


}
