package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "profit_loss_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfitLossItemsModel {
    @Id
    private String id;

    @Column(name="profit_loss_id")
    private String profitLossId;

    @Column(name = "field_id")
    private String fieldId;

    private Long value;

    @Embedded
    private MetaModel meta;
}
