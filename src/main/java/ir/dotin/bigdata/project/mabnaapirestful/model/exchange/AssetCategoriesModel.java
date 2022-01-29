package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "asset_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class AssetCategoriesModel {
    @Id
    private String id;

    @Column(name="asset_id")
    private String assetId;

    @Column(name="category_id")
    private String categoryId;

    @Embedded
    private MetaModel meta;

}
