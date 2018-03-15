package com.innovid.shneior;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Cons<T> implements List<T> {

    private final T head;
    private final List<T> tail;

    Cons(T head, List<T> tail) {
      this.head = head;
      this.tail = tail;
}

    @Override
    public T head() {
        return head;
    }

    @Override
    public List<T> tail() {
        return tail;
    }

    @Override
    public List<T> filter(Predicate<T> predicate) {

        if (predicate.test(head)) {
            return new Cons<>(head, tail.filter(predicate));
        } else {
           return tail.filter(predicate);
        }
    }

    @Override
    public <R> List<R> map(Function<T, R> function) {
        R mappedElement = function.apply(head);
        List<R> mappedTail = tail.map(function);
        return new Cons<>(mappedElement, mappedTail);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean nonEmpty() {
        return true;
    }

    @Override
    public long size() {
        return 1 + tail.size();
    }

    @Override
    public T at(int n) {

        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n == 0) {
            return head;
        }
        return tail.at(-- n);
    }

    @Override
    public List<T> take(int n) {

        if (n == 0) {
            return new Nil<>();
        }
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }

        return new Cons<>(head, tail.take(-- n));
    }

    @Override
    public List<T> drop(int n) {

        if (n == 0) {
            return this;
        }
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }

        return tail.drop(-- n);

    }

    @Override
    public T apply(int n) {
        return at(n);
    }

    @Override
    public Optional<T> headOption() {
        return Optional.of(head);
    }

    @Override
    public List<T> takeWhile(Predicate<T> predicate) {

        if (predicate.test(head)) {
          return new Cons<>(head, tail.takeWhile(predicate));
        }

        return new Nil<>();
    }

    @Override
    public String toString() {
        String str = getString();
        String formatString = str.substring(0, str.length() - 2);

      return String.format("List(%s)", formatString);
    }

    public String getString() {
        return head + ", " + tail.getString();
    }

    @Override
    public <R> R foldLeft(R acc, BiFunction<R, T, R> operator) {
        R result = operator.apply(acc, head);
        return tail.foldLeft(result, operator);
    }

 @Override
    public List<T> remove(int index) {

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return tail;
        }
        return new Cons<>(head, tail.remove(-- index));
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cons<?> cons = (Cons<?>) o;
        return Objects.equals(head, cons.head) &&
                Objects.equals(tail, cons.tail);
    }

    @Override
    public List<T> add(T item) {
        return new Cons<>(head, tail.add(item));
    }

    @Override
    public List<T> prepend(T item) {
        return new Cons<>(item, this);
    }

    @Override
    public <R> List<R> flatMap(Function<T, List<R>> function) {
        List<R> list = function.apply(head);

        return list.union(tail.flatMap(function));

    }

    @Override
    public List<T> union(List<T> other) {
        return new Cons<>(head, tail.union(other));
    }

    @Override
    public void forEach(Consumer<T> consumer) {
        consumer.accept(head);
        tail.forEach(consumer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }

}
