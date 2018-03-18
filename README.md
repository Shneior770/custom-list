# Custom List Library

This library allows you to create a List in java. It is similar to the `java.util.List`,  
but provides some additional higher-order methods.  

## Motivation:

I wrote this project as apart of my _java_ exercise.  

## Prerequisites:

[Java 8+](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)

## Usage: 

Below i will show you some examples of how to use this library.

- To create a List of any object first import the appropriate packages and then use the helper method `of()`, implemented in the static `ListFactory` class:

```java
import com.innovid.shneior.ListFactory;  
import com.innovid.shneior.List;  

List<Integer> integerList = ListFactory.of(1, 2, 3);  // integerList = List(1, 2, 3)
List<String> stringList = ListFactory.of("a", "b", "c"); // stringList = List("a", "b", "c")
```   

- To create an empty List, use the helper method `empty()`, implemented in the ListFactory class:
```java
List emptyList = ListFactory.empty(); // emptyList = List()

// You can also use the of() helper, providing an empty args list:
List emptyList = ListFactory.of(); // emptyList = List()
```

- You can get the first element of the List by calling the `head()` method, or the `headOption()` method: 
```java
// calling head():
int head = ListFactory.of(1, 2, 3).head(); // head = 1
// note: this method will throw an exception if the List is empty:
// ListFactory.empty().head; // throws NoSuchElementException("head of empty list")

// calling headOption():
Optional<Integer> head =  ListFactory.of(1, 2, 3).headOption() // head = Optional[1]
Optional emptyHead = ListFactory.empty().headOption() // emptyHead = Optional.empty
```

- You can get all of the List elements except the first one by calling the `tail()` method:
```java
List<Integer> tail = ListFactory.of(1, 2, 3).tail() // tail = List(2, 3)
// note: this method will throw an exception if the List is empty:
ListFactory.empty().tail(); // throws UnsupportedOperationException("tail of empty list") 
```

- You can add an element to the end of the List by calling the `add()` method:
```java
List<Integer> integerList = ListFactory.of(1, 2, 3).add(4) // integerList = List(1, 2, 3, 4)
List<Integer> numbers = ListFactory.empty().add(1).add(2).add(3); // numbers = List(1, 2, 3) 
```

- You can add an element to the start of the List by calling the `prepend()` method:
```java
List<Integer> integerList = ListFactory.of(1, 2, 3).prepend(0); // integerList = List(0, 1, 2, 3)
List<Integer> zeroList = ListFactory.empty().prepend(0); // zeroList = List(0)
```

- You can apply a method for each element in the List by calling the `forEach()` method:
```java
ListFactory.of(1, 2, 3).foreach(i -> System.out.print("i is " + i + ", ")); // prints: i is 1, i is 2, i is 3,
// note: this method will affect nothing when invoked on an empty List
``` 

- You can append one List to another by calling the `concat()` method:
```java
List<String> list =  ListFactory.of("a", "b", "c").concat(ListFactory.of("d", "e"); // list = List(a, b, c, d, e)
List<String> abc =  ListFactory.empty().concat(ListFactory.of("a", "b", "c"); // abc = List(a, b, c)
```

- You can get an element by providing its index in the List, either by calling the `at()` or the `apply()` method:
```java
String element1 =  ListFactory.of("a", "b", "c").at(1); // element1 = a
String element2 =  ListFactory.of("a", "b", "c").apply(1); // element2 = a
// note: both of this methods will throw an exception when the List is empty:
ListFactory.empty().at(0); // throws IndexOutOfBoundsException
```

- You can remove an element by calling the `remove()` method, providing its index in the List:
```java
List<String> list = ListFactory.of("a", "b", "c").remove(1); // list = List(a, c)
// note: this method will throw an exception if no element found at the provided index, 
// e.g. list.remove(-1)/list.remove(3)
```

- You can filter your List by calling the `filter()` method:
```java
List<Integer> filteredList =  ListFactory.of(1, 2, 3).filter(i -> i % 2 == 0); // filteredList = List(2)
```

- You can apply for each element in the List any operation using the `map()` method, and get a transformed list:
```java
List<String> mappedList =  ListFactory.of(1, 2, 3).map(i -> i + "!"); // mappedList = List(1!, 2!, 3!)
```

- You can take the first n elements from List by calling the `take()` method:
```java
List<String> list = ListFactory.of("a", "b", "c").take(2); // list = List(a, b)
// note: this method will throw an exception the provided n is less then 0,   
// e.g. list.take(-1)
```   
This method will return all this List elements if the List has less then n elements:  
```java
List<String> list = ListFactory.of("a", "b", "c").take(4) // list = List(a, b, c)
```

- You can drop n elements from the start of the List by calling the `drop()` method:
```java
List<String> list = ListFactory.of("a", "b", "c").drop(2); // list = List(c)
// note: this method will throw an exception if the provided n is less then 0,   
// e.g. list.drop(-1)
```
This method will return an empty List if this List has less then n elements: 
```java
List<String> list = ListFactory.of("a", "b", "c").drop(4); // list = List()
```   

- You can get the longest prefix of the List whose elements all satisfy the provided predicate of the `takeWhile()`  
 method: 
```java
List<Integer> list = ListFactory.of(2, 4, 7, 8).takeWhile(i -> i % 2 == 0); // list = List(2, 4)
// note: method will return an empty List when invoked on an empty List
```

- You can call the `flatMap` method which builds a new List by applying a function to all elements of this list  
 and using the elements of the resulting Lists:
 ```java
List<String> list = ListFactory.of("a", "b", "c").flatMap(s -> ListFactory.of(s.toLowerCase(), s.toUpperCase()));  
// list = List("a", "A", "b", "B", "c", "C")  
// note: when invoked from an empty List, this method will return an empty List 
```

- You can fold left all of the List elements by calling the `foldLeft()` method:
```java
String folded = ListFactory.of(1, 2, 3).foldLeft("!", ((acc, integer) -> acc + integer)); // folded = List(!123)  
// note: this method will return a result of the start value(acc) type  
// also this method will return the start value when invoked on an empty List
```

- Each operation method returns a new List so you can chain one operation to another and get the final result:
```java
String result = list.filter(i -> i % 2 == 0).take(10).map(i -> i + "!").toString();
```