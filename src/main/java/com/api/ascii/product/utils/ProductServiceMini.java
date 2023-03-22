package com.api.ascii.product.utils;

import com.api.ascii.product.ProductModel;
import com.api.ascii.product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class ProductServiceMini {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceMini(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void updateProduct(ProductModel product, Long productId) {

        ProductModel findProduct = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("Product with id " + productId + " does not exist"));

        if (product.getName() != null && product.getName().length() > 0
                && !Objects.equals(findProduct.getName(), product.getName())) {
            findProduct.setName(product.getName());
        }

        if (product.getPrice() == 0 && product.getBatch() != 0 && !Objects.equals(findProduct.getPrice(), product.getPrice())) {
            findProduct.setPrice(product.getPrice());
        }

        if (product.getBatch() != 0 && !Objects.equals(findProduct.getBatch(), product.getBatch())) {
            findProduct.setBatch(product.getBatch());
        }

        if (product.getDescription() != null && product.getDescription().length() > 0
                && !Objects.equals(findProduct.getDescription(), product.getDescription())) {
            findProduct.setDescription(product.getDescription());
        }

        if (product.getManufactureDate() != null && !Objects.equals(findProduct.getManufactureDate(), product.getManufactureDate())) {
            findProduct.setManufactureDate(product.getManufactureDate());
        }

        if (product.getExpirationDate() != null && !Objects.equals(findProduct.getExpirationDate(), product.getExpirationDate())) {
            findProduct.setExpirationDate(product.getExpirationDate());
        }

        if (product.getTotalCount() != 0 && !Objects.equals(findProduct.getTotalCount(), product.getTotalCount())) {
            findProduct.setTotalCount(product.getTotalCount());
        }
    }
}
