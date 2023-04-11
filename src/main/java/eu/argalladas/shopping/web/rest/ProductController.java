package eu.argalladas.shopping.web.rest;

import eu.argalladas.shopping.domain.ProductDTO;
import eu.argalladas.shopping.services.ProductService;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/sales")
    @ApiOperation(value = "Get a sales by params", notes = "Returns a sales list as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(name = "startDate", value = "Start date to search", defaultValue = "2023-01-25") LocalDate startDate) {

        List<ProductDTO> products = new ArrayList<>(); // productService.getProducts(startDate);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
}
