package ir.dotin.bigdata.project.mabnaapirestful.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "occasion_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OccasionTypesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localId;

    private String id;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    @Embedded
    private MetaModel meta;
}
