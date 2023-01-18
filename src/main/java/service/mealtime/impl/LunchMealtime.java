package service.mealtime.impl;

import service.mealtime.Mealtime;

public class LunchMealtime implements Mealtime {

    @Override
    public String getMealTime() {
        return "lunch";
    }
}
