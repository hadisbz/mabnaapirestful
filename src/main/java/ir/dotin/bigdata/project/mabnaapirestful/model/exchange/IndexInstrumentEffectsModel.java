package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.IndexesResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.InstrumentsResponse;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

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
