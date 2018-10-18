package com.globant.bootcamp.services;

import com.globant.bootcamp.controllers.ProductController;
import com.globant.bootcamp.controllers.ShoppingCartController;
import com.globant.bootcamp.objects.Product;
import com.globant.bootcamp.objects.ShoppingCart;
import com.globant.bootcamp.objects.User;
import com.globant.bootcamp.repositories.ProductRepository;
import com.globant.bootcamp.repositories.ShoppingCartRepository;
import com.globant.bootcamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShoppingCartService {
    private ShoppingCartRepository shoppCartRepositoy;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppCartRepositoy){
        this.shoppCartRepositoy = shoppCartRepositoy;
    }

    public List<ShoppingCart> showAllShoppingCarts(){
        return shoppCartRepositoy.findAll();
    }

    public ShoppingCart showShoppingCart(Long cart_id){
        return shoppCartRepositoy.findById(cart_id).get();
    }

    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart){
        return shoppCartRepositoy.save(shoppingCart);
    }

    public String deleteShoppingCart(Long cart_id){
        Optional optional = shoppCartRepositoy.findById(cart_id);
        if(optional.isPresent()){
            shoppCartRepositoy.deleteById(cart_id);
            return "Deleted";
        } else {
            return "Not find";
        }
    }

    public ShoppingCart addProductToCart(Long cart_id, Long product_id, double price){
        ShoppingCart shoppingCart = shoppCartRepositoy.findById(cart_id).get();
        ArrayList<Long> products = shoppingCart.getProducts();
        products.add(product_id);
        shoppingCart.setProducts(products);
        shoppingCart.setAmountToPay(shoppingCart.getAmountToPay() + price);
        return shoppCartRepositoy.save(shoppingCart);
    }

}
