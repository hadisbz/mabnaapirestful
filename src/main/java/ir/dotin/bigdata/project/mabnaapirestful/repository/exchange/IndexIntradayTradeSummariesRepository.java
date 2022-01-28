package ir.dotin.bigdata.project.mabnaapirestful.repository.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.IndexIntradayTradeSummariesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexIntradayTradeSummariesRepository extends JpaRepository<IndexIntradayTradeSummariesModel, String> {
}
