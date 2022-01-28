package ir.dotin.bigdata.project.mabnaapirestful.repository.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetTypesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetTypesRepository extends JpaRepository<AssetTypesModel, String> {

}

