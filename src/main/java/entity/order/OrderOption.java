package entity.order;

import entity.dessert.Dessert;
import entity.mainDish.MainDish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderOption {

    private String cuisine;

    private String mealtime;

    private MainDish mainDish;

    private Dessert desert;

}
