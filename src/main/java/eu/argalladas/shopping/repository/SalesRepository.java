package eu.argalladas.shopping.repository;

import eu.argalladas.shopping.repository.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findAllByStartDateIsAfterAndEndDateIsBefore(LocalDate startDate, LocalDate endDate);
    // List<Product> findByApplicationDateAndProductIdAndChainId(LocalDate applicationDate, Long productId, Long chainId);
}