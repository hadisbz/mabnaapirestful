package ir.dotin.bigdata.project.mabnaapirestful.repository.stock;

import ir.dotin.bigdata.project.mabnaapirestful.model.stock.BoardOfDirectorsItemsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardOfDirectorsItemsRepository extends JpaRepository<BoardOfDirectorsItemsModel, String>{
}
