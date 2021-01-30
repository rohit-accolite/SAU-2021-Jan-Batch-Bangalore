package question_one;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LeapYearTest {

    LeapYear leapYear = new LeapYear();

    @BeforeAll
    public static void beforeAllTest() {
        System.out.println("Starting tests...");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("Tests done");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
        boolean result  = leapYear.check(2001);
        assertEquals(false, result);
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
        boolean result  = leapYear.check(2020);
        assertEquals(true, result);
    }

    @Test
    public void test3() {
        System.out.println("Test 3");
        boolean result  = leapYear.check(2001);
        assertNotEquals(true, result);
    }

}
