package ir.dotin.bigdata.project.mabnaapirestful.repository.mortgageLoans;

import ir.dotin.bigdata.project.mabnaapirestful.model.mortgageLoans.MortgageLoansModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageLoansRepository extends JpaRepository<MortgageLoansModel, String> {
}
