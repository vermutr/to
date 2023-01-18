package service.mealtime.impl;

import org.junit.jupiter.api.Test;
import service.mealtime.Mealtime;

import static org.junit.jupiter.api.Assertions.*;

class SupperMealtimeTest {

    private final Mealtime mealtime = new SupperMealtime();

    @Test
    void getMealTimeTest() {
        assertEquals("supper", mealtime.getMealTime());
    }
}