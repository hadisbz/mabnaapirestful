package ir.dotin.bigdata.project.mabnaapirestful.repository.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BoardOfDirectorsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardOfDirectorsRepository extends JpaRepository<BoardOfDirectorsModel, String>{
}
