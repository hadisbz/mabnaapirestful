package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "instrument_group_states")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrumentGroupStatesModel {
    @Id
    private String id;

    @Column(name="group_id")
    private String groupId;

    @Column(name="type_id")
    private String typeId;

    @Column(name="date_time")
    private String dateTime;

    @Embedded
    private MetaModel meta;


}
