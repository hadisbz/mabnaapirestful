package ir.dotin.bigdata.project.mabnaapirestful.repository.fund;

import ir.dotin.bigdata.project.mabnaapirestful.model.fund.RatingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<RatingsModel, Long>{
}
