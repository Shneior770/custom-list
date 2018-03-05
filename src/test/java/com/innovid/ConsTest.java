package com.innovid;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
public class ConsTest {

    @Test
    public void headTest_whenInvoked_thenShouldReturnTheHeadElementOfTheList() {
        // prepare
        Cons<Integer> cons = new Cons<>(1, new Nil<>());
        int expected = 1;
        // act
        int actual = cons.head();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void tailTest_whenInvoked_thenShouldReturnTheTailElementOfTheList() {
        // prepare
        Nil<Integer> expected = new Nil<>();
        Cons<Integer> cons = new Cons<>(1, expected);
        // act
        SList<Integer> actual = cons.tail();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void filterTest_givenPredicate_thenReturnFilteredSListAccordingToThePredicateTerm() {
        //prepare
        SList<Integer> expected = new Cons<>(2, new Nil<>());
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.filter(i -> i % 2 == 0);
        // assert
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void filterTest_whenPassingNullParam_thenShouldThrowNulPointerException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.filter(null);
    }

    @Test
    public void mapTest_givenAFunction_thenShouldReturnListAccordingToTheFunctionOperation() {
        //prepare
        SList<Integer> list = new Cons<>(3, new Nil<>());
        SList<Integer> expected = new Cons<>(2, list);

        SList<Integer> cons2 = new Cons<>(2, new Nil<>());
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.map(i -> (int) i + 1);
        // assert
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void mapTest_whenPassingNullParam_thenShouldThrowNulPointerException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.map(null);
    }

    @Test
    public void isEmpty_whenInvoked_thenShouldReturnFalse() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        boolean actual = cons.isEmpty();
        // assert
        assertFalse(actual);
    }

    @Test
    public void nonEmpty_whenInvoked_thenShouldReturnTrue() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        boolean actual = cons.nonEmpty();
        // assert
        assertTrue(actual);
    }

    @Test
    public void sizeTest_whenInvoked_thenShouldReturnTheSizeOfTheList() {
        // prepare
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        long expected = 3;
        // act
        long actual = cons1.size();
        // assert
        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void atTest_whenPassingANumLessTheZero_thenShouldThrowIndexOutOfBoundException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.at(-1);
    }

    @Test
    public void atTest_whenPassingZeroNumber_thenShouldReturnTheFirstElementOfTheList() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        int expected = 1;
        // act
        int actual = cons.at(0);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void atTest_whenPassingValidNumber_thenShouldReturnTheElementIndexedInTheNumberPosition() {
        // prepare
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        long expected = 3;
        // act
        long actual = cons1.at(2);
        // assert
        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void atTest_whenPassingANumGraterThenTheListSize_thenShouldThrowIndexOutOfBoundException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.at(2);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void takeTest_whenPassingANumLessThenZero_thenShouldThrowIndexOutOfBoundsException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.take(-1);
    }

    @Test
    public void takeTest_whenPassing1_thenShouldReturnSListConsistOfTheFirstElementOfTheList() {
        //prepare
        SList<Integer> expected = new Cons<>(1, new Nil<>());
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.take(1);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void takeTest_whenPassingANum_thenShouldReturnSListConsistOfTheFirstNumElementOfTheList() {
        //prepare
        SList<Integer> head = new Cons<>(3, new Nil<>());
        SList<Integer> tail = new Cons<>(2, head);
        SList<Integer> expected = new Cons<>(1, tail);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.take(3);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void takeTest_GivenANumWhoIsGraterThenTheSListSize_thenShouldReturnTheSList() {
        //prepare
        SList<Integer> head = new Cons<>(3, new Nil<>());
        SList<Integer> tail = new Cons<>(2, head);
        SList<Integer> expected = new Cons<>(1, tail);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.take(4);
        // assert
        assertEquals(expected, actual);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void dropTest_givenANumLessThenZero_thenShouldThrowIndexOutOfBoundsException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.drop(-1);
    }

    @Test
    public void dropTest_given1_thenShouldReturnTheGeneralListExceptTheFirstElement() {
        //prepare
        SList<Integer> head = new Cons<>(3, new Nil<>());
        SList<Integer> expected = new Cons<>(2, head);
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.drop(1);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void dropTest_givenANumGraterThenTheSizeOfTheList_thenShouldReturnEmptyList() {
        //prepare
        SList<Integer> expected = new Nil<>();
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.drop(10);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void dropTest_givenANum_thenShouldReturnTheSListExceptTheFirstNumElements() {
        //prepare
        SList<Integer> expected = new Cons<>(3, new Nil<>());

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual =  cons1.drop(2);
        // assert
        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void applyTest_whenPassingANumLessTheZero_thenShouldThrowIndexOutOfBoundException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.apply(-1);
    }

    @Test
    public void applyTest_whenPassingZeroNumber_thenShouldReturnTheFirstElementOfTheList() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        int expected = 1;
        // act
        int actual = cons.apply(0);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void applyTest_whenPassingValidNumber_thenShouldReturnTheElementIndexedInTheNumberPosition() {
        // prepare
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        long expected = 3;
        // act
        long actual = cons1.apply(2);
        // assert
        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void applyTest_whenPassingANumGraterThenTheListSize_thenShouldThrowIndexOutOfBoundException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.apply(2);
    }

    @Test
    public void headOptionTest_whenInvoked_thenShouldReturnAnOptionalObjectWithHead() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        Optional<Integer> expected = Optional.of(1);
        // act
        Optional<Integer> actual = cons.headOption();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void takeWhileTest_givenAListThatIsAllElementsSatisfyThePredicate_thenReturnTheAllList() {
        // prepare
        SList<Integer> head = new Cons<>(3, new Nil<>());
        SList<Integer> tail = new Cons<>(2, head);
        SList<Integer> expected = new Cons<>(1, tail);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual = cons1.takeWhile(i -> i < 4);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void takeWhileTest_whenAnElementThatNotSatisfyThePredicate_thenShouldReturnAllThePreviousElementsWhoseSatisfyThePredicate() {
        // prepare
        SList<Integer> expected = new Cons<>(2, new Nil<>());

        SList<Integer> cons3 = new Cons<>(4, new Nil<>());
        SList<Integer> cons2 = new Cons<>(3, cons3);
        SList<Integer> cons1 = new Cons<>(2, cons2);

        // act
        SList<Integer> actual = cons1.takeWhile(i -> i % 2 == 0);
        // assert
        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void takeWhileTest_whenPassingANullParam_thenShouldThrowNullPointerException() {
        // prepare
        SList<Integer> cons = new Cons<>(1, new Nil<>());
        // act
        cons.takeWhile(null);
    }

    @Test
    public void toStringTest_whenInvoked_thenShouldReturnFormattedString() {
        // prepare
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        String expected = "SList(1, 2, 3)";
        // act
        String actual = cons1.toString();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void ofTest_givenParams_shouldReturnSListOfTheGivenParams() {
        // prepare
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> expected = new Cons<>(1, cons2);
        // act
        SList<Integer> actual = Cons.of(1, 2, 3);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void ofTest_givenNoParams_shouldReturnNil() {
        // prepare
        SList<Integer> expected = new Nil<>();
        // act
        SList<Integer> actual = Cons.of();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void foldLeftTest_givenACCAndOperator_shouldApplyTheOperatorToTheACCForEachElementAndReturnTheResult() {
        // prepare
        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        int expected = 12;
        // act
        int actual = cons1.foldLeft(2, (i, j) -> i * j);
        // assert
        assertEquals(expected, actual);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void removeTest_givenIndexLessThenZero_shouldThrowIndexOutOfBoundsException() {
        // prepare
        SList<Integer> cons2 = new Cons<>(3, new Nil<>());
        SList<Integer> cons1 = new Cons<>(2, cons2);
        // act
        cons1.remove(-1);
    }


    @Test
    public void removeTest_givenValidIndex_shouldReturnListOfAllElementsExceptTheElementInThePassedIndex() {
        // prepare
        SList<Integer> list = new Cons<>(3, new Nil<>());
        SList<Integer> expected = new Cons<>(1, list);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual = cons1.remove(1);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void removeTest_givenIndexZero_shouldReturnListOfAllElementsExceptTheElementInTheIndexOfZero() {
        // prepare
        SList<Integer> list = new Cons<>(3, new Nil<>());
        SList<Integer> expected = new Cons<>(1, list);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual = cons1.remove(1);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void removeTest_givenIndexGraterThenTheSListSize_shouldThrowIndexOutOfBoundsException() {
        // prepare
        SList<Integer> list = new Cons<>(3, new Nil<>());
        SList<Integer> expected = new Cons<>(2, list);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> cons1 = new Cons<>(1, cons2);
        // act
        SList<Integer> actual = cons1.remove(0);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void equalsTest_givenNullParam_shouldReturnFalse() {
        // prepare
        SList<Integer> list = new Cons<>(1, new Nil<>());
        // act
        boolean actual = list.equals(null);
        // assert
        assertFalse(actual);
    }

    @Test
    public void equalsTest_givenNotSameInstanceObject_shouldReturnFalse() {
        // prepare
        SList<Integer> list1 = new Cons<>(1, new Nil<>());
        SList<Integer> list2 = new Nil<>();
        // act
        boolean actual = list1.equals(list2);
        // assert
        assertFalse(actual);
    }

    @Test
    public void equalsTest_givenMatchingObjectAndElements_shouldReturnTrue() {
        // prepare
        SList<Integer> head = new Cons<>(3, new Nil<>());
        SList<Integer> tail = new Cons<>(2, head);
        SList<Integer> list2 = new Cons<>(1, tail);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> list1 = new Cons<>(1, cons2);
        // act
        boolean actual = list1.equals(list2);
        // assert
        assertTrue(actual);
    }

    @Test
    public void equalsTest_givenUnMatchingElements_shouldReturnFalse() {
        // prepare
        SList<Integer> head = new Cons<>(4, new Nil<>());
        SList<Integer> tail = new Cons<>(2, head);
        SList<Integer> list2 = new Cons<>(1, tail);

        SList<Integer> cons3 = new Cons<>(3, new Nil<>());
        SList<Integer> cons2 = new Cons<>(2, cons3);
        SList<Integer> list1 = new Cons<>(1, cons2);
        // act
        boolean actual = list1.equals(list2);
        // assert
        assertFalse(actual);
    }



}
