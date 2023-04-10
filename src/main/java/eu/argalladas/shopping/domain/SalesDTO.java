package eu.argalladas.shopping.domain;

import java.time.LocalDate;

public class SalesDTO {
    private ProductDTO product;
    private BrandDTO brand;
    private PriceListDTO priceList;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
    private String currency;
}
