package service.facade;

import entity.dessert.Dessert;
import entity.mainDish.MainDish;
import entity.order.OrderOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.menu.MenuService;
import service.menu.impl.MenuServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CookingWorkFlowTest {

    @Mock
    private MenuService menuService;

    private CookingWorkFlow cookingWorkFlow;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        cookingWorkFlow = new CookingWorkFlow(menuService);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void preparingAndCookingOrder() {
        MainDish mainDish = new MainDish("mainDish", 10);
        Dessert dessert = new Dessert("dessert", 5);
        OrderOption orderOption = new OrderOption("French", "breakfast", mainDish, dessert);

        cookingWorkFlow.preparingAndCookingOrder(orderOption);

        assertEquals(
                "We are starting to prepare your French breakfast: Main dish=mainDish, Desert='dessert, Price=15.0",
                outputStreamCaptor.toString().trim());
    }

}