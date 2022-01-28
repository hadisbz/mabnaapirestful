package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "theoretical_opening_prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheoreticalOpeningPricesModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    private Integer price;

    @Embedded
    private MetaModel meta;
}
