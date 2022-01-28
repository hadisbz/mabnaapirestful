package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "index_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexValuesModel {
    @Id
    private String id;

    @Column(name = "index_id")
    private String indexId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name = "close_value")
    private Double closeValue;

    @Column(name = "close_value_change")
    private Double closeValueChange;

    @Column(name = "open_value")
    private Double openValue;

    @Column(name = "low_value")
    private Double lowValue;

    @Column(name= "high_value")
    private  Double highValue;

    @Embedded
    private MetaModel metaModel;

}
