package com.innovid;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class Cons<T> implements SList <T> {

    private T head;

    private SList<T> tail;

    public Cons(T head, SList<T> tail) {
      this.head = head;
      this.tail = tail;
}

    @Override
    public T head() {
        return head;
    }

    @Override
    public SList<T> tail() {
        return tail;
    }

    @Override
    public SList<T> filter(Predicate<T> predicate) {
        if (predicate.test(head)) {
            SList<T> filteredTail = tail.filter(predicate);
            Cons<T> r = new Cons<>(head, filteredTail);
            return r;
        } else {
           return tail.filter(predicate);
        }
    }

    @Override
    public SList<T> map(MyFunctionalInterface functionalInterface) {
        head  = (T)functionalInterface.test(head);
        SList<T> mappedTail = tail.map(functionalInterface);
        return new Cons<T>(head, mappedTail);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean nonEmpty() {
        return true;
    }

//    @Override
//    public boolean isEmpty() {
//        if (head == null) {
//            return tail.isEmpty();
//        }
//
//        return false;
//    }

//    @Override
//    public boolean nonEmpty() {
//        if (head == null) {
//            return tail.nonEmpty();
//        }
//        return true;
//    }


    @Override
    public long size() {
    return tail.size() + 1;
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
    public SList<T> take(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n == 1) {
            return new Cons<T>(head, new Nil<>());
        }
        else {
             return new Cons<T>(head, tail.take(-- n));
        }
    }

    @Override
    public SList<T> drop(int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n == 1) {
            return tail;
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
    public SList<T> takeWhile(Predicate<T> predicate) {
       if (predicate.test(head)) {
          return new Cons<T>(head, tail.takeWhile(predicate));
       }
       return new Nil<>();
    }

    @Override
    public String toString() {
        String str = getString();
        String formatString = str.substring(0, str.length() - 2);

      return String.format("SList(%s)", formatString);
    }

    public String getString() {
        return head.toString() + ", " + tail.getString();
    }

    @Override
    public T foldLeft(T acc, BinaryOperator<T> operator) {
      T result = operator.apply(acc, head);

      return tail.foldLeft(result, operator);
    }

    @Override
    public SList<T> remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return tail;
        }
        return new Cons<T>(head, tail.remove(-- index));
    }

    public static<T> SList<T> of(T... args) {
        return get(args, 0);
    }

    private static <G> SList<G> get(G[] args, int num) {
        if (num == args.length) {
            return new Nil<>();
        }
        return new Cons<G>(args[num], get(args, num + 1));
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Cons)) {
            return false;
        }
        SList<T> list = (SList<T>) object;
        if (this.head.equals(list.head())) {
            return tail.equals(list.tail());
        }
        return false;
    }

}
