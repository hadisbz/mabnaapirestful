package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "instrument_static_thresholds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentStaticThresholdsModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="min_price_permit")
    private  Long minPricePermit;

    @Column(name="max_price_permit")
    private Long maxPricePermit;

    @Embedded
    private MetaModel meta;

}
