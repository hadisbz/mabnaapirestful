package ir.dotin.bigdata.project.mabnaapirestful.repository.calendar;

import ir.dotin.bigdata.project.mabnaapirestful.model.OccasionTypesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccasionTypesRepository extends JpaRepository<OccasionTypesModel, Long> {

}
