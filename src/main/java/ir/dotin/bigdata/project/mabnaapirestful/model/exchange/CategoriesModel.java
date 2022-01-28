package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesModel {
    @Id
    private String id;

    @Column(name="parent_id")
    private String parentId;

    @Column(name="parent_type")
    private String parentType;

    private String code;

    private String name;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "english_short_name")
    private String englishShortName;

    @Embedded
    private MetaModel meta;

}
