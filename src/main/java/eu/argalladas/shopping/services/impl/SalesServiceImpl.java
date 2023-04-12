package eu.argalladas.shopping.services.impl;

import eu.argalladas.shopping.domain.SalesDTO;
import eu.argalladas.shopping.repository.SalesRepository;
import eu.argalladas.shopping.repository.model.Brand;
import eu.argalladas.shopping.repository.model.Product;
import eu.argalladas.shopping.repository.model.Sales;
import eu.argalladas.shopping.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;


    @Override
    public Optional<SalesDTO> findSale(LocalDateTime date, Long productId, Long brandId) {
        Optional<Sales> sales = salesRepository.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductAndBrandOrderByPriorityDesc(date, date, new Product(productId), new Brand(brandId));
        return Optional.ofNullable(sales.isPresent() ? mapToDTO(sales.get()) : null);
    }
    private SalesDTO mapToDTO(Sales sale) {
        SalesDTO saleDto = new SalesDTO();
        if (sale != null) {
            saleDto.setBrand(sale.getBrand().getBrandId());
            saleDto.setCurrency(sale.getCurrency());
            saleDto.setEndDate(sale.getEndDate());
            saleDto.setStartDate(sale.getStartDate());
            saleDto.setProduct(sale.getProduct().getProductId());
            saleDto.setPrice(sale.getPrice());
            saleDto.setPriceList(sale.getPriceList().getPriceId());
        }
        return saleDto;
    }
}