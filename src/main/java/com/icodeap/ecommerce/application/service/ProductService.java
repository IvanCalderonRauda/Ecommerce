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
    public Product getProductById (Integer id){
     return productRepository.getProductById(id);

    }
    public Product saveProduct(Product product){
        System.out.println("ANTES DEL REPOSITORY: " + product);

        Product result = productRepository.saveProduct(product);

        System.out.println("DESPUÉS DEL REPOSITORY: " + result);
        System.out.println("ID RESULTADO: " + result.getId());

        System.out.println("ID PRODUCT ORIGINAL: " + product.getId());

        return result;
    }
       /* if(product.getId()==null){
            User user = new User();
            user.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
        }else{
            Product productDB= productRepository.getProductById(product.getId());
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
        }
        return productRepository.saveProduct(product);
*/


    public void deleteProductById(Integer id){
        productRepository.deleteProductById(id);
    }
}

