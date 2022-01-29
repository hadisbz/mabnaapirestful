package ir.dotin.bigdata.project.mabnaapirestful.model.stock;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "cash_flow_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashFlowItemsModel {
    @Id
    private String id;

    @Column(name="cash_flow_id")
    private String cashFlowId;

    @Column(name = "field_id")
    private String fieldId;

    private Long value;

    @Embedded
    private MetaModel meta;
}
