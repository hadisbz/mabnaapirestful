package ir.dotin.bigdata.project.mabnaapirestful.repository.calendars;

import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.CalendarsModel;
import ir.dotin.bigdata.project.mabnaapirestful.model.calendars.DatesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesRepository extends JpaRepository<DatesModel, Long> {

}
