package ir.dotin.bigdata.project.mabnaapirestful.repository.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.PercentageActionTypesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentageActionTypesRepository extends JpaRepository<PercentageActionTypesModel, String> {
}
