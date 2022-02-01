package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "balancesheet_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalancesheetItemsModel {
    @Id
    private String id;

    @Column(name="balance_sheet_id")
    private String balanceSheetId;

    @Column(name="field_id")
    private String fieldId;

    private Double value;

    @Embedded
    private MetaModel meta;


}
