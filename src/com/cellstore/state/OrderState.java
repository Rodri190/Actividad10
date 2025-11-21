package com.cellstore.state;

import com.cellstore.model.Order;

/**
 * Patrón State (Comportamiento):
 */
public interface OrderState {
    String name();
    void pay(Order order);
    void ship(Order order);
    void cancel(Order order);
}
