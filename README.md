# Custom List Library.

## Motivation:

i wrote this project as apart of my _java_ exercise.  

## Usage: 
below i will show you some examples of how to use this library.
- To create a List of any object use the helper method of(), implemented in the static ListFactory class :

```java
// creates a List of integers :  
List<Integer> integerList = ListFactory.of(1, 2, 3);  // integerList = List(1, 2, 3);
```   
```java
// creates a List of Strings :
List<String> stringList = ListFactory.of("a", "b", "c"); // stringList List("a", "b", "c");
```
```java
// creates an empty List : 
List<Integer> emptyList = ListFactory.of(); // emptyList = List();
```
- You can get the first element of the list by calling the head() method, or the headOption() method : 
 
```java
int head = ListFactory.of(1, 2, 3).head(); // head = 1;
// note: this method may throw exception if the list is empty.

// -- Prerequisites - java 8 --
Optional<Integer> head =  ListFactory.of(1, 2, 3).headOption() // head =  Optional[1].
Optional<Integer> emptyHead =  ListFactory.of().headOption() // emptyHead =  Optional.empty.
```
- You can get all of the list elements except the first one by calling the tail() method :

```java
List<Integer> tail = ListFactory.of(1, 2, 3).tail() // tail = List(2, 3);
// note: this method may throw exception if the list is empty. 
```
- You can filter Your List by calling the filter() method :
```java
List<Integer> filteredList =  ListFactory.of(1, 2, 3).filter(i -> i % 2 == 0); // filteredList = List(2);
```
- You can apply for each element in the list any operation using the map() method.
```java
List<String> mappedList =  ListFactory.of(1, 2, 3).map(i -> i + "!"); // mappedList = List(1!, 2!, 3!);
```
- You can get an element by providing he's position in the list, either by calling the at() or the apply() method :
```java
int element1 =  ListFactory.of(1, 2, 3).at(1); // element1 = 2;
int element2 =  ListFactory.of(1, 2, 3).apply(1); // element2 = 2;
// note that both at and apply methods may throw exception when the list is empty.
```
- You can remove an element by providing he's position in the list :
```java
List<Integer> list = ListFactory.of(1, 2, 3).remove(1); // list = List(1, 3).
// note: this method may throw exception if the providing number is not exist in the list. e.g. list.remove(-1).
```