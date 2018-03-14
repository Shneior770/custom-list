package com.innovid.shneior;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Nil<T> implements List<T> {

    @Override
    public T head() {
       throw new IllegalArgumentException();
    }

    @Override
    public List<T> tail() {
        throw new IllegalArgumentException();
    }

    @Override
    public List<T> filter(Predicate<T> predicate) {
        return this;
    }

    @Override
    public <R> List<R> map(Function<T, R> function) {
        return new Nil<>();
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
    public List<T> take(int index) {
        return this;
    }

    @Override
    public List<T> drop(int n) {
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
    public List<T> takeWhile(Predicate<T> predicate ) {
        return this;
    }

    @Override
    public String getString() {
        return "";
    }

    @Override
    public <R> R foldLeft(R acc, BiFunction<R, T, R> operator) {
        return acc;
    }


    @Override
    public List<T> remove(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return "List()";
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Nil)) {
            return false;
        }
        return true;
    }

    @Override
    public List<T> add(T item) {
        return new Cons<>(item, new Nil<>());
    }

    @Override
    public List<T> prepend(T item) {
        return new Cons<>(item, new Nil<>());
    }

    @Override
    public <R> List<R> flatMap(Function<T, List<R>> function) {
        return new Nil<>();
    }

    @Override
    public List<T> union(List<T> other) {
        return other;
    }
}
