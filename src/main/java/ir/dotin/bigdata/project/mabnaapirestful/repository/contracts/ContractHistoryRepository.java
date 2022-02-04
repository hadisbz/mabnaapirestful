package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractHistoryRepository extends JpaRepository<ContractHistoryModel,String>{
}
