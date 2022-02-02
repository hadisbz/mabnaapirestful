package ir.dotin.bigdata.project.mabnaapirestful.repository.bonds;

import ir.dotin.bigdata.project.mabnaapirestful.model.bonds.InterestPaymentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestPaymentsRepository extends JpaRepository<InterestPaymentsModel, String> {
}
