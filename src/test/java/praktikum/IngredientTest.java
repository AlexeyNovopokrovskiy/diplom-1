package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameter
    public IngredientType type;

    

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] param() {

        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };

        }


    @Test
    public void getPriceTest(){

        String testName = "Vkusno I Tochka";
        float testPrice = 9.99F;

        Ingredient ingredient = new Ingredient(type, testName, testPrice);
        assertEquals(String.format("%s", testPrice), String.format("%s",(ingredient.getPrice())));

    }

    @Test
    public void getNameTest(){

        String testName = "Vkusno I Tochka";
        float testPrice = 9.99F;

        Ingredient ingredient = new Ingredient(type, testName, testPrice);
        assertEquals(testName, ingredient.getName());

    }

    @Test
    public void getTypeTest(){
        String testName = "Vkusno I Tochka";
        float testPrice = 9.99F;

        Ingredient ingredient = new Ingredient(type, testName, testPrice);
        assertEquals(type, ingredient.getType());

    }

}