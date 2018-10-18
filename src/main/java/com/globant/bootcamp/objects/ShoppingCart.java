package com.globant.bootcamp.objects;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "Carts")
public class ShoppingCart{
    private @Id @GeneratedValue Long cart_id;
    private Long cartUser_id;
    private ArrayList<Long> products;
    private double amountToPay;

    public ShoppingCart(Long cartUser_id){
        this.cartUser_id = cartUser_id;
        products = new ArrayList<>();
    }

    public ArrayList<Long> getProducts() {
        return products;
    }

    public ArrayList<Long> setProducts(ArrayList<Long> products) {
        return this.products = products;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public double getAmountToPay() {
        return amountToPay;
    }
}
