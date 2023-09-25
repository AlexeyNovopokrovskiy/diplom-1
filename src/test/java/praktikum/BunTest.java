package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;


public class BunTest {

    @Test
    public void getNameTest(){
        String testName = "Super Burger";
        float testPrice = 9.99F;
        Bun bun = new Bun(testName, testPrice );
        assertEquals(testName, bun.getName());

    }

    @Test
    public void getPriceTest(){
        String testName = "Super Burger";
        float testPrice = 9.99F;
        Bun bun = new Bun(testName, testPrice );
        assertEquals(String.format("%s", testPrice), String.format("%s",(bun.getPrice())));

    }

}