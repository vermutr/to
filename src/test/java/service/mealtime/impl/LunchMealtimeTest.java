package service.mealtime.impl;

import org.junit.jupiter.api.Test;
import service.mealtime.Mealtime;

import static org.junit.jupiter.api.Assertions.*;

class LunchMealtimeTest {

    private final Mealtime mealtime = new LunchMealtime();

    @Test
    void getMealTimeTest() {
        assertEquals("lunch", mealtime.getMealTime());
    }
}