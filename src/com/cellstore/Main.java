package com.cellstore;

import com.cellstore.dao.*;
import com.cellstore.model.*;
import com.cellstore.service.*;

import java.util.List;
import java.util.Scanner;

/**
 * CLI para interactuar con el módulo de ventas de celulares.
 */
public class Main {
    public static void main(String[] args) {
        CellPhoneDAO dao = new InMemoryCellPhoneDAO();
        InventoryService inventory = new InventoryService(dao); 
        SalesService sales = new SalesService(inventory);

        // Poblar inventario de ejemplo
        inventory.addPhone(new CellPhone("01", "iphone", "13 pro", 399.99, 5));
        inventory.addPhone(new CellPhone("02", "xaomi", "note 14", 299.99, 3));
        inventory.addPhone(new CellPhone("03", "samsung", "a 51", 199.99, 10));

        Scanner sc = new Scanner(System.in);
        printHelp();
        while (true) {
            System.out.print("\n> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();
            try {
                switch (cmd) {
                    case "list": {
                        List<CellPhone> all = inventory.listPhones();
                        all.forEach(System.out::println);
                        break;
                    }
                    case "create": {
                        // create <orderId> <phoneId> <qty>
                        if (parts.length < 4) { System.out.println("Uso: create <orderId> <phoneId> <qty>"); break; }
                        String oid = parts[1], pid = parts[2];
                        int q = Integer.parseInt(parts[3]);
                        sales.createOrder(oid, pid, q);
                        break;
                    }
                    case "orders": {
                        sales.listOrders().forEach(System.out::println);
                        break;
                    }
                    case "pay": {
                        if (parts.length<2) { System.out.println("Uso: pay <orderId>"); break; }
                        sales.payOrder(parts[1]); break;
                    }
                    case "ship": {
                        if (parts.length<2) { System.out.println("Uso: ship <orderId>"); break; }
                        sales.shipOrder(parts[1]); break;
                    }
                    case "cancel": {
                        if (parts.length<2) { System.out.println("Uso: cancel <orderId>"); break; }
                        sales.cancelOrder(parts[1]); break;
                    }
                    case "exit": {
                        System.out.println("Saliendo..."); sc.close(); return;
                    }
                    default:
                        System.out.println("Comando desconocido. Escribe 'help'.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printHelp() {
        System.out.println("COMANDOS:");
        System.out.println("  list                   - lista productos en inventario");
        System.out.println("  create <id> <pid> <q>  - crea orden (reserva stock)");
        System.out.println("  orders                 - lista órdenes");
        System.out.println("  pay <orderId>          - pagar orden (NEW -> PAID)");
        System.out.println("  ship <orderId>         - enviar orden (PAID -> SHIPPED)");
        System.out.println("  cancel <orderId>       - cancelar orden");
        System.out.println("  exit                   - salir");
    }
}
