package ir.dotin.bigdata.project.mabnaapirestful.repository.broker;

import ir.dotin.bigdata.project.mabnaapirestful.model.broker.BrokersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokersRepository extends JpaRepository<BrokersModel, Long>{
}
