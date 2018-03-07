package com.innovid.shneior;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface List<T>{
    /** @returns the first element of this list */
    T head();

    /** @returns all the elements of this list except the first element */
    List<T> tail();

    /** @returns a new  list consisting of all the element whose satisfy the given predicate.
     * <b>example :</b> for an integer list contains (1, 2, 3, 4) you can do :
     * numbers.filter(i -> i % 2 == 0) and then get a result of list contains 2, 4
     * */
    List<T> filter(Predicate<T> predicate);

    /**
     * @returns a new list consisting of all the mapped elements.
     * <b>example :</b> for an integer list contains (1, 2, 3) you can do :
     * numbers.map(i -> i + 1) and then get a result of list contains 2, 3, 4.
     */
    <R> List<R> map(Function<T, R> function);

    /**
     * @return true for an empty list, false a non empty list.
     */
    boolean isEmpty();

    /**
     * @return true for a non empty list, false an empty list.
     */
    boolean nonEmpty();

    /**
     * @returns the size of this list.
     */
    long size();

    /**
     * @param index the index of the element.
     * @returns the desired element of the list if exist.
     */
    T at(int index);

    /**
     * @param n the number of elements to take from the head of this list.
     * @returns a list consist of the desired elements.
     */
    List<T> take(int n);

    /**
     * @param n the number of elements to drop from the head of this list.
     * @return a list consist of the desired elements.
     */
    List<T> drop(int n);

    /**
     * @param index the index of the element.
     * @returns the desired element of the list if exist.
     */
    T apply(int index);

    /**
     * @returns a Optional of head, if the list is empty
     * returns an Optional.empty.
     */
    Optional<T> headOption();

    /**
     * @param predicate to apply of the elements of this list.
     * @return new list consist of the longest prefix of the list whose elements all satisfy the predicate.
     * <b>example :</b> for an integer list contains (1, 2, 3, 4) you can do :
     * numbers.takeWhile(i -> i % 2 == 0) and then get a result of list contains 2.
     */
    List<T> takeWhile(Predicate<T> predicate);

    /**
     * @returns unformatted String of this list Elements,
     * if the list is empty returns an empty string.
     */
    String getString();

    /**
     * @param acc the accumulator to start with.
     * @param operator the operator to apply for each element in this list.
     * @param <R> the type of the accumulator and the return type of the operator.
     * @returns R the result of operation.
     * <b>example :</b> for an integer list contains (1, 2, 3) you can do :
     * numbers.foldLeft("!",(i, j) -> acc + j) and then get a result a String contains "!123".
     */
    <R> R foldLeft (R acc, BiFunction<R, T, R> operator);

    /**
     * @param index the index of the undesired element.
     * @return a new list consist of all desired elements.
     */
    List<T> remove(int index);

    /**
     * @param object the object to be checked.
     * @returns true if all the element in this list are the same as the Object, otherwise false.
     */
    boolean equals(Object object);
}
