package ir.dotin.bigdata.project.mabnaapirestful.model.bonds;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "interest_payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestPaymentsModel {
    @Id
    private String id;

    @Column(name="bond_id")
    private String bondId;

    @Column(name="start_date")
    private String startDate;

    @Column(name="end_date")
    private String endDate;

    private Double interest;

    @Embedded
    private MetaModel meta;

}
