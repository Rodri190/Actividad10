package com.cellstore.state;

import com.cellstore.model.Order;

public class NewState implements OrderState {
    @Override public String name() { return "NEW"; }

    @Override
    public void pay(Order order) {
        System.out.println("Pago recibido. Transitando NEW -> PAID");
        order.setState(new PaidState());
    }

    @Override
    public void ship(Order order) {
        System.out.println("No se puede enviar: la orden no está pagada.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Orden cancelada. NEW -> CANCELLED");
        order.setState(new CancelledState());
    }
}
