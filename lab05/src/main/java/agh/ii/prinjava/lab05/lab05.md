1) Java Collections Framework - selected interfaces

Iterator, ListIterator, Iterable, Collection, List, Set/SortedSet, Queue/Deque, Map/SortedMap

Exercises

Familiarise yourself with The Java Tutorials > Collections

Familiarise yourself with the following interfaces:

Iterator
ListIterator
Iterable
Collection
List
Set
SortedSet
Queue
Deque
Map
SortedMap
Look briefly at the Java Collections Framework class diagram
(e.g., here)

2) List<E> and its two implementations: ArrayList<E>, LinkedList<E>

Analyse the source code in package lst05_01

Exercises

Suppose lList is a LinkedList that contains a million int values. Which of the following two loops will run faster?

sum = 0;
for (int i = 0; i < lList.size(); i++)
sum += lList.get(i);
sum = 0;
for (int e: lList)
sum += e;
Explain the printout of the following code:

List<Integer> l1 = new ArrayList<>(List.of(1,2,3,4,5));
l1.remove(2);
System.out.println(l1);
Explain the printout of the following code:

List<Integer> l2 = new ArrayList<>(List.of(1,2,3,4));
for (int i = 0; i < l2.size(); i++)
System.out.print(l2.remove(i));
Explain the difference between the following pieces of code:

Collection<Integer> l1 = new ArrayList<>(List.of(0, 1, 2));
for (int i = 0; i < 3; i++) {
System.out.println(l1.remove(i));
}
System.out.println(l1);
List<Integer> l2 = new ArrayList<>(List.of(0, 1, 2));
for (int i = 0; i < 3; i++) {
System.out.println(l2.remove(i));
}
System.out.println(l2);
3) Iterators, the for-each loop (aka. enhanced for loop), and forEach method

Analyse the source code in package lst05_02

Exercises

Familiarise yourself with the Iterator (design) pattern

Rewrite the following piece of code

List<Integer> lst = List.of(1,2,3,4,5);
for (int i = 0; i < lst.size(); i++) {
System.out.println(lst.get(i));
}
using subsequently:

iterator and the while-loop
iterator and the for-loop
enhnaced for-loop
forEach method
4) Queue<E>, Deque<E> and their implementations: PriorityQueue<E>, and ArrayDeque<E>

Analyse the source code in package lst05_03

Exercises

Familiarise yourself with:

PriorityQueue
ArrayDeque
Explain the execution result of the following method

private static void m() {
Queue<Integer> pq = new PriorityQueue<>(List.of(6, 1, 5, 3, 4, 2));
for (int e : pq)
System.out.print(e + " ");

     System.out.println();

     while (!pq.isEmpty())
         System.out.print(pq.poll() + " ");
}
5) java.lang.Comparable and java.util.Comparator

Analyse the source code in package lst05_04

Exercises

Familiarise yourself with the following interfaces:

Comparable
Comparator
Check if the following code is correct:

static Object max(Object o1, Object o2) {
if ((Comparable) o1.compareTo(o2) >= 0) {
return o1;
} else {
return o2;
}
}
If not, fix the error.

Fill in the following code to create a Comparator for two strings in decreasing order of their length

private static void m() {
String[] cities = {"Copenhagen", "Warsaw", "Budapest"};
Arrays.sort(cities, ___);
System.out.println(Arrays.toString(cities));
}
6) Set<E> and its implementations: HashSet<E>, LinkedHashSet<E>, TreeSet<E>, and EnumSet<E extends Enum<E>>

Analyse the source code in package lst05_05

Exercises

Explain the key differences between the four implementations of the Set interface
Explain how to compute the union, intersection, and difference of two sets, using just the methods of the Set interface and without using loops
Write a function that takes a TreeSet of strings and returns a new TreeSet with each string being transformed to uppercase
[optional] Compare the performance of methods add, remove, and contains for the four implementations of Set interface
7) Map<K,V> and its implementations: HashMap<K,V>, LinkedHashMap<K,V>, TreeMap<K,V>, and EnumMap<K extends Enum<K>,V>

Analyse the source code in package lst05_06

Exercises

Explain the key differences between the four implementations of the Map interface
Write a program that reads all words in a file and prints out how often each word occurred. Use a TreeMap<String, Integer>
[optional] Write a program that reads all words in a file and prints out on which line(s) each of them occurred. Use a map from strings to sets
8) Selected algorithms from java.util.Collections and java.util.Arrays

Analyse the source code in package lst05_07

Exercises

Familiarize yourself with the methods of Collections and Arrays utility classes
Explain why binarySearch algorithm requires sorted data
Explain the difference between linear search and binary search in terms of the time complexity
[optional] Compare experimentally the performance of these algorithms
