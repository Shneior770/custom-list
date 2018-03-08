package com.innovid.shneior;

/**
 * a factory class that heave methods
 * for creating non empty or empty List.
 */
public class ListFactory {

    /**
     *  This method is a helper that construct a new Instance of
     *  a List for the given arguments.
     * @param args the arguments to initialize the List with.
     * @param <T>  the type of the List
     * @return a List consist of the given arguments.
     */
    public static <T> List<T> of(T... args) {
      return get(args, 0);
    }

    private static <T> List<T> get(T[] args, int num) {
        if (num == args.length) {
            return new Nil<>();
        }
        return new Cons<>(args[num], get(args, num + 1));
    }

    /**
     * This method creates an Empty List.
     * @return empty List.
     */
    public static Nil empty() {
        return new Nil();
    }
}

