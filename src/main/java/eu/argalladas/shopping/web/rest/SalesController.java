package eu.argalladas.shopping.web.rest;

import eu.argalladas.shopping.domain.SalesDTO;
import eu.argalladas.shopping.services.SalesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/sales")
    @ApiOperation(value = "Get a sales by params", notes = "Returns a sales list as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found element in this search")
    })
    public ResponseEntity<SalesDTO> getSales(@RequestParam(value = "date", required=true) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") @ApiParam(name = "date", value = "Date to search", defaultValue = "2020-06-14T00:00:00") LocalDateTime date,
                                                     @RequestParam(value = "productId", required=true) @ApiParam(name = "productId", value = "ProductId to search", defaultValue = "35455") Long productId,
                                                     @RequestParam(value = "brandId", required=true) @ApiParam(name = "brandId", value = "brandId to search", defaultValue = "1") Long brandId) {

        Optional<SalesDTO> sale = salesService.findSale(date, productId, brandId); // productService.getProducts(startDate);
        if (!sale.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sale.get());
    }
}
