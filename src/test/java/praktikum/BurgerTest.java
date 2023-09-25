package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun topBun;
    @Mock
    Ingredient superSause;
    @Mock
    Ingredient superMeatBalls;


    @Test
    public void addIngredientTest(){
        Burger testBurger = new Burger();
        testBurger.addIngredient(superSause);
        assertEquals(1, testBurger.ingredients.size());

    }

    @Test
    public void removeIngredientTest(){

        Burger testBurger = new Burger();
        testBurger.addIngredient(superSause);
        testBurger.removeIngredient(0);
        assertEquals(0, testBurger.ingredients.size());
    }

    @Test
    public void moveIngredientTest(){

        Burger testBurger = new Burger();
        testBurger.addIngredient(superSause);
        testBurger.addIngredient(superMeatBalls);

        int oldIndexSuperSause = testBurger.ingredients.indexOf(superSause);
        int oldIndexSuperMeatBalls = testBurger.ingredients.indexOf(superMeatBalls);

        testBurger.moveIngredient(0,1);

        int newIndexOfSuperSause = testBurger.ingredients.indexOf(superSause);
        int newIndexSuperMeatBalls = testBurger.ingredients.indexOf(superMeatBalls);

        assertEquals(oldIndexSuperSause,newIndexSuperMeatBalls);
        assertEquals(oldIndexSuperMeatBalls,newIndexOfSuperSause);

    }

    @Test
    public void getPriceTest(){
        float bunPrice = 9.99F;
        float superSausePrice = 1.99F;
        float superMeatBallsPrice = 3.99F;

        float sumPrice = bunPrice * 2 + superSausePrice + superMeatBallsPrice;


        Burger testBurger = new Burger();

        Mockito.when(topBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(superSause.getPrice()).thenReturn(superSausePrice);
        Mockito.when(superMeatBalls.getPrice()).thenReturn(superMeatBallsPrice);

        testBurger.setBuns(topBun);
        testBurger.addIngredient(superSause);
        testBurger.addIngredient(superMeatBalls);
        testBurger.getPrice();


        assertEquals(String.format("%s", sumPrice), String.format("%s",(testBurger.getPrice())));


    }

    @Test
    public void getReceiptTest(){
        float bunPrice = 9.99F;
        float superSausePrice = 1.99F;
        float superMeatBallsPrice = 3.99F;
        String bunName = "TopBun";
        String superSauseName = "SuperSause";
        String superMeatBallsName = "SuperMeatBalls";

        float sumPrice = bunPrice * 2 + superSausePrice + superMeatBallsPrice;

        Burger testBurger = new Burger();
        testBurger.setBuns(topBun);
        testBurger.addIngredient(superSause);
        testBurger.addIngredient(superMeatBalls);


        Mockito.when(topBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(superSause.getPrice()).thenReturn(superSausePrice);
        Mockito.when(superMeatBalls.getPrice()).thenReturn(superMeatBallsPrice);
        Mockito.when(topBun.getName()).thenReturn(bunName);
        Mockito.when(superSause.getName()).thenReturn(superSauseName);
        Mockito.when(superMeatBalls.getName()).thenReturn(superMeatBallsName);
        Mockito.when(superSause.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(superMeatBalls.getType()).thenReturn(IngredientType.FILLING);


        String expectedResult = (String.format("(==== %s ====)%n", bunName)+String.format(String.format("= %s %s =%n", (IngredientType.SAUCE).toString().toLowerCase(),
                superSauseName))+String.format(String.format("= %s %s =%n", (IngredientType.FILLING).toString().toLowerCase(),
                superMeatBallsName))+String.format("(==== %s ====)%n", bunName)+String.format("%nPrice: %f%n", testBurger.getPrice()));

        assertEquals(expectedResult, testBurger.getReceipt());


    }

}