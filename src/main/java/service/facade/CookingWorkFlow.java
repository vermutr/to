package service.facade;

import config.exception.CuisineNotFoundException;
import config.exception.DessertNotFoundException;
import config.exception.MainDishNotFoundException;
import config.exception.MealtimeNotFoundException;
import entity.dessert.Dessert;
import entity.mainDish.MainDish;
import service.cuisine.Cuisine;
import service.cuisine.impl.ItalianCuisine;
import service.cuisine.impl.FrenchCuisine;
import entity.order.Order;
import entity.order.OrderOption;
import service.mealtime.Mealtime;
import service.mealtime.impl.BreakfastMealtime;
import service.mealtime.impl.LunchMealtime;
import service.mealtime.impl.SupperMealtime;
import service.menu.MenuService;
import service.observer.Observer;
import service.observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//Facade
public class CookingWorkFlow implements OrderObserver {

    private final List<Observer> subscribers = new ArrayList<>();

    private final MenuService menuService;

    public CookingWorkFlow(MenuService menuService) {
        this.menuService = menuService;
    }

    public void preparingAndCookingOrder(OrderOption orderOption) {
        Mealtime mealtime = configureMealTime(orderOption.getMealtime());
        Cuisine cuisine = configureCuisine(orderOption.getCuisine(), mealtime);
        Order order = Order.OrderBuilder.builder()
                .mainDish(orderOption.getMainDish().getName())
                .desert(orderOption.getDesert().getName())
                .price(orderOption.getDesert().getPrice() + orderOption.getMainDish().getPrice())
                .build();
        notifyOrderObservers(order);
        cuisine.prepareOrder(order);
    }

    public OrderOption configureOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MainDish: ");
        String mainDish = scanner.nextLine();
        MainDish menuMainDish = Optional.ofNullable(menuService.getMainDish(mainDish))
                .orElseThrow(() -> new MainDishNotFoundException("Meal not found. Set '-m' argument for print menu"));

        System.out.println("Dessert: ");
        String dessert = scanner.nextLine();
        Dessert menuDessert = Optional.ofNullable(menuService.getDessert(dessert))
                .orElseThrow(() -> new DessertNotFoundException("Dessert not found. Set '-m' argument for print menu"));


        System.out.println("Mealtime: ");
        String mealtime = scanner.nextLine();
        Optional.ofNullable(menuService.getMealtime(mealtime))
                .orElseThrow(() -> new MealtimeNotFoundException("Mealtime not found. Set '-m' argument for print menu"));

        System.out.println("Cuisine: ");
        String cuisine = scanner.nextLine();
        Optional.ofNullable(menuService.getCuisine(cuisine))
                .orElseThrow(() -> new CuisineNotFoundException("Cuisine not found. Set '-m' argument for print menu"));

        scanner.close();
        return new OrderOption(cuisine, mealtime, menuMainDish, menuDessert);
    }

    //Strategy
    private Mealtime configureMealTime(String mealtimeOption) {
        if("breakfast".equals(mealtimeOption)) {
            return new BreakfastMealtime();
        } else if ("lunch".equals(mealtimeOption)) {
            return new LunchMealtime();
        } else {
            return  new SupperMealtime();
        }
    }

    //Strategy
    private Cuisine configureCuisine(String cuisineOption, Mealtime mealtime) {
        if("French".equals(cuisineOption)) {
            return new FrenchCuisine(mealtime);
        } else {
            return new ItalianCuisine(mealtime);
        }
    }

    @Override
    public void addOrderObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeOrderObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyOrderObservers(Order order) {
        for (Observer subscriber: subscribers) {
            subscriber.handleOrderEvent(order);
        }
    }
}
