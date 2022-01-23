package ir.dotin.bigdata.project.mabnaapirestful.model.fund;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.EntityResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.fund.FundsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    private String id;

    @Column(name="fund_id")
    private String fundId;

    private String date;

    private Integer rating;

    @Column(name="rating_period")
    private Integer ratingPeriod;

    @Column(name="credit_rater_id")
    private String creditRaterID;

    @Column(name="credit_rater_type")
    private String creditRaterType;

    @Column(name="publish_date")
    private String publishDate;

    @Embedded
    private MetaModel meta;
}

