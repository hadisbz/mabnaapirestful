package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "percentage_action_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PercentageActionTypesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    @Embedded
    private MetaModel meta;
}
