package com.innovid;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Nil<T> implements SList<T> {

    @Override
    public T head() {
       throw new IllegalArgumentException();
    }

    @Override
    public SList<T> tail() {
        throw new IllegalArgumentException();
    }

    @Override
    public SList<T> filter(Predicate<T> predicate) {
        return this;
    }

    @Override
    public SList<T> map(MyFunctionalInterface functionalInterface) {
        return this;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean nonEmpty() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public T at(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public SList<T> take(int index) {
        return this;
    }

    @Override
    public SList<T> drop(int n) {
        return this;
    }

    @Override
    public T apply(int n) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Optional<T> headOption() {
        return Optional.empty();
    }

    @Override
    public SList<T> takeWhile(Predicate<T> predicate ) {
        return this;
    }

    @Override
    public String getString() {
        return "";
    }

    @Override
    public T foldLeft(T acc, BinaryOperator<T> operator) {
        return acc;
    }

    @Override
    public SList<T> remove(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return "SList()";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Nil)) {
            return false;
        }
        return true;
    }

}
