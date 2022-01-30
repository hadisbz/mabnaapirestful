package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.stock.EpsesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpsesRepository extends JpaRepository<EpsesModel, String> {
}
