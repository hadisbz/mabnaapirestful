package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "index_instruments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndexInstrumentsModel {
    @Id
    private String id;

    private String indexId;

    private String instrumentId;

    @Embedded
    private MetaModel meta;
}
