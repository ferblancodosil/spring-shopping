package eu.argalladas.shopping.repository;

import eu.argalladas.shopping.repository.model.Brand;
import eu.argalladas.shopping.repository.model.Product;
import eu.argalladas.shopping.repository.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    Optional<Sales> findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductAndBrandOrderByPriorityDesc(LocalDateTime startDate, LocalDateTime endDate, Product productId, Brand brandId);

}