package ir.dotin.bigdata.project.mabnaapirestful.repository.contracts.stock;
import ir.dotin.bigdata.project.mabnaapirestful.model.stock.ShareHoldersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareHoldersRepository extends JpaRepository<ShareHoldersModel, String>{
}
