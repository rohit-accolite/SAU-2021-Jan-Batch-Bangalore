package question_three;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClassTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Starting tests...");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("Tests done");
    }


    @Test
    public void nameTest() {
        System.out.println("Test 1");
        Class1 class1 = mock(Class1.class);
        when(class1.giveName("hello")).thenReturn("hello");

        Class2 class2 = new Class2(class1);
        String result = class2.getName();

        assertEquals("hello", result);
    }

    @Test
    public void maxNumTest() {
        System.out.println("Test 2");
        Class1 class1 = mock(Class1.class);
        when(class1.findMax(5,10)).thenReturn(10);

        Class2 class2 = new Class2(class1);
        int result = class2.getMax(5, 10);

        assertEquals(10, result);
    }

    @Test
    public void longStringTest() {
        System.out.println("Test 3");
        Class2 class2 = mock(Class2.class);
        when(class2.findLongerString("abcd", "12345")).thenReturn("12345");

        Class1 class1 = new Class1(class2);
        String result = class1.getLongerString("abcd", "12345");

        assertEquals("12345", result);
    }
}
