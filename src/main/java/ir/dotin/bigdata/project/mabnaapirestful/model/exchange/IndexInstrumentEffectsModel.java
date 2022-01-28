package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "index_instrument_effects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexInstrumentEffectsModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="index_id")
    private String indexId;

    @Column(name="date_time")
    private String dateTime;

    private Double effect;


    @Embedded
    private MetaModel meta;
}
