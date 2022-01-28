package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "percentage_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PercentageValuesModel {
    @Id
    private String id;

    @Column(name="percentage_group_id")
    private String percentageGroupId;

    @Column(name = "percentage_id")
    private String percentageId;

    private Double value;

    private Double min;

    private Double max;

    @Embedded
    private MetaModel meta;
}
