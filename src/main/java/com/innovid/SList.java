package com.innovid;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public interface SList<T>{

    T head();
    SList<T> tail();
    SList<T> filter(Predicate<T> predicate);
    SList<T> map(MyFunctionalInterface functionalInterface);
    boolean isEmpty();
    boolean nonEmpty();
    long size();
    T at(int index);
    SList<T> take(int n);
    SList<T> drop(int n);
    T apply(int n);
    Optional<T> headOption();
    SList<T> takeWhile(Predicate<T> predicate);
    String getString();
    T foldLeft(T acc, BinaryOperator<T> operator);
    SList<T> remove(int index);
    boolean equals(Object object);
}
