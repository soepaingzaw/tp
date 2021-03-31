package seedu.allinonenus.capcalculatorclasses;

import org.junit.jupiter.api.Test;
import seedu.allinonenus.capcalculatorclasses.logicforcapcalculator.ModuleList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModuleListTest {

    @Test
    void verifyNumberPrintedForgradesToPoints() {
        ModuleList ml = new ModuleList();
        String inputString = "A-";
        assertEquals(4.5,ml.gradesToPoints(inputString));
    }
}