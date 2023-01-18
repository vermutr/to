package entity.menu;


import entity.dessert.Dessert;
import entity.mainDish.MainDish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private List<MainDish> mainDishes;

    private List<Dessert> desserts;

    private List<String> mealtimes;

    private List<String> cuisines;

}
