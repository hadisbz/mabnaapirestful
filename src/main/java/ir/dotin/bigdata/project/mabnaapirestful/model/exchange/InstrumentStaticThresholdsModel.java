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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="min_price_permit")
    private  Integer minPricePermit;

    @Column(name="max_price_permit")
    private Integer maxPricePermit;

    @Embedded
    private MetaModel meta;

}
