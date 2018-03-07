package com.innovid.shneior;

import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.*;
public class NilTest {


    @Test (expected = IllegalArgumentException.class)
    public void headTest_whenInvoked_thenShouldThrowIllegalArgumentException() {
        List<String> nil = ListFactory.of();

        nil.head();
    }

    @Test (expected = IllegalArgumentException.class)
    public void tailTest_whenInvoked_thenShouldThrowIllegalArgumentException() {
        List<String> nil = ListFactory.of();

        nil.tail();
    }

    @Test
    public void filterTest_givenAnyParam_thenShouldReturnNil() {
        List<String> nil1 = ListFactory.of();
        List<String> nil2 = nil1.filter(i -> true);
        List<String> nil3 = nil1.filter(null);

        assertEquals(nil1, nil2);
        assertEquals(nil2, nil3);
    }

    @Test
    public void mapTest_givenAnyParam_thenShouldReturnNil() {
        List<String> expected = ListFactory.of();

        List<Boolean> actual1 = expected.map(i -> true);
        List<Integer> actual2 = expected.map(null);

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    public void isEmptyTest_whenInvoked_thenShouldReturnTrue() {
        List<String> nil = ListFactory.of();

        boolean actual = nil.isEmpty();

        assertTrue(actual);
    }

    @Test
    public void nonEmptyTest_whenInvoked_thenShouldReturnFalse() {
        List<String> nil = ListFactory.of();

        boolean actual = nil.nonEmpty();

        assertFalse(actual);
    }

    @Test
    public void sizeTest_whenInvoked_thenShouldReturnZero() {
        List<String> nil = ListFactory.of();
        long expected = 0;

        long actual = nil.size();

        assertEquals(expected, actual);
    }

    @Test
    public void takeTest_givenAnyNumber_thenShouldReturnNil() {
        List<String> expected = ListFactory.of();

        List<String> actual = expected.take(0);

        assertEquals(expected, actual);

    }

    @Test
    public void dropTest_givenAnyNumber_thenShouldReturnNil() {
        List<String> expected = ListFactory.of();

        List<String> actual = expected.drop(0);

        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void applyTest_givenAnyNumber_thenShouldThrowIndexOutOfBoundsException() {
        List<String> nil = new Nil<>();

        nil.apply(0);
    }

    @Test
    public void headOptionTest_whenInvoked_thenShouldReturnEmptyOptionalObject() {
        List<String> nil = ListFactory.of();
        Optional<String> expected = Optional.empty();

        Optional<String> actual = nil.headOption();

        assertEquals(expected, actual);
    }


    @Test
    public void takeWhileTest_givenAnyParam_thenShouldReturnNil() {
        List<String> expected = ListFactory.of();
        List<String> actual1 = expected.takeWhile(i -> true);
        List<String> actual2 = expected.takeWhile(null);

        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }

    @Test
    public void getStringTest_whenInvoked_thenShouldReturnEmptyString() {
        List<String> nil = ListFactory.of();
        String expected = "";

        String actual = nil.getString();

        assertEquals(expected, actual);
    }

    @Test
    public void foldLeftTest_givenTowParams_thenShouldReturnTheFirstParam() {
        List<Integer> nil = ListFactory.of();
        int expected = 1;

        int actual = nil.foldLeft(1, (a, b) -> a + b);

        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest_whenInvoked_thenShouldReturnFormattedStringOfEmptyList() {
        List<String> nil = ListFactory.of();
        String expected = "List()";

        String actual = nil.toString();

        assertEquals(expected, actual);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void removeTest_givenAnyNumber_thenShouldThrowIndexOutOfBoundsException() {
        List<String> nil = new Nil<>();

        nil.remove(1);
    }

    @Test
    public void equalsTest_givenMatchingObjectAndElements_shouldReturnTrue() {
        List<Integer> list1 = ListFactory.of();
        List<Integer> list2 = ListFactory.of();

        boolean actual = list1.equals(list2);

        assertTrue(actual);
    }

    @Test
    public void equalsTest_givenNullParam_thenShouldReturnFalse() {
        List<Integer> list = new Nil<>();

        boolean actual = list.equals(null);

        assertFalse(actual);
    }

    @Test
    public void equalsTest_givenNotSameInstanceObject_thenShouldReturnFalse() {
        List<Integer> list2 = ListFactory.of(1);
        List<Integer> list1 = new Nil<>();

        boolean actual = list1.equals(list2);

        assertFalse(actual);
    }

}
