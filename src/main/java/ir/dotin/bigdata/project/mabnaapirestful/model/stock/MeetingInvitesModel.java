package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.StatusResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.CompaniesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "meeting_invites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingInvitesModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="report_id")
    private String reportId;

    @Column(name="status_id")
    private String statusId;
    
    @Column(name="status_type")
    private String statusType;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="fiscal_year")
    private String fiscalYear;

    private String address;

    @Column(name="english_address")
    private String englishAddress;

    private String subject;

    @Column(name="english_subject")
    private String englishSubject;

    private String comments;

    @Column(name="english_comments")
    private String englishComments;

    @Embedded
    private MetaModel meta;
}
