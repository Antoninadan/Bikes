package ua.i.mail100.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

class InputerTest {
    Inputer inputerOne;
    Inputer inputerTwo;
    Inputer inputerThree;
    Inputer inputerFour;

    @BeforeEach
    void setUp() {
       inputerOne = new Inputer("1", InputedType.STRING);
       inputerTwo = new Inputer("1", InputedType.STRING);
       inputerThree = new Inputer("1", InputedType.STRING_NOT_EMPTY);
       inputerFour = new Inputer("2", InputedType.STRING);
    }

    @Test
    void hashCodeTest() {
        assertEquals(inputerOne.hashCode(), inputerTwo.hashCode());
        assertNotEquals(inputerOne.hashCode(), inputerThree.hashCode());
        assertNotEquals(inputerOne.hashCode(), inputerFour.hashCode());
    }

    @Test
    void equals() {
        assertEquals(inputerOne, inputerTwo);
        assertNotEquals(inputerOne, inputerThree);
        assertNotEquals(inputerOne, inputerFour);
    }
}