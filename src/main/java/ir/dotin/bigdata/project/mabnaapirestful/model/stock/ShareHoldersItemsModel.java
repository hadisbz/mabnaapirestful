package ir.dotin.bigdata.project.mabnaapirestful.model.stock;

import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.stock.ShareHoldersResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "share_holders_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareHoldersItemsModel {
    @Id
    private String id;

    @Column(name="shareholder_id")
    private String shareholderId;

    @Column(name = "entity_id")
    private String entityId;

    private Double percentage;

    @Embedded
    private MetaModel meta;
}
