package repository.impl;

import config.CLIConfiguration;
import entity.menu.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryFileMenuRepositoryTest {

    @Test
    void findAllTest() {
        CLIConfiguration cliConfiguration = new CLIConfiguration();
        Menu menu = cliConfiguration.loadMenuFromDisk();

        assertEquals("Menu(mainDishes=[MainDish(name=PizzaMargherita, price=12.21), " +
                "MainDish(name=Tacos, price=12.32), MainDish(name=Bigos, price=12.33)], " +
                "desserts=[Dessert(name=Cake, price=11.53), Dessert(name=Cookies, price=10.11), " +
                "Dessert(name=Chocolates and Candies, price=13.44)], " +
                "mealtimes=[breakfast, lunch, supper], cuisines=[Italian, French])", menu.toString());

    }

}