package com.api.ascii.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping(path = "/fetch-all")
    public List<ProductModel> getProducts() {
        return productService.getProducts();
    }

    @PostMapping(path = "/add")
    public String addProduct(@RequestBody ProductModel product) {
        productService.addProduct(product);
        String response = "{\"success\": true, \"message\": Product added successfully}";
        return response;
    }

    @GetMapping(path = "/fetch")
    public Optional<ProductModel> getSpecificProduct(@RequestParam(name = "productId", required = true) Long productId) {
        return productService.getSpecificProducts(productId);
    }

    @PutMapping(path = "/update/{productId}")
    public String updateProduct(@RequestBody ProductModel product, @PathVariable("productId") Long productId) {
        productService.updateProduct(product, productId);
        String response = "{\"success\": true, \"message\": Product updated successfully}";
        return response;
    }

    @DeleteMapping(path = "/delete/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
         productService.deleteProduct(productId);
        return "product deleted";
    }
}
