package com.api.ascii.product;

import com.api.ascii.exception.ApiRequestException;
import com.api.ascii.product.utils.ProductServiceMini;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductServiceMini productServiceMini;

    Optional<ProductModel> product;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductServiceMini productServiceMini) {
        this.productRepository = productRepository;
        this.productServiceMini = productServiceMini;
    }

    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(ProductModel product) {
        if(product.getName() == null || product.getBatch() == 0 ||
                product.getDescription() == null || product.getTotalCount() == 0 ||
                product.getExpirationDate() == null || product.getManufactureDate() == null) {
                    throw new ApiRequestException("All fields are required and must not be 0");
        }

        productRepository.save(product);
    }

    public Optional<ProductModel> getSpecificProducts(Long productId) {
        boolean exists = productRepository.existsById(productId);

        if(exists) {
            product = productRepository.findById(productId);
        } else {
            throw new ApiRequestException("Product with id " + productId + " does not exist");
        }
        return product;
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);

        if(exists) {
            productRepository.deleteById(productId);
        } else {
            throw new ApiRequestException("Product with id " + productId + " does not exist");
        }
    }

    @Transactional
    public void updateProduct(ProductModel product, Long productId) {
        if(product.getName() == null && product.getBatch() == 0 &&
                product.getDescription() == null && product.getTotalCount() == 0 &&
                product.getExpirationDate() == null && product.getManufactureDate() == null) {
            throw new ApiRequestException("One of the fields must be updated");
        }

        productServiceMini.updateProduct(product, productId);
    }
}
