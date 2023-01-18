package service.cuisine.impl;

import service.cuisine.Cuisine;
import entity.order.Order;
import service.mealtime.Mealtime;

public class FrenchCuisine implements Cuisine {


    private final Mealtime mealtime;


    public FrenchCuisine(Mealtime mealtime) {
        this.mealtime = mealtime;
    }


    @Override
    public void prepareOrder(Order order) {
        System.out.println(
                String.format("We are starting to prepare your French %s: %s", mealtime.getMealTime(), order.toString())
        );
    }
}
