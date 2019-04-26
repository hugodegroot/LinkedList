package nl.hva.ict.ds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    protected LinkedList<String> testList;

    @Before
    public void setup() {
        testList = new LinkedList<>();
    }

    @Test
    public void addToEmptyList() {
        testList.add("one");

        assertTrue(testList.size() != 0);
        assertEquals("one", testList.get(0));
    }

    @Test
    public void addToListWithOneElement() {
        testList.add("one");
        testList.add("two");

        assertTrue(testList.size() != 0);
        assertEquals("two", testList.get(1));
    }

    @Test
    public void getFirstElement() {
        testList.add("one");

        assertEquals("one", testList.get(0));
    }

    @Test
    public void getLastElement() {
        testList.add("one");

        assertEquals("one", testList.get(testList.size() - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeIndexIsNotAllowed() {
        testList.get(-1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativeIndexIsNotAllowed2() {
        testList.add("one");
        testList.add("two");
        testList.get(-1);
    }

    @Test
    public void deleteFromListWithSingleElement() {
        testList.add("one");
        testList.delete("one");

        assertEquals(0, testList.size());
    }

    @Test
    public void deleteFromListWithMultipleOccurences() {
        testList.add("one");
        testList.add("one");
        testList.delete("one");

        assertEquals(0, testList.size());
    }



    @Test
    public void deleteFromListWithMultipleOccurrencesAndMoreElements() {
        testList.add("one");
        testList.add("two");
        testList.add("one");
        testList.delete("one");

        assertEquals(1, testList.size());
    }



    @Test
    public void sizeOfEmptyList() {
        assertEquals(0, testList.size());
    }

    @Test
    public void sizeOfListWithOneElement() {
        testList.add("one");
        assertEquals(1, testList.size());
    }

    // Extra unit tests go here

    @Test
    public void deleteFromMiddleOfList() {
        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");
        testList.add("five");
        testList.add("six");
        testList.delete("three");
        testList.delete("four");

        assertEquals(4, testList.size());
    }

    @Test
    public void deleteFromMiddleOfListWithMultipleOccurrences() {
        testList.add("one");
        testList.add("two");
        testList.add("one");
        testList.add("four");
        testList.add("one");
        testList.add("six");
        testList.delete("one");

        assertEquals(3, testList.size());
    }

    @Test
    public void deleteFromAndAddToListWithMultipleOccurrences() {
        testList.add("one");
        testList.add("two");
        testList.add("one");
        testList.delete("two");
        testList.add("four");
        testList.add("one");
        testList.add("six");
        testList.delete("one");
        testList.add("five");
        testList.add("seven");
        testList.add("eight");
        testList.delete("five");

        assertEquals(4, testList.size());
    }

    @Test
    public void getFromMiddleElement(){
        testList.add("one");
        testList.add("two");
        testList.add("three");
        testList.add("four");
        testList.add("five");
        testList.add("six");
        testList.add("seven");
        testList.add("eight");
        testList.add("nine");
        testList.add("ten");
        assertEquals("four", testList.get(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void biggerIndexIsNotAllowed() {
        testList.add("one");
        testList.add("two");
        testList.get(testList.size(+10));
    }
}
