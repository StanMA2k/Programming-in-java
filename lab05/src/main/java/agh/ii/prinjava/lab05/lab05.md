1) Java Collections Framework - selected interfaces

Iterator, ListIterator, Iterable, Collection, List, Set/SortedSet, Queue/Deque, Map/SortedMap

Exercises

Familiarise yourself with The Java Tutorials > Collections

Familiarise yourself with the following interfaces:

Iterator: provides methods as following
- hasNext(): return a boolean to show an iterator has more element, return "true" if it has more element
- next(): return the next element of the iterator, if there are no more elements, then throws 'NoSuchElementException'
- remove(): delete the last returned element. example:
```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

Iterator<String> namesIterator = names.iterator();

while (namesIterator.hasNext()) {
    String name = namesIterator.next();
    System.out.println(name);
    if (name.equals("Bob")) {
        namesIterator.remove(); // Removes "Bob" from the list
    }
}
```

ListIterator: is an iterator specialised for lists. It inherits hasNext(),next() and remove(), and provides:

- hasPrevious() and previous(): These methods allow backward traversal of the list.
- nextIndex() and previousIndex(): return the index of next() or previous()
- add(E e)：insert element in the current position
- set(E e)：replace the last returned element of ListIterator

Iterable: provides iterator() method, which returns an Iterator instance. It may be expressed as For.

Collection: is a sub interface of Iterator. It provides methods as following:

- add(E e)
- remove(Object o)
- size()
- isEmpty()
- contains(Object o)
- iterator()
- clear(): clear all elements
- toArray()

List: some instance classes like LinedList, ArrayList

Set: doesn't have orders
- hashSet:
```java
Set<String> fruits = new HashSet<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Orange");

// only for new elements
boolean isAdded = fruits.add("Apple"); // return false
        
for (String fruit : fruits) {
    System.out.println(fruit);
}
```
- LinkedHashSet
- TreeSet

SortedSet: has orders, and needs following methods to realize

- comparator()
- first()
- last()
- headSet(E toElement): < toElement。
- tailSet(E fromElement): >= fromElement。
- subSet(E fromElement, E toElement): return elements fromElement(include) to toElement(no included)

Queue: FIFO

Deque: double ended queue, it has specified methods to manipulate head and tail of the queue

Map: Map provides a data structure to store key-value pairs, where each key can map to at most one value. This means that a Map can uniquely determine a value by its key, thus enabling fast lookup, update, and delete operations.

SortedMap: 
```java
SortedMap<Integer, String> sm = new TreeMap<>();
sm.put(3, "Three");
sm.put(1, "One");
sm.put(4, "Four");
sm.put(2, "Two");

// sort the numbers automaticlly：1, 2, 3, 4
for (Map.Entry<Integer, String> entry : sm.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

```

Look briefly at the Java Collections Framework class diagram
(e.g., here)

2) List<E> and its two implementations: ArrayList<E>, LinkedList<E>

Analyse the source code in package lst05_01

Exercises

Suppose lList is a LinkedList that contains a million int values. Which of the following two loops will run faster? The second one is faster 
```java
sum = 0;
for (int i = 0; i < lList.size(); i++)
sum += lList.get(i);
```
```java
sum = 0;
for (int e: lList)
sum += e;
```
Explain the printout of the following code: 1,2,4,5
```java
List<Integer> l1 = new ArrayList<>(List.of(1,2,3,4,5));
l1.remove(2);
System.out.println(l1);
```
Explain the printout of the following code: 1,3
```java
List<Integer> l2 = new ArrayList<>(List.of(1,2,3,4));
for (int i = 0; i < l2.size(); i++){
System.out.print(l2.remove(i));
}
```
Explain the difference between the following pieces of code: 
```java
Collection<Integer> l1 = new ArrayList<>(List.of(0, 1, 2));
for (int i = 0; i < 3; i++) {
System.out.println(l1.remove(i));
}
System.out.println(l1); //the output is "true true true []", the remove(Object o) in Collection removes the same value of i in the list, not the index
```
```java
List<Integer> l2 = new ArrayList<>(List.of(0, 1, 2));
for (int i = 0; i < 3; i++) {
System.out.println(l2.remove(i));
}
System.out.println(l2); //the output is 0,2, the remove() of List is based on index, after first loop the list becomes: (0(index0),1(index1),2(index2)) -> (0(index1),1(index2))
```


3) Iterators, the for-each loop (aka. enhanced for loop), and forEach method

Analyse the source code in package lst05_02

Exercises

Familiarise yourself with the Iterator (design) pattern

Rewrite the following piece of code

```java
List<Integer> lst = List.of(1,2,3,4,5);
for (int i = 0; i < lst.size(); i++) {
    System.out.println(lst.get(i));
}
```
using subsequently:

iterator and the while-loop
```java
List<Integer> lst = List.of(1,2,3,4,5);
Iterator<Integer> it = lst.iterator();
while (it.hasNext()){
    System.out.println(it.next());
}
```
iterator and the for-loop
```java
List<Integer> lst = List.of(1,2,3,4,5);
for (Iterator<Integer> it = lst.iterator(); it.hasNext(); ) {
    System.out.println(it.next());
}


```
enhnaced for-loop
```java
List<Integer> lst = List.of(1,2,3,4,5);
for (Iterator<Integer> it = lst.iterator(); it.hasNext(); ) {
    System.out.println(it.next());
}
```
forEach method
```java
List<Integer> lst = List.of(1, 2, 3, 4, 5);
for (Integer num : lst) {
    System.out.println(num);
}

```
4) Queue<E>, Deque<E> and their implementations: PriorityQueue<E>, and ArrayDeque<E>

Analyse the source code in package lst05_03

Exercises

Familiarise yourself with:

PriorityQueue: is a ordered queue, its order depends on comparator or natural order of the elements. 
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(10);
pq.add(20);
pq.add(15); //now the queue is 10,15,20

// head is 10
System.out.println(pq.peek()); // output 10
pq.remove(); // remove 10

// head is 15
System.out.println(pq.peek()); // output 15

```
ArrayDeque: array double ended queue, it can be used as stack or queue, 

Explain the execution result of the following method

```java
private static void m() {
        Queue<Integer> pq = new PriorityQueue<>(List.of(6, 1, 5, 3, 4, 2));
        for (int e : pq)
        System.out.print(e + " ");

        System.out.println();

        while (!pq.isEmpty())
        System.out.print(pq.poll() + " ");
}
```
The output is 1 3 2 6 4 5\n1 2 3 4 5 6. In for (int e : pq); System.out.print(e + " ");, the output doesn't follow the order. In  while (!pq.isEmpty())
System.out.print(pq.poll() + " "); the output follows the order(poll() take out the most small elem everytime)

5) java.lang.Comparable and java.util.Comparator

Analyse the source code in package lst05_04

Exercises

Familiarise yourself with the following interfaces:

Comparable: when a class realizes the Comparable interface, it means the instance of this class can be sorted. compareTo(T o): return < 0, this.o before o; return 0, this.o = 0; return > 0, this.o after o;

Comparator: compare(T o1, T o2): return < 0, o1 before o2; return 0, o1 = o2; return > 0, o1 after o2;

Check if the following code is correct: not correct
```java
static Object max(Object o1, Object o2) {
if ((Comparable) o1.compareTo(o2) >= 0) {
return o1;
} else {
return o2;
}
}
```
If not, fix the error.
```java
static Object max(Comparable o1, Object o2) {
    if (o1.compareTo(o2) >= 0) {
        return o1;
    } else {
        return o2;
    }
}

```

Fill in the following code to create a Comparator for two strings in decreasing order of their length

```java
private static void m() {
String[] cities = {"Copenhagen", "Warsaw", "Budapest"};
Arrays.sort(cities, (city1, city2) -> city2.compareTo(city1));
System.out.println(Arrays.toString(cities));
}
```
6) Set<E> and its implementations: HashSet<E>, LinkedHashSet<E>, TreeSet<E>, and EnumSet<E extends Enum<E>>

Analyse the source code in package lst05_05

Exercises

Explain the key differences between the four implementations of the Set interface: 

- HashSet: elements don't have order; 
- LinkedHashSet: elems sorted as input;
- TreeSet: elems sorted by nature order; 
- EnumSet：can indicate a range 

Explain how to compute the union, intersection, and difference of two sets, using just the methods of the Set interface and without using loops:
```java
Set<Type> set1 = new HashSet<>(Arrays.asList(...));
Set<Type> set2 = new HashSet<>(Arrays.asList(...));
set1.addAll(set2); // union of set1 and set2
set1.retainAll(set2); //intersection of set1 and set2
set1.removeAll(set2); //difference
```
Write a function that takes a TreeSet of strings and returns a new TreeSet with each string being transformed to uppercase

[optional] Compare the performance of methods add, remove, and contains for the four implementations of Set interface
7) Map<K,V> and its implementations: HashMap<K,V>, LinkedHashMap<K,V>, TreeMap<K,V>, and EnumMap<K extends Enum<K>,V>

Analyse the source code in package lst05_06

Exercises

Explain the key differences between the four implementations of the Map interface

- lhm: elems sorted by insert order
- hm: elems not sorted 
- tm:elems sorted by nature order;
- em: every key is the enumeration value of a single enumeration type.

Write a program that reads all words in a file and prints out how often each word occurred. Use a TreeMap<String, Integer>


[optional] Write a program that reads all words in a file and prints out on which line(s) each of them occurred. Use a map from strings to sets
8) Selected algorithms from java.util.Collections and java.util.Arrays

Analyse the source code in package lst05_07

Exercises

Familiarize yourself with the methods of Collections and Arrays utility classes

Explain why binarySearch algorithm requires sorted data:
Binary search needs to be based on sorted data because it needs to compare the target value with the medium value of the dataset to decide which sub set it will continue searching.
If the data are not sorted, the medium value can't be a criterion to divide sub set。

Explain the difference between linear search and binary search in terms of the time complexity
- Linear search will check every value of the set, it doesn't need a sorted dataset. If the data is sorted, binary search is more effective; if not, linear search is more effective
[optional] Compare experimentally the performance of these algorithms
