package com.cellstore.state;

import com.cellstore.model.Order;

/**
 * Estado "Paid" (pagada).
 */
public class PaidState implements OrderState {
    @Override public String name() { return "PAID"; }

    @Override
    public void pay(Order order) {
        System.out.println("La orden ya está pagada.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("Orden enviada. PAID -> SHIPPED");
        order.setState(new ShippedState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cancelando orden pagada. PAID -> CANCELLED (reembolso manual requerido)");
        order.setState(new CancelledState());
    }
}
