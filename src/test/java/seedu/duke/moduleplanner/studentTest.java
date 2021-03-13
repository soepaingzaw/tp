package seedu.duke.moduleplanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class studentTest {
    private final Student Alice = new Student("Alice", 1, true, 1);
    private final Student Bob = new Student("Bob", 2, false, 2);

    @Test
    void testScore() {
        assertEquals(9, Alice.getScore());
        assertEquals(6, Bob.getScore());
    }
}