package com.globant.bootcamp.services;

import com.globant.bootcamp.objects.Product;
import com.globant.bootcamp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> showAllProducts(){
        return productRepository.findAll();
    }

    public Product showProduct(Long product_id){
        return productRepository.findById(product_id).get();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public String deleteProduct(Long product_id){
        Optional optional = productRepository.findById(product_id);
        if(optional.isPresent()){
            productRepository.deleteById(product_id);
            return "Deleted";
        } else {
            return "Not find";
        }
    }

    public Product setPrice(Long product_id,double price){
        Product product = productRepository.findById(product_id).get();
        product.setPrice(price);
        return productRepository.save(product);
    }
}
