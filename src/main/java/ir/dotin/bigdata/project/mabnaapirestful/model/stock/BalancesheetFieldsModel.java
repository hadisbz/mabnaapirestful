package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name = "balancesheet_fields")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalancesheetFieldsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    private String title;

    @Column(name = "english_title")
    private String englishTitle;

    private String account;

    private Integer index;

    @Embedded
    private MetaModel meta;

}
