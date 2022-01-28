package ir.dotin.bigdata.project.mabnaapirestful.repository.fund;

import ir.dotin.bigdata.project.mabnaapirestful.model.fund.FundValuesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundValuesRepository extends JpaRepository<FundValuesModel, String>{
}
