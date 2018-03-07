# Custom List

## Motivation:

i wrote this project as apart of my _java_ exercise.  

## Usage:
- To create a List of any object use the of() method of the static ListFactory class :

```java
// creates a List of integers with integers arguments :  
List<Integer> integerList = ListFactory.of(1, 2, 3);  
```   
```java
// creates a List of Strings with strings arguments:
List<Integer> stringList = ListFactory.of("a", "b", "c");
```
```java
// creates an empty List : 
List<Integer> emptyList = ListFactory.of();
// emptyList = List();
```
- You can get the first element of the list by calling the head() method, or the headOption() method : 
 
```java
// throws exception if the list is empty.
int head = ListFactory.of(1, 2, 3).head(); // head = 1;

// -- Prerequisites - java 8 --
Optional<Integer> head =  ListFactory.of(1, 2, 3).headOption() // head =  Optional[1].
// note : if the list is empty - returns an emptyOptional.
```
- You can get all of the list elements except the first one by calling tail() method :

```java
List<Integer> tail = ListFactory.of(1, 2, 3).tail() // throws exception if the list is empty. 
// tail = List(2, 3);
```
- You can filter Your List by calling the filter() method :
```java
List<Integer> filteredList =  ListFactory.of(1, 2, 3).filter(i -> i % 2 == 0); 
// filteredList = List(2);
```
- You can apply for each element any operation using the map() method.
```java
List<String> mappedList =  ListFactory.of(1, 2, 3).map(i -> i + "!"); 
// mappedList = List(1!, 2!, 3!);
```
- You can get a particular element by calling the at() or the apply() method :
```java
int specificElement =  ListFactory.of(1, 2, 3).at(1); 
int specificElement =  ListFactory.of(1, 2, 3).apply(1); 
// specificElement = 2;
// note that both at and apply methods may throw exception when the list is empty.
```