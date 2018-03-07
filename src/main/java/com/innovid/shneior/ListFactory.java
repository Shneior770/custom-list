package com.innovid.shneior;

/**
 * a factory class that heave a method
 * for creating empty or non empty List.
 */
public class ListFactory {

    /**
     * an helper for creating a List.
     * example : ListFactory.of(1, 2, 3) ==> list:1,2,3;
     * ListFactory.of() ==> list:();
     */
    public static <T> List<T> of(T... args) {
      return get(args, 0);
    }

    private static <T> List<T> get(T[] args, int num) {
        if (num == args.length) {
            return new Nil<>();
        }
        return new Cons<T>(args[num], get(args, num + 1));
    }

}

