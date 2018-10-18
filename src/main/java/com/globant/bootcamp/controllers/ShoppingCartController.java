package com.globant.bootcamp.controllers;

import com.globant.bootcamp.objects.ShoppingCart;
import com.globant.bootcamp.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping(path = "/shoppingCart/show")
    List<ShoppingCart> showAllShoppingCarts(){
        return shoppingCartService.showAllShoppingCarts();
    }

    @GetMapping(path = "/shoppingCart/show{cart_id}")
    ShoppingCart showShoppingCart(@PathVariable Long cart_id){
        return shoppingCartService.showShoppingCart(cart_id);
    }

    @PostMapping(path = "/shoppingCart/new{user_id}")
    ShoppingCart createShoppingCart(@PathVariable Long user_id){
        ShoppingCart shoppingCart = new ShoppingCart(user_id);
        return shoppingCartService.createShoppingCart(shoppingCart);
    }

    @DeleteMapping(path = "/shoppingCart/delete{cart_id}")
    String deleteShoppingCart(@PathVariable Long cart_id){
        return shoppingCartService.deleteShoppingCart(cart_id);
    }

    @PostMapping(path = "/shoppingCart/addProduct")
    ShoppingCart addProductToCart(@RequestParam ("cart_id") Long cart_id,
                                  @RequestParam ("product_id") Long product_id,
                                  @RequestParam ("price") double price){
        return null; //shoppingCartService.addProductToCart(cart_id,product_id,price);
    }
}
