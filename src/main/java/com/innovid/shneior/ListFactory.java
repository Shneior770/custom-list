package com.innovid.shneior;

public class ListFactory {

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

