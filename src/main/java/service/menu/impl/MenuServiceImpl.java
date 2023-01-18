package service.menu.impl;

import entity.dessert.Dessert;
import entity.mainDish.MainDish;
import entity.menu.Menu;
import org.apache.commons.cli.CommandLine;
import repository.MenuRepository;
import service.menu.MenuService;

import java.util.List;
import java.util.function.Function;

import static config.OptionConstant.CUISINE_OPT;
import static config.OptionConstant.DESERTS_OPT;
import static config.OptionConstant.MEALS_OPT;
import static config.OptionConstant.MEALTIME_OPT;
import static config.OptionConstant.MENU_OPT;
import static java.lang.String.format;

public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @Override
    public Menu getAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public List<Dessert> getAllDesserts() {
        return menuRepository.findAll().getDesserts();
    }

    @Override
    public List<MainDish> getAllMainDishes() {
        return menuRepository.findAll().getMainDishes();
    }

    @Override
    public List<String> getAllMealtime() {
        return menuRepository.findAll().getMealtimes();
    }

    @Override
    public List<String> getAllCuisines() {
        return menuRepository.findAll().getCuisines();
    }

    @Override
    public Dessert getDessert(String dessertName) {
        return menuRepository.findAll().getDesserts()
                .stream()
                .filter(dessert -> dessert.getName().equals(dessertName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public MainDish getMainDish(String mainDishName) {
        return menuRepository.findAll().getMainDishes()
                .stream()
                .filter(mainDish -> mainDish.getName().equals(mainDishName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getCuisine(String cuisine) {
        return menuRepository.findAll().getCuisines()
                .stream()
                .filter(menuCuisine -> menuCuisine.equals(cuisine))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getMealtime(String mealtime) {
        return menuRepository.findAll().getMealtimes()
                .stream()
                .filter(menuMealtime -> menuMealtime.equals(mealtime))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void printMenu(CommandLine cmd) {
        if (cmd.hasOption(MEALS_OPT)) {
            printMainDishes();
        } else if (cmd.hasOption(DESERTS_OPT)) {
            printDesserts();
        } else if (cmd.hasOption(MEALTIME_OPT)) {
            printMealtime();
        } else if (cmd.hasOption(CUISINE_OPT)) {
            printCuisines();
        } else if (cmd.hasOption(MENU_OPT)) {
            printAllMenu();
        }
    }

    private void printMainDishes(){
        getAllMainDishes().stream().map(getMealDescription()).forEach(System.out::println);
    }

    private void printDesserts() {
        getAllDesserts().stream().map(getDessertDescription()).forEach(System.out::println);
    }

    private void printMealtime() {
        getAllMealtime().forEach(System.out::println);
    }

    private void printCuisines() {
        getAllCuisines().forEach(System.out::println);
    }

    private void printAllMenu(){
        System.out.println("Main Dishes:");
        printMainDishes();
        System.out.println("\nDesserts:");
        printDesserts();
        System.out.println("\nMealtime:");
        printMealtime();
        System.out.println("\nCuisines:");
        printCuisines();
    }

    private Function<Dessert, String> getDessertDescription() {
        return dessert -> format("%s %s", dessert.getName(), dessert.getPrice());
    }

    private Function<MainDish, String> getMealDescription() {
        return mainDish -> format("%s %s", mainDish.getName(), mainDish.getPrice());
    }

}
