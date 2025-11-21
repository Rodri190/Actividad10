package com.cellstore.model;

import com.cellstore.state.OrderState;
import com.cellstore.state.NewState;

/**
 * Representa una orden de venta simple.
 * Contiene un estado interno que determina su comportamiento (State pattern).
 */
public class Order {
    private final String orderId;
    private final String phoneId;
    private final int qty;
    private OrderState state;

    public Order(String orderId, String phoneId, int qty) {
        this.orderId = orderId;
        this.phoneId = phoneId;
        this.qty = qty;
        this.state = new NewState(); // estado inicial
    }

    public String getOrderId() { return orderId; }
    public String getPhoneId() { return phoneId; }
    public int getQty() { return qty; }

    // State pattern: delegación de comportamiento al objeto 'state'
    public void pay() { state.pay(this); }
    public void ship() { state.ship(this); }
    public void cancel() { state.cancel(this); }

    public void setState(OrderState s) { this.state = s; }
    public String getStateName() { return state.name(); }

    @Override
    public String toString() {
        return String.format("Order[%s] phone=%s qty=%d state=%s", orderId, phoneId, qty, getStateName());
    }
}
