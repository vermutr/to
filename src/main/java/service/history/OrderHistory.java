package service.history;

import entity.order.Order;
import service.observer.Observer;

import java.util.ArrayList;
import java.util.List;

//Singleton
public class OrderHistory implements Observer {

    private static final OrderHistory orderHistory = new OrderHistory();
    private final List<Order> orders = new ArrayList<>();


    private OrderHistory() {

    }

    public static OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void handleOrderEvent(Order order) {
        addOrder(order);
        System.out.println("Order added to Order History");
    }
}
