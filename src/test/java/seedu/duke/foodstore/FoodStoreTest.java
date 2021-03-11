package seedu.duke.foodstore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodStoreTest {

    @Test
    void toString_expectOneString() {
        FoodStore foodStore = new FoodStore("Chicken Rice", "Sells White and Roasted Chicken", true);
        String correctOutput = "[H] Chicken Rice: Sells White and Roasted Chicken";
        assertEquals(correctOutput, foodStore.toString());
    }

}