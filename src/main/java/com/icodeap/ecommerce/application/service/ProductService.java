package com.icodeap.ecommerce.application.service;

import com.icodeap.ecommerce.application.repository.ProductRepository;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.User;

import java.time.LocalDateTime;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public Iterable <Product> getProducts(){
        return productRepository.getProducts();

    }
    public Iterable<Product> getProductByUser(User user){
        return productRepository.getProductsByUser(user);

    }
    public Product getProductByUser (Integer id){
     return productRepository.getProductById(id);

    }
    public void saveProduct(Product product){
        User user= new User();
        user.setId(1);
        product.setDateCreated(LocalDateTime.now());
        product.setDateUpdate(LocalDateTime.now());
        product.setUser(user);
        productRepository.saveProduct(product);

    }
    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }
}
