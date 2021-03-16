package seedu.duke.foodstore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoodStoreTest {

    @Test
    void toString_expectOneString() {
        FoodStore foodStore = new FoodStore("Chicken Rice", "Sells White and Roasted Chicken");
        String correctOutput = "[X] Chicken Rice: Sells White and Roasted Chicken";
        assertEquals(correctOutput, foodStore.toString());
    }

}