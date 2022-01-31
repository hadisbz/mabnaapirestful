package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "units")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitsModel {
    @Id
    private String id;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    private String factor;

    private String baseId;

    private String baseType;

    @Embedded
    private MetaModel meta;

}
