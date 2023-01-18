package service.menu;

import entity.dessert.Dessert;
import entity.mainDish.MainDish;
import entity.menu.Menu;
import org.apache.commons.cli.CommandLine;

import java.util.List;

public interface MenuService  {

    Menu getAllMenu();

    List<Dessert> getAllDesserts();

    List<MainDish> getAllMainDishes();

    List<String> getAllMealtime();

    List<String> getAllCuisines();

    Dessert getDessert(String dessertName);

    MainDish getMainDish(String mainDishName);

    String getCuisine(String cuisine);

    String getMealtime(String mealtime);

    void printMenu(CommandLine cmd);
}
