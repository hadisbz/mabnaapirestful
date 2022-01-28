package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "asset_types")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssetTypesModel {
    @Id
    private String id;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    private String code;

    @Embedded
    private MetaModel meta;
}
