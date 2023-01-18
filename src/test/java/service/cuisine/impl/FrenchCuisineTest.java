package service.cuisine.impl;

import entity.order.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.mealtime.Mealtime;
import service.mealtime.impl.BreakfastMealtime;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class FrenchCuisineTest {

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
        FrenchCuisine frenchCuisine = new FrenchCuisine(new BreakfastMealtime());

        frenchCuisine.prepareOrder(order);

        assertEquals(
                "We are starting to prepare your French breakfast: Main dish=mainDish, Desert='dessert, Price=12.13",
                outputStreamCaptor.toString().trim());
    }
}