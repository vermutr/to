package service.menu.impl;

import entity.dessert.Dessert;
import entity.mainDish.MainDish;
import entity.menu.Menu;
import org.apache.commons.cli.CommandLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.MenuRepository;
import service.menu.MenuService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static config.OptionConstant.MEALS_OPT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuServiceImplTest {

    @Mock
    private MenuRepository menuRepository;

    @Mock
    private CommandLine commandLine;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private MenuService menuService;

    @BeforeEach
    public void setUp() {
        menuService = new MenuServiceImpl(menuRepository);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void getAllMenuTest() {
        when(menuRepository.findAll()).thenReturn(new Menu());

        Menu allMenu = menuService.getAllMenu();

        assertNotNull(allMenu);
        assertNull(allMenu.getCuisines());
        assertNull(allMenu.getDesserts());
        assertNull(allMenu.getMainDishes());
        assertNull(allMenu.getMealtimes());

    }

    @Test
    void getAllDessertsTest() {
        Menu menu = new Menu();
        menu.setDesserts(List.of(new Dessert("dessert", 12)));
        when(menuRepository.findAll()).thenReturn(menu);

        List<Dessert> allDesserts = menuService.getAllDesserts();

        assertNotNull(allDesserts);
        assertEquals(1, allDesserts.size());
        assertEquals(menu.getDesserts(), allDesserts);
    }

    @Test
    void getAllMainDishesTest() {
        Menu menu = new Menu();
        menu.setMainDishes(List.of(new MainDish("mainDish", 12)));
        when(menuRepository.findAll()).thenReturn(menu);

        List<MainDish> allMainDishes = menuService.getAllMainDishes();

        assertNotNull(allMainDishes);
        assertEquals(1, allMainDishes.size());
        assertEquals(menu.getMainDishes(), allMainDishes);
    }

    @Test
    void getAllMealtimeTest() {
        Menu menu = new Menu();
        menu.setMealtimes(List.of("lunch", "supper"));
        when(menuRepository.findAll()).thenReturn(menu);

        List<String> allMealtime = menuService.getAllMealtime();

        assertNotNull(allMealtime);
        assertEquals(2, allMealtime.size());
        assertEquals(menu.getMealtimes(), allMealtime);
    }

    @Test
    void getAllCuisinesTest() {
        Menu menu = new Menu();
        menu.setCuisines(List.of("French"));
        when(menuRepository.findAll()).thenReturn(menu);

        List<String> allCuisines = menuService.getAllCuisines();

        assertNotNull(allCuisines);
        assertEquals(1, allCuisines.size());
        assertEquals(menu.getCuisines(), allCuisines);
    }

    @Test
    void getDessertTest() {
        Menu menu = new Menu();
        menu.setDesserts(List.of(new Dessert("dessert", 12)));
        when(menuRepository.findAll()).thenReturn(menu);

        Dessert dessert = menuService.getDessert("dessert");

        assertNotNull(dessert);
        assertEquals("dessert", dessert.getName());
        assertEquals(12, dessert.getPrice());
    }


    @Test
    void getDessertInvalidNameTest() {
        Menu menu = new Menu();
        menu.setDesserts(List.of(new Dessert("dessert", 12)));
        when(menuRepository.findAll()).thenReturn(menu);

        Dessert dessert = menuService.getDessert("123");

        assertNull(dessert);
    }

    @Test
    void getMainDishTest() {
        Menu menu = new Menu();
        menu.setMainDishes(List.of(new MainDish("mainDish", 12)));
        when(menuRepository.findAll()).thenReturn(menu);

        MainDish mainDish = menuService.getMainDish("mainDish");

        assertNotNull(mainDish);
        assertEquals("mainDish", mainDish.getName());
        assertEquals(12, mainDish.getPrice());
    }

    @Test
    void getMainDishInvalidNameTest() {
        Menu menu = new Menu();
        menu.setMainDishes(List.of(new MainDish("mainDish", 12)));
        when(menuRepository.findAll()).thenReturn(menu);

        MainDish mainDish = menuService.getMainDish("123");

        assertNull(mainDish);
    }

    @Test
    void getCuisineTest() {
        Menu menu = new Menu();
        menu.setCuisines(List.of("French"));
        when(menuRepository.findAll()).thenReturn(menu);

        String french = menuService.getCuisine("French");

        assertNotNull(french);
        assertEquals("French", french);
    }


    @Test
    void getCuisineInvalidNameTest() {
        Menu menu = new Menu();
        menu.setCuisines(List.of("French"));
        when(menuRepository.findAll()).thenReturn(menu);

        String french = menuService.getCuisine("123");

        assertNull(french);
    }

    @Test
    void getMealtimeTest() {
        Menu menu = new Menu();
        menu.setMealtimes(List.of("lunch", "supper"));
        when(menuRepository.findAll()).thenReturn(menu);

        String supper = menuService.getMealtime("supper");

        assertNotNull(supper);
        assertEquals("supper", supper);
    }

    @Test
    void getMealtimeInvalidNameTest() {
        Menu menu = new Menu();
        menu.setMealtimes(List.of("lunch", "supper"));
        when(menuRepository.findAll()).thenReturn(menu);

        String supper = menuService.getMealtime("123");

        assertNull(supper);
    }

    @Test
    void printMenuTest() {
        Menu menu = new Menu();
        menu.setMainDishes(List.of(new MainDish("mainDish", 12)));

        when(menuRepository.findAll()).thenReturn(menu);
        when(commandLine.hasOption(MEALS_OPT)).thenReturn(true);

        menuService.printMenu(commandLine);

        assertEquals(
                "mainDish 12.0",
                outputStreamCaptor.toString().trim());
    }
}