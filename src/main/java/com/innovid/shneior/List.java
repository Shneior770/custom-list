package com.innovid.shneior;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface List<T>{
    T head();
    List<T> tail();
    List<T> filter(Predicate<T> predicate);
    <R> List<R> map(Function<T, R> function);
    boolean isEmpty();
    boolean nonEmpty();
    long size();
    T at(int index);
    List<T> take(int n);
    List<T> drop(int n);
    T apply(int n);
    Optional<T> headOption();
    List<T> takeWhile(Predicate<T> predicate);
    String getString();
    <R> R foldLeft (R acc, BiFunction<R, T, R> operator);
    List<T> remove(int index);
    boolean equals(Object object);
}
