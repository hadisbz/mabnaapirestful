package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "index_intraday_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexIntradayValuesModel {
    @Id
    private String id;

    @Column(name="index_value_id")
    private String indexValueId;

    @Column(name = "index_id")
    private String indexId;

    @Column(name="date_time")
    private String dateTime;

    @Column(name = "close_value")
    private Double closeValue;



    @Embedded
    private MetaModel metaModel;

}
