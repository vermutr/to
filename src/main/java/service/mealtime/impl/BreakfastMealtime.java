package service.mealtime.impl;

import service.mealtime.Mealtime;

public class BreakfastMealtime implements Mealtime {

    @Override
    public String getMealTime() {
        return "breakfast";
    }
}
