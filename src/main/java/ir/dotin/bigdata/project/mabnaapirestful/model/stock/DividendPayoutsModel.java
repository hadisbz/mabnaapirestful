package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "dividend_payouts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DividendPayoutsModel {
    @Id
    private String id;

    @Column(name="meeting_id")
    private String meetingId;

    @Column(name="report_id")
    private String reportId;

    private String date;

    @Column(name="announcement_date")
    private String announcementDate;

    @Embedded
    private MetaModel meta;
}
