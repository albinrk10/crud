package com.example.crud.product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Controlador
@RestController
@RequestMapping(path = "api/v1/products")
@Tag(name="Apis Rest")
public class ProductController {

    //Inyeccion de dependencia
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "get product")
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @Operation(summary = "post product")
    @PostMapping
    //para la solicitud requestBody
    public ResponseEntity<Object> registrarProducto(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }
    @Operation(summary = "put product")
    @PutMapping
    //para la solicitud requestBody
    public ResponseEntity<Object> actualizarProducto(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }
    @Operation(summary = "delete product")
    @DeleteMapping(path = "{productId}")
    //para la solicitud requestBody
    public ResponseEntity<Object> eliminar(@PathVariable("productId") Long id) {
        return this.productService.deleteproduct(id);
    }


}
