package ir.dotin.bigdata.project.mabnaapirestful.repository.exchange;

import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.AssetsModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.ReportImagesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportImagesRepository extends JpaRepository<ReportImagesModel, String>{
}
