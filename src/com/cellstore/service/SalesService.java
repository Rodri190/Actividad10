package com.cellstore.service;

import com.cellstore.model.Order;
import com.cellstore.model.CellPhone;
import java.util.*;
public class SalesService {
    private final InventoryService inventory;
    private final Map<String, Order> orders = new LinkedHashMap<>();

    public SalesService(InventoryService inventory) {
        this.inventory = inventory; // inyectado
    }

    public Order createOrder(String orderId, String phoneId, int qty) {
        CellPhone phone = inventory.findPhone(phoneId);
        if (phone == null) {
            System.out.println("Producto no existe: " + phoneId);
            return null;
        }
        if (phone.getStock() < qty) {
            System.out.println("Stock insuficiente para " + phoneId);
            return null;
        }
        boolean ok = inventory.reduceStock(phoneId, qty);
        if (!ok) {
            System.out.println("No se pudo reservar stock.");
            return null;
        }
        Order o = new Order(orderId, phoneId, qty);
        orders.put(orderId, o);
        System.out.println("Orden creada: " + o);
        return o;
    }

    public Order findOrder(String orderId) { return orders.get(orderId); }

    public Collection<Order> listOrders() { return orders.values(); }

    public void payOrder(String orderId) {
        Order o = orders.get(orderId);
        if (o == null) { System.out.println("Orden no encontrada."); return; }
        o.pay();
    }

    public void shipOrder(String orderId) {
        Order o = orders.get(orderId);
        if (o == null) { System.out.println("Orden no encontrada."); return; }
        o.ship();
    }

    public void cancelOrder(String orderId) {
        Order o = orders.get(orderId);
        if (o == null) { System.out.println("Orden no encontrada."); return; }
        o.cancel();
    }
}
