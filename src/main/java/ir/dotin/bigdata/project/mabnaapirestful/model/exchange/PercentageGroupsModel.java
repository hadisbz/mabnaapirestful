package ir.dotin.bigdata.project.mabnaapirestful.model.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "percentage_groups")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PercentageGroupsModel {
    @Id
    private String id;
    private String title;

    @Column(name="english_title")
    private String englishTitle;

    @Column(name="start_date")
    private  String startDate;

    @Column(name="end_date")
    private  String endDate;

    @Column(name="action_type_id")
    private String actionTypeId;

    @Column(name="asset_type_id")
    private String assetTypeId;

    @Column(name="exchange_id")
    private String exchangeId;

    @Column(name="asset_id")
    private String assetId;

    @Column(name="category_id")
    private String categoryId;

    @Column(name="dealer_type_id")
    private String dealerTypeId;

    @Embedded
    private MetaModel meta;


}
