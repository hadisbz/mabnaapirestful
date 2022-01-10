package ir.dotin.bigdata.project.mabnaapirestful.repository.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.model.exchange.SourcesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourcesRepository extends JpaRepository<SourcesModel, Long> {

}
