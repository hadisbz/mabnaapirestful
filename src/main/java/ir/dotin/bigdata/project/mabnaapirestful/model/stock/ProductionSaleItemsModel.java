package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.ProductionSaleTypeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "production_sale_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionSaleItemsModel {
    @Id
    private String id;

    @Column(name="production_sale_id")
    private String productionSaleId;

    @Column(name="product_id")
    private String productId;

    @Column(name="unit_id")
    private String unitId;

    @Column(name="production_count")
    private Double productionCount;

    @Column(name="sale_count")
    private Double sale_count;

    @Column(name="sale_amount")
    private Double saleAmount;

    @Embedded
    private ProductionSaleTypeModel typeModel;

    @Embedded
    private MetaModel meta;

}
