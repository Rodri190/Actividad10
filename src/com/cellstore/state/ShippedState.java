package com.cellstore.state;

import com.cellstore.model.Order;

/**
 * Estado "Shipped" (enviado).
 */
public class ShippedState implements OrderState {
    @Override public String name() { return "SHIPPED"; }

    @Override
    public void pay(Order order) {
        System.out.println("La orden ya fue pagada y enviada.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("La orden ya ha sido enviada.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("No se puede cancelar: ya fue enviada.");
    }
}
