package seedu.duke.CapCalculatorClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModuleListTest {

    @Test
    void verifyNumberPrintedForgradesToPoints() {
        ModuleList ml = new ModuleList();
        String inputString = "A-";
        assertEquals(4.5,ml.gradesToPoints(inputString));
    }
}