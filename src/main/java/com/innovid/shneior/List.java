package com.innovid.shneior;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface List<T> {
    /**
     * This method returns the first element of the List.
     * @return the first element of this list */
    T head();

    /**
     * This method returns all the List elements, except the first one.
     * @return all the elements of this list except the first element */
    List<T> tail();

    /**
     * This method returns a filtered List of all the elements who's satisfy the predicate.
     * @return a new  list consisting of all the element whose satisfy the given predicate.
     * <b>example :</b> for an integer list contains (1, 2, 3, 4) you can do :
     * numbers.filter(i -> i % 2 == 0) and then get a result of list contains 2, 4
     * */
    List<T> filter(Predicate<T> predicate);

    /** This method returned a mapped List of all the elements who's satisfy the predicate.
     * @return a new list consisting of all the mapped elements.
     * <b>example :</b> for an integer list contains (1, 2, 3) you can do :
     * numbers.map(i -> i + 1) and then get a result of list contains 2, 3, 4.
     */
    <R> List<R> map(Function<T, R> function);

    /**
     * This method Returns the status of the List.
     * @return true for an empty list, false a non empty list.
     */
    boolean isEmpty();

    /**
     * This method Returns the status of the List.
     * @return true for a non empty list, false an empty list.
     */
    boolean nonEmpty();

    /** This method Returns the size of the List.
     * @return the size of this list.
     */
    long size();

    /**
     * This method returns a element based of its index in the List.
     * @param index the index of the element.
     * @returns the desired element of the list if exist.
     */
    T at(int index);

    /**
     * This method returns a List consist of all the elements from the first element to n.
     * @param n the number of elements to take from the head of this list.
     * @return a list consist of the desired elements.
     */
    List<T> take(int n);

    /**
     * This method returns a List consist of all the elements from the n element
     * to the end of the List.
     * @param n the number of elements to drop from the head of this list.
     * @return a list consist of the desired elements.
     */
    List<T> drop(int n);

    /**
     * This method returns a element based of its index in the List (alias to at()).
     * @param index the index of the element.
     * @return the desired element of the list if exist.
     */
    T apply(int index);

    /** This method returns an Optional of the head in the List.
     * @return a Optional of head, if the list is empty
     * returns an Optional.empty.
     */
    Optional<T> headOption();

    /**
     * This method returns a List consist of all the prefix element who's satisfy the predicate.
     * @param predicate to apply of the elements of this list.
     * @return new list consist of the longest prefix of the list whose elements all satisfy the predicate.
     * <b>example :</b> for an integer list contains (1, 2, 3, 4) you can do :
     * numbers.takeWhile(i -> i % 2 == 0) and then get a result of list contains 2.
     */
    List<T> takeWhile(Predicate<T> predicate);

    /**
     * This method returns unformatted String of the List.
     * @return unformatted String of this list Elements,
     * <b>example :</b> "1, 2, 3,";
     * if the list is empty returns an empty string.
     */
    String getString();

    /**
     * This method returns the result of the accumulator operated of each element in the List.
     * @param acc the accumulator to start with.
     * @param operator the operator to apply for each element in this list.
     * @param <R> the type of the accumulator and the return type of the operator.
     * @return R the result of operation.
     * <b>example :</b> for an integer list contains (1, 2, 3) you can do :
     * numbers.foldLeft("!",(i, j) -> acc + j) and then get a result a String contains "!123".
     */
    <R> R foldLeft (R acc, BiFunction<R, T, R> operator);

    /**
     * This method returns a List of all the elements except of the element in the index passed.
     * @param index the index of the undesired element.
     * @return a new list consist of all desired elements.
     */
    List<T> remove(int index);

    /**
     * // This method equals between this List elements and the object passed.
     * @param object the object to be checked.
     * @return true if all the element in this list are the same as the Object, otherwise false.
     */
    boolean equals(Object object);

    /**
     * This method add the provided item to the end of this List.
     * @param item the item to add to the List.
     * @return a new List contains of all the desired elements.
     */
    List<T> add(T item);

    /**
     * This method add the provided element to the start of this List.
     * @param item the item to add to the List.
     * @return a new List contains of all the desired elements.
     */
    List<T> prepend(T item);

    /**
     * This method returns a flatted List for a given function.
     * @param function the function to be applied for each element of the List.
     * @param <R> this method may return a List of <R>.
     * @return a new List consist of all the desired elements.
     */
    <R> List<R> flatMap(Function<T, List<R>> function);

    /**
     * This method returns a new List consist of the current List and the provided List.
     * @param other an other List to be added to the end of the current List.
     * @return a new List consist of all the desired elements.
     */
    List<T> union(List<T> other);
}
