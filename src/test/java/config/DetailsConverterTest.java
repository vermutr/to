package config;

import entity.menu.Menu;
import org.junit.jupiter.api.Test;

import java.io.Reader;

import static config.DetailsConverter.parseFile;
import static org.junit.jupiter.api.Assertions.*;

class DetailsConverterTest {


    @Test
    void parseFiletTest() {
        Reader reader = parseFile();

        assertNotNull(reader);
    }

    @Test
    void fromJsonTest() {
        Menu menu = DetailsConverter.fromJson(parseFile(), Menu.class);

        assertEquals("Menu(mainDishes=[MainDish(name=PizzaMargherita, price=12.21), " +
                "MainDish(name=Tacos, price=12.32), MainDish(name=Bigos, price=12.33)], " +
                "desserts=[Dessert(name=Cake, price=11.53), Dessert(name=Cookies, price=10.11), " +
                "Dessert(name=Chocolates and Candies, price=13.44)], " +
                "mealtimes=[breakfast, lunch, supper], cuisines=[Italian, French])", menu.toString());
    }
}