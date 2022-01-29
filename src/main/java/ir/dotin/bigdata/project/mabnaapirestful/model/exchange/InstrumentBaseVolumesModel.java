package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "instrument_base_volumes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentBaseVolumesModel {
    @Id
    private String id;

    @Column(name="instrument_id")
    private String instrumentId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="base_volume")
    private Long baseVolume;

    @Embedded
    private MetaModel meta;

}
