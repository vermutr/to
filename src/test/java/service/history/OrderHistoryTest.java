package service.history;

import entity.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderHistoryTest {

    private final OrderHistory orderHistory = OrderHistory.getOrderHistory();

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getOrderHistoryTest() {
        assertEquals(OrderHistory.getOrderHistory(), orderHistory);
    }

    @Test
    void addOrderTest() {
        Order order = Order.OrderBuilder.builder()
                .mainDish("mainDish")
                .desert("dessert")
                .price(12.13)
                .build();

        orderHistory.addOrder(order);

        assertTrue(orderHistory.getOrders().contains(order));
    }

    @Test
    void getOrdersTest() {
        Order order = Order.OrderBuilder.builder()
                .mainDish("mainDish")
                .desert("dessert")
                .price(12.13)
                .build();
        orderHistory.addOrder(order);

        assertTrue(orderHistory.getOrders().contains(order));
    }

    @Test
    void handleOrderEventTest() {
        Order order = Order.OrderBuilder.builder()
                .mainDish("mainDish")
                .desert("dessert")
                .price(12.13)
                .build();

        orderHistory.handleOrderEvent(order);

        assertEquals(
                "Order added to Order History",
                outputStreamCaptor.toString().trim());
        assertTrue(orderHistory.getOrders().contains(order));
    }

}