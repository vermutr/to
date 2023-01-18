package service.observer;

import entity.order.Order;

//Observer
public interface Observer {

    void handleOrderEvent(Order order);

}
