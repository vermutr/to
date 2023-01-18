package service.mealtime.impl;

import org.junit.jupiter.api.Test;
import service.mealtime.Mealtime;

import static org.junit.jupiter.api.Assertions.*;

class BreakfastMealtimeTest {

    private final Mealtime mealtime = new BreakfastMealtime();

    @Test
    void getMealTimeTest() {
        assertEquals("breakfast", mealtime.getMealTime());
    }
}