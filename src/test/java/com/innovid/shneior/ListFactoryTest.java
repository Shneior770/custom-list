package com.innovid.shneior;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class ListFactoryTest {

    @Test
    public void ofTest_givenParams_shouldReturnSListOfTheGivenParams() {
        List<Integer> expected = ListFactory.of(1, 2, 3);

        List<Integer> actual = ListFactory.of(1, 2, 3);

        assertEquals(expected, actual);
    }

    @Test
    public void ofTest_givenNoParams_shouldReturnNil() {
        List<Integer> expected = new Nil<>();

        List<Integer> actual = ListFactory.of();

        assertEquals(expected, actual);
    }

    @Test
    public void ofTest_givenANullParam_shouldReturnListOfTheElementsWithTheNullParam() {
        List<Integer> head = new Cons<>(3, new Nil<>());
        List<Integer> tail = new Cons<>(null, head);
        List<Integer> expected = new Cons<>(1, tail);

        List<Integer> actual = ListFactory.of(1, null, 3);

        assertEquals(expected, actual);
    }
}
