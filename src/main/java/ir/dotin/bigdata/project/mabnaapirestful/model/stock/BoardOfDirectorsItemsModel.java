package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "board_of_directors_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardOfDirectorsItemsModel {
    @Id
    private String id;

    @Column(name="board_of_directors_id")
    private String boardOfDirectorsId;

    @Column(name="director_id")
    private String directorId;

    @Column(name="position_id")
    private String positionId;

    @Column(name="agent_id")
    private String agentId;

    @Column(name="type_id")
    private String typeId;

    @Embedded
    private MetaModel meta;

}
