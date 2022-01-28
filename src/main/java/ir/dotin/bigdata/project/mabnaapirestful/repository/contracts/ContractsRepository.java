package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts;

import ir.dotin.bigdata.project.mabnaapirestful.model.contracts.ContractsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractsRepository  extends JpaRepository<ContractsModel, String>{
}
