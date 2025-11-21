package com.cellstore.state;

import com.cellstore.model.Order;

/**
 * Patrón State (Comportamiento):
 * - Interfaz común para los estados de una orden.
 * - Cada estado encapsula comportamiento asociado.
 * - Permite cambiar el comportamiento de Order sin usar grandes condicionales.
 *
 * Basado en la descripción del documento (páginas 66–68): "permite que un objeto modifique
 * su comportamiento cada vez que cambie su estado interno".
 */
public interface OrderState {
    String name();
    void pay(Order order);
    void ship(Order order);
    void cancel(Order order);
}
