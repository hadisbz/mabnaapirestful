package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "meetings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeetingsModel {
    @Id
    private String id;

    @Column(name="company_id")
    private String companyId;

    @Column(name="report_id")
    private String reportId;

    @Column(name="meeting_type_id")
    private String meetingTypeId;


    private String date;

    @Column(name="fiscal_year")
    private String fiscalYear;

    @Embedded
    private MetaModel meta;


}
