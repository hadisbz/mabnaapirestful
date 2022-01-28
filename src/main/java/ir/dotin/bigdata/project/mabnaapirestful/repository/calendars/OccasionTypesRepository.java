package ir.dotin.bigdata.project.mabnaapirestful.repository.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.OccasionTypesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccasionTypesRepository extends JpaRepository<OccasionTypesModel, String> {

}
