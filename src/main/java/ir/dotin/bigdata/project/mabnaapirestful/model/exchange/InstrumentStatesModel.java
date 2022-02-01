package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "instrument_states")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InstrumentStatesModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    private String date;

    @Column(name="instrument_state_type_id")
    private String instrumentStateTypeId;

    @Column(name="instrument_state_type_meta_type")
    private String instrumentStateTypeMetaType;

    @Column(name="instrument_state_state_id")
    private String instrumentStateStateId;

    @Column(name="instrument_state_state_meta_type")
    private String instrumentStateStateMetaType;

    @Embedded
    private MetaModel meta;

}
