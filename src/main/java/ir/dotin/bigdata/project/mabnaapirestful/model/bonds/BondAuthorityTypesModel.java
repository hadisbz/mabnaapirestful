package ir.dotin.bigdata.project.mabnaapirestful.model.bonds;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "bond_authority_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BondAuthorityTypesModel {
    @Id
    private String id;

    private String title;

    @Embedded
    private MetaModel meta;

}
