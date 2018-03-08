# Custom List Library.
This library allows you to create a List in java, it is similar to the Java.util.List,  
but provides some additional methods.
## Motivation:

I wrote this project as apart of my _java_ exercise.  

## Usage: 
Below i will show you some examples of how to use this library.
- To create a List of any object use the helper method of(), implemented in the static ListFactory class :

```java  
List<Integer> integerList = ListFactory.of(1, 2, 3);  // integerList = List(1, 2, 3);
```   
```java
List<String> stringList = ListFactory.of("a", "b", "c"); // stringList = List("a", "b", "c");
```
- To create an empty List, use the helper method empty(), implemented in the ListFactory class.
```java
List emptyList = ListFactory.empty(); // emptyList = List();  

// you can also use the of() helper:
List emptyList = ListFactory.of(); // emptyList = List();
```
- You can get the first element of the List by calling the head() method, or the headOption() method : 
 
```java
int head = ListFactory.of(1, 2, 3).head(); // head = 1;
// note: this method may throw exception if the List is empty.

// -- Prerequisites - java 8 --
Optional head =  ListFactory.of(1, 2, 3).headOption() // head = Optional[1].
Optional emptyHead = ListFactory.empty().headOption() // emptyHead = Optional.empty.
```
- You can get all of the List elements except the first one by calling the tail() method :

```java
List<Integer> tail = ListFactory.of(1, 2, 3).tail() // tail = List(2, 3);
// note: this method may throw exception if the List is empty. 
```
- You can get an element by providing its position in the List, either by calling the at() or the apply() method :

```java
int element1 =  ListFactory.of(1, 2, 3).at(1); // element1 = 2;
int element2 =  ListFactory.of(1, 2, 3).apply(1); // element2 = 2;
// note: both of this methods may throw exception when the List is empty.
```
- You can remove an element by providing its index in the List :

```java
List<Integer> list = ListFactory.of(1, 2, 3).remove(1); // list = List(1, 3).
// note: this method may throw exception if no element found in the provided index,   
// e.g. list.remove(-1)/list.remove(3).
```
- You can filter Your List by calling the filter() method :

```java
List<Integer> filteredList =  ListFactory.of(1, 2, 3).filter(i -> i % 2 == 0); // filteredList = List(2);
```
- You can apply for each element in the List any operation using the map() method.
```java
List<String> mappedList =  ListFactory.of(1, 2, 3).map(i -> i + "!"); // mappedList = List(1!, 2!, 3!);
```

