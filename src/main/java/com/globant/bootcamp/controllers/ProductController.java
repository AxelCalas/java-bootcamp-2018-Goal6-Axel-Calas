package com.globant.bootcamp.controllers;

import com.globant.bootcamp.objects.Product;
import com.globant.bootcamp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path = "/products/show")
    List<Product> showAllProducts(){
        return productService.showAllProducts();
    }

    @GetMapping(path = "/products/show{product_id}")
    public Product showProduct(@PathVariable Long product_id){
        return productService.showProduct(product_id);
    }

    @PostMapping(path = "/products/new")
    Product createProduct(@RequestParam("brand") String brand,
                          @RequestParam("price") double price){
        Product product = new Product(brand, price);
        return productService.createProduct(product);
    }

    @DeleteMapping(path = "/products/delete{product_id}")
    String deleteProduct(@PathVariable Long product_id){
        return productService.deleteProduct(product_id);
    }

    @PostMapping(path = "/products/setPrice")
    Product setPrice(@RequestParam Long product_id,
                     @RequestParam double price){
        return productService.setPrice(product_id,price);
    }
}
