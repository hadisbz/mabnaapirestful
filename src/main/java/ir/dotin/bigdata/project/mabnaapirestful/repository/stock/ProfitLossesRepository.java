package ir.dotin.bigdata.project.mabnaapirestful.repository.stock;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BalancesheetFieldsModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ProfitLossesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitLossesRepository extends JpaRepository<ProfitLossesModel, String>{
}
