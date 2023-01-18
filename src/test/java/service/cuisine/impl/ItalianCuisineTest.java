package service.cuisine.impl;

import entity.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.mealtime.impl.BreakfastMealtime;
import service.mealtime.impl.LunchMealtime;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ItalianCuisineTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void prepareOrderTest() {
        Order order = Order.OrderBuilder.builder()
                .mainDish("mainDish")
                .desert("dessert")
                .price(12.13)
                .build();
        ItalianCuisine italianCuisine = new ItalianCuisine(new LunchMealtime());

        italianCuisine.prepareOrder(order);

        assertEquals(
                "We are starting to prepare your Italian lunch: Main dish=mainDish, Desert='dessert, Price=12.13",
                outputStreamCaptor.toString().trim());
    }
}