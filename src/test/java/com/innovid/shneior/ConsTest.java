package com.innovid.shneior;

import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.*;

public class ConsTest {

    @Test
    public void headTest_whenInvoked_thenShouldReturnTheHeadElementOfTheList() {
        List<Integer> list = ListFactory.of(1);
        int expected = 1;

        int actual = list.head();

        assertEquals(expected, actual);
    }

    @Test
    public void tailTest_whenInvoked_thenShouldReturnTheTailElementOfTheList() {
        List<Integer> list = ListFactory.of(1, 2, 3);
        List<Integer> expected = ListFactory.of( 2, 3);

        List<Integer> actual = list.tail();

        assertEquals(expected, actual);
    }

    @Test
    public void tailTest_whenInvokedWithEmptyTail_thenShouldReturnTheEmptyTail() {
        Nil<Integer> expected = new Nil<>();
        List<Integer> list = ListFactory.of(1);

        List<Integer> actual = list.tail();

        assertEquals(expected, actual);
    }

    @Test
    public void filterTest_givenPredicate_thenReturnFilteredListAccordingToThePredicateTerm() {
        List<Integer> expected = ListFactory.of(2);
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual =  list.filter(i -> i % 2 == 0);

        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void filterTest_whenPassingNullParam_thenShouldThrowNullPointerException() {
        List<Integer> list = ListFactory.of(1);

        list.filter(null);
    }

    @Test
    public void mapTest_givenAListOfIntsAndFunctionFromIntToString_thenShouldReturnListAccordingToTheFunctionOperation() {
        List<Integer> numbers = ListFactory.of(1, 2, 3, 4);
        List<String> mappedList = numbers.map(i -> i + "!");

        assertEquals(ListFactory.of("1!", "2!", "3!", "4!"), mappedList);
    }

    @Test
    public void mapTest_givenAFunction_thenShouldReturnListAccordingToTheFunctionOperation() {
        List<Integer> expected = ListFactory.of( 2, 3);
        List<Integer> list = ListFactory.of(1, 2);

        List<Integer> actual =  list.map(i -> i + 1);

        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void mapTest_whenPassingNullParam_thenShouldThrowNullPointerException() {
        List<Integer> list = ListFactory.of(1);

        list.map(null);
    }

    @Test
    public void isEmpty_whenInvoked_thenShouldReturnFalse() {
        List<Integer> list = ListFactory.of(1);

        boolean actual = list.isEmpty();

        assertFalse(actual);
    }

    @Test
    public void nonEmpty_whenInvoked_thenShouldReturnTrue() {
        List<Integer> list = ListFactory.of(1);

        boolean actual = list.nonEmpty();

        assertTrue(actual);
    }

    @Test
    public void sizeTest_whenInvoked_thenShouldReturnTheSizeOfTheList() {
        List<Integer> list = ListFactory.of(1, 2, 3);
        long expected = 3;

        long actual = list.size();

        assertEquals(expected, actual);
    }

    @Test
    public void atTest_whenPassingValidNumber_thenShouldReturnTheElementIndexedInTheNumberPosition() {
        List<Integer> list = ListFactory.of(1, 2, 3);
        long expected = 3;

        long actual = list.at(2);

        assertEquals(expected, actual);
    }

    @Test
    public void atTest_whenPassingZeroNumber_thenShouldReturnTheFirstElementOfTheList() {
        List<Integer> list = ListFactory.of(1);
        int expected = 1;

        int actual = list.at(0);

        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void atTest_whenPassingANumLessTheZero_thenShouldThrowIndexOutOfBoundException() {
        List<Integer> list = ListFactory.of(1);

        list.at(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void atTest_whenPassingANumGreaterThanTheListSize_thenShouldThrowIndexOutOfBoundException() {
        List<Integer> list = ListFactory.of(1);

        list.at(2);
    }

    @Test
    public void takeTest_whenPassingANum_thenShouldReturnListConsistOfTheFirstNumElementOfTheList() {
        List<Integer> expected = ListFactory.of(1, 2, 3);
        List<Integer> list = ListFactory.of(1, 2, 3, 4, 5, 6);

        List<Integer> actual =  list.take(3);

        assertEquals(expected, actual);
    }

    @Test
    public void takeTest_whenPassing1_thenShouldReturnListConsistOfTheFirstElementOfTheList() {
        List<Integer> expected = ListFactory.of(1);
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual =  list.take(1);

        assertEquals(expected, actual);
    }

    @Test
    public void takeTest_GivenANumWhoIsGreaterThanTheListSize_thenShouldReturnTheList() {
        List<Integer> expected = ListFactory.of(1, 2, 3);
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual = list.take(6);

        assertEquals(expected, actual);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void takeTest_whenPassingANumLessThanZero_thenShouldThrowIndexOutOfBoundsException() {
        List<Integer> list = ListFactory.of(1);

        list.take(-1);
    }

    @Test
    public void dropTest_givenANum_thenShouldReturnTheListExceptTheFirstNumElements() {
        List<Integer> expected = ListFactory.of(3);

        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual =  list.drop(2);

        assertEquals(expected, actual);
    }

    @Test
    public void dropTest_given1_thenShouldReturnTheGeneralListExceptTheFirstElement() {
        List<Integer> expected = ListFactory.of(2, 3);
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual =  list.drop(1);

        assertEquals(expected, actual);
    }

    @Test
    public void dropTest_givenANumGreaterThanTheSizeOfTheList_thenShouldReturnEmptyList() {
        List<Integer> expected = new Nil<>();
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual =  list.drop(10);

        assertEquals(expected, actual);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void dropTest_givenANumLessThanZero_thenShouldThrowIndexOutOfBoundsException() {
        List<Integer> list = ListFactory.of(1);

        list.drop(-1);
    }

    @Test
    public void applyTest_whenPassingValidNumber_thenShouldReturnTheElementIndexedInTheNumberPosition() {
        List<Integer> list = ListFactory.of(1, 2, 3);
        long expected = 3;

        long actual = list.apply(2);

        assertEquals(expected, actual);
    }

    @Test
    public void applyTest_whenPassingZeroNumber_thenShouldReturnTheFirstElementOfTheList() {
        List<Integer> list = ListFactory.of(1);
        int expected = 1;

        int actual = list.apply(0);

        assertEquals(expected, actual);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void applyTest_whenPassingANumLessThanZero_thenShouldThrowIndexOutOfBoundException() {
        List<Integer> list = ListFactory.of(1);

        list.apply(-1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void applyTest_whenPassingANumGreaterThanTheListSize_thenShouldThrowIndexOutOfBoundException() {
        List<Integer> list = ListFactory.of(1);

        list.apply(2);
    }

    @Test
    public void headOptionTest_whenInvoked_thenShouldReturnAnOptionalObjectWithHead() {
        List<Integer> list = ListFactory.of(1, 2, 3);
        Optional<Integer> expected = Optional.of(1);

        Optional<Integer> actual = list.headOption();

        assertEquals(expected, actual);
    }

    @Test
    public void takeWhileTest_givenAListThatIsAllElementsSatisfyThePredicate_thenReturnTheAllListElements() {
        List<Integer> expected = ListFactory.of(1, 2, 3);
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual = list.takeWhile(i -> i < 4);

        assertEquals(expected, actual);
    }

    @Test
    public void takeWhileTest_whenAnElementThatIsNotSatisfyThePredicate_thenShouldReturnAllThePreviousElementsWhoseSatisfyThePredicate() {
        List<Integer> expected = ListFactory.of(2);

        List<Integer> list = ListFactory.of( 2, 3, 4);

        List<Integer> actual = list.takeWhile(i -> i % 2 == 0);

        assertEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void takeWhileTest_whenPassingANullParam_thenShouldThrowNullPointerException() {
        List<Integer> list = ListFactory.of(1);

        list.takeWhile(null);
    }

    @Test  (expected = NullPointerException.class)
    public void takeWhileTest_whenInvokedOnListWithNullParam_thenShouldThrowNullPointerException() {
        List<Integer> expected = ListFactory.of(9, 3);
        List<Integer> list = ListFactory.of(9, null, 3);

        List<Integer> actual = list.takeWhile(i -> i % 2 != 0);

        assertEquals(expected, actual);
    }

    @Test
    public void getStringTest_whenInvoked_thenShouldReturnUnformattedStringOfTheList() {
        String expected = "1, 2, 3, ";
        List<Integer> list = ListFactory.of(1, 2, 3);

        String actual = list.getString();

        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest_whenInvoked_thenShouldReturnFormattedString() {
        List<Integer> list = ListFactory.of(1, 2, 3);
        String expected = "List(1, 2, 3)";

        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest_whenInvokedOnListWithNullParam_thenShouldReturnFormattedStringWithTheNullParams() {
        List<Integer> list = ListFactory.of(1, 2, null);
        String expected = "List(1, 2, null)";

        String actual = list.toString();

        assertEquals(expected, actual);
    }


    @Test
    public void foldLeftTest_givenACCAndOperator_thenShouldApplyTheOperatorToTheACCForEachElementAndReturnTheResult() {
        List<Integer> list = ListFactory.of(1, 2, 3);
        String expected = "!123";

        String actual = list.foldLeft("!", ((acc, integer) -> acc + integer));

        assertEquals(expected, actual);
    }

    @Test
    public void removeTest_givenValidIndex_thenShouldReturnListOfAllElementsExceptTheElementInThePassedIndex() {
        List<Integer> expected = ListFactory.of(1, 3);
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual = list.remove(1);

        assertEquals(expected, actual);
    }

    @Test
    public void removeTest_givenIndexZero_thenShouldReturnListOfAllElementsExceptTheElementInTheIndexOfZero() {
        List<Integer> expected = ListFactory.of( 2, 3);
        List<Integer> list = ListFactory.of(1, 2, 3);

        List<Integer> actual = list.remove(0);

        assertEquals(expected, actual);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void removeTest_givenIndexLessThenZero_thenShouldThrowIndexOutOfBoundsException() {
        List<Integer> list = ListFactory.of(1, 2, 3);

        list.remove(-1);
    }

    @Test  (expected = IndexOutOfBoundsException.class)
    public void removeTest_givenIndexGraterThenTheListSize_thenShouldThrowIndexOutOfBoundsException() {
        List<Integer> list = ListFactory.of(1, 2, 3);

        list.remove(3);
    }

    @Test
    public void equalsTest_givenMatchingObjectAndElements_thenShouldReturnTrue() {
        List<Integer> list1 = ListFactory.of(1, 2, 3);
        List<Integer> list2 = ListFactory.of(1, 2, 3);

        boolean actual = list1.equals(list2);

        assertTrue(actual);
    }

    @Test
    public void equalsTest_givenUnMatchingElements_thenShouldReturnFalse() {
        List<Integer> list1 = ListFactory.of(2, 2, 3);
        List<Integer> list2 = ListFactory.of(1, 2, 3);

        boolean actual = list1.equals(list2);

        assertFalse(actual);
    }

    @Test
    public void equalsTest_whenInvokedOfAListWithNullElementsAndEqualingToListWithSameElements_thenShouldReturnTrue() {
        List<Integer> list1 = ListFactory.of(null, 2, 3);
        List<Integer> list2 = ListFactory.of(null, 2, 3);

        boolean actual = list1.equals(list2);

        assertTrue(actual);
    }

    @Test
    public void equalsTest_givenNotSameInstanceObject_thenShouldReturnFalse() {
        Nil<Integer> nil = new Nil<>();
        List<Integer> list = ListFactory.of(1);

        boolean actual = list.equals(nil);

        assertFalse(actual);
    }

    @Test
    public void equalsTest_givenNullParam_thenShouldReturnFalse() {
        List<Integer> list = ListFactory.of(1);

        boolean actual = list.equals(null);

        assertFalse(actual);
    }

}
