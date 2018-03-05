package com.innovid;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
public class NilTest {


    @Test (expected = IllegalArgumentException.class)
    public void headTest_isInvoked_throwsIllegalArgumentException() {
        // prepare
        Nil<String> nil = new Nil<>();
        // act
        nil.head();
    }

    @Test (expected = IllegalArgumentException.class)
    public void tailTest_isInvoked_throwsIllegalArgumentException() {
        // prepare
        Nil<String> nil = new Nil<>();
        // act
        nil.tail();
    }

    @Test
    public void filterTest_givenAnyParam_thenShouldReturnSList() {
        // prepare
        SList<String> nil1 = new Nil<>();
        SList<String> nil2 = nil1.filter(i -> true);
        // assert
        assertEquals(nil1, nil2);
    }

    @Test
    public void mapTest_givnAnyParam_thenShouldReturnSList() {
        // prepare
        SList<String> nil1 = new Nil<>();
        // act
        SList<String> nil2 = nil1.map(i -> true);
        // assert
        assertEquals(nil1, nil2);
    }

    @Test
    public void isEmptyTest_whenInvoked_thenShouldReturnTrue() {
        // prepare
        SList<String> nil = new Nil<>();
        // act
        boolean actual = nil.isEmpty();
        // assert
        assertTrue(actual);
    }

    @Test
    public void nonEmptyTest_whenInvoked_thenShouldReturnFalse() {
        // prepare
        SList<String> nil = new Nil<>();
        // act
        boolean actual = nil.nonEmpty();
        // assert
        assertFalse(actual);
    }

    @Test
    public void sizeTest_whenInvoked_thenShouldReturnZero() {
        // prepare
        SList<String> nil = new Nil<>();
        long expected = 0;
        // act
        long actual = nil.size();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void takeTest_givenAnyParam_shouldReturnSlist() {
        // prepare
        SList<String> nil1 = new Nil<>();
        SList<String> nil2 = nil1.take(0);
        // assert
        assertEquals(nil1, nil2);
    }

    @Test
    public void dropTest_givenAnyParam_shouldReturnSlist() {
        // prepare
        SList<String> nil1 = new Nil<>();
        SList<String> nil2 = nil1.drop(0);
        // assert
        assertEquals(nil1, nil2);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void applyTest_givenAnyParam_thenShouldThrowIndexOutOfBoundsException() {
        // prepare
        SList<String> nil1 = new Nil<>();
        // act
        nil1.apply(0);
    }

    @Test
    public void headOptionTest_givanAnyParam_thenShouldReturnEmptyOptionalObject() {
        // prepare
        SList<String> nil1 = new Nil<>();
        Optional<String> expected = Optional.empty();
        // act
        Optional<String> actual = nil1.headOption();
        // assert
        assertEquals(expected, actual);
    }


    @Test
    public void takeWhileTest_givenAnyParam_thenShouldReturnSlist() {
        // prepare
        SList<String> nil1 = new Nil<>();
        SList<String> nil2 = nil1.takeWhile(i -> true);
        // assert
        assertEquals(nil1, nil2);
    }

    @Test
    public void getStringTest_whenInvoked_thenShouldReturnEmptyString() {
        // prepare
        SList<String> nil = new Nil<>();
        String expected = "";
        // act
        String actual = nil.getString();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void foldLeftTest_givenTowParams_thenShouldReturnTheFirstParam() {
        // prepare
        SList<Integer> nil = new Nil<>();
        int expected = 1;
        // act
        int actual = nil.foldLeft(1, (a, b) -> a + b);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest_whenInvoked_thenSouldReturnStringOfEmptySList() {
        SList<String> nil = new Nil<>();
        String expected = "SList()";
        // act
        String actual = nil.toString();
        // assert
        assertEquals(expected, actual);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void removeTest_givenAnyParam_thenShouldThrowIndexOutOfBoundsException() {
        // prepare
        SList<String> nil = new Nil<>();
        // act
        nil.remove(1);
    }

    @Test
    public void equalsTest_givenNullParam_shouldReturnFalse() {
        // prepare
        SList<Integer> list = new Nil<>();
        // act
        boolean actual = list.equals(null);
        // assert
        assertFalse(actual);
    }

    @Test
    public void equalsTest_givenNotSameInstanceObject_shouldReturnFalse() {
        // prepare
        SList<Integer> list2 = new Cons<>(1, new Nil<>());
        SList<Integer> list1 = new Nil<>();
        // act
        boolean actual = list1.equals(list2);
        // assert
        assertFalse(actual);
    }

    @Test
    public void equalsTest_givenMatchingObjectAndElements_shouldReturnTrue() {
        // prepare
        SList<Integer> list1 = new Nil<>();
        SList<Integer> list2 = new Nil<>();
        // act
        boolean actual = list1.equals(list2);
        // assert
        assertTrue(actual);
    }



}
