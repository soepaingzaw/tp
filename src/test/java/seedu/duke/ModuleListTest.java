package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModuleListTest {

    @Test
    void verifyNumberPrintedForgradesToPoints() {
        ModuleList ml = new ModuleList();
        String inputString = "A-";
        double number = ml.gradesToPoints(inputString);
        assertEquals(4.5,ml.gradesToPoints(inputString));
    }
}