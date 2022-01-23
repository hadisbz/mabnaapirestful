package ir.dotin.bigdata.project.mabnaapirestful.model.fund;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "dividend_payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DividendPaymentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    @Column(name="fund_id")
    private String fundID;

    private String date;
    private Double dividend;

    @Embedded
    private MetaModel meta;

}
