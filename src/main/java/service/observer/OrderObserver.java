package service.observer;

import entity.order.Order;

public interface OrderObserver {

    void addOrderObserver(Observer observer);

    void removeOrderObserver(Observer observer);

    void notifyOrderObservers(Order order);

}
