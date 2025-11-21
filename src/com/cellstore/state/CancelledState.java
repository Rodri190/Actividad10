package com.cellstore.state;

import com.cellstore.model.Order;

public class CancelledState implements OrderState {
    @Override public String name() { return "CANCELLED"; }

    @Override
    public void pay(Order order) {
        System.out.println("No se puede pagar: la orden fue cancelada.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("No se puede enviar: la orden fue cancelada.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("La orden ya está cancelada.");
    }
}
