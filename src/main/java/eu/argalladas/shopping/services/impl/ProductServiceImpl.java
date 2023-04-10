package eu.argalladas.shopping.services.impl;

import eu.argalladas.shopping.domain.ProductDTO;
import eu.argalladas.shopping.repository.SalesRepository;
import eu.argalladas.shopping.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SalesRepository salesRepository;


    @Override
    public List<ProductDTO> getRates(LocalDate applicationDate, Long productId, Long chainId) {
        // List<Product> rates = rateRepository.findByApplicationDateAndProductIdAndChainId(applicationDate, productId, chainId);
        // return rates.stream().map(this::mapToDTO).collect(Collectors.toList());
        return new ArrayList<>();
    }

    /* private ProductDTO mapToDTO(Product rate) {
        return new ProductDTO(
                rate.getId(),
                rate.getStartDate(),
                rate.getEndDate(),
                rate.getPrice(),
        );
    } */
}