package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.AnnouncementTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.FinancialViewTypeModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "epses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpsesModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="meeting_id")
    private String meetingId;

    @Column(name="report_id")
    private String reportId;

    @Column(name="announcement_type")
    private String announcementType;

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

    private Long capital;

    @Column(name="impure_realized_eps")
    private Long impureRealizedEps;

    @Column(name="pure_realized_eps")
    private Long pureRealizedEps;

    @Column(name="impure_dps")
    private Long impureDps;

    @Column(name="pure_dps")
    private Long pureDps;

    @Column(name="impure_forecast_eps")
    private Long impureForecastEps;

    @Column(name="pure_forecast_eps")
    private Long pureForecastEps;


    @Embedded
    private MetaModel meta;


}
