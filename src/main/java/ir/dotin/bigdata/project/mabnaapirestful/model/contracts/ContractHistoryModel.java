package ir.dotin.bigdata.project.mabnaapirestful.model.contracts;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.MetaResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.contracts.ContractsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.api.response.exchange.ReportsResponse;
import ir.dotin.bigdata.project.mabnaapirestful.model.MetaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(schema = "public", name = "contract_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractHistoryModel {
    @Id
    private String id;

   @Column(name="contract_id")
    private String contractId;

   @Column(name="report_id")
    private String reportId;

   @Column(name="change_date")
    private String changeDate;

   @Column(name="exercise_price")
    private Double exercisePrice;

    @Embedded
    private MetaModel meta;

}
