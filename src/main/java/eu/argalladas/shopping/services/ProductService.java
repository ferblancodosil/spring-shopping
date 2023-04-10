package eu.argalladas.shopping.services;

import eu.argalladas.shopping.domain.ProductDTO;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getRates(LocalDate applicationDate, Long productId, Long chainId);
}
