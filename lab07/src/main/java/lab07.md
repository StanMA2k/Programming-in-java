1) Streams (finite and infinite) creation

Analyse the source code in package lst07_01

Exercises

Explain the concept of a stream (as defined in java.util)
Stream provides a series of data arranging methods, 

Familiarize yourself with the static methods of the Stream interface

Define a finite stream of 5 boolean values
```java
Stream<Boolean> booleanStream = Stream.of(true, false, true, false, true);
```
Define an infinite stream of random integer values
```java
 Random random = new Random();
Stream<Integer> randomInts = Stream.generate(random::nextInt);
```
Define the infinite stream of even positive integer values
```java
 Stream<Integer> evenNumbersStream = Stream.iterate(2, n -> n + 2);
```
[optional] Define the stream of the first 20 prime numbers
[optional] Define the infinite stream of Fibonacci numbers
2) Stream methods (I): skip, peek, takeWhile, dropWhile, distinct, sorted, max, min, count, findFirst, findAny, anyMatch, allMatch, and noneMatch

Analyse the source code in package lst07_02

Exercises

Familiarize yourself with the instance (non-static) methods of the Stream interface

Partition the following methods into intermediate and terminal:
distinct, limit, skip, count, max, min, findFirst, findAny, allMatch, anyMatch, noneMatch, forEach, peek, takeWhile, dropWhile, sorted
- intermediate: distinct, limit, skip, peek, takeWhile, dropWhile, sorted
- terminal: count, max, min, findFirst, findAny, allMatch, anyMatch, noneMatch, forEach

Explain potential applications of method peek: it could be used for debugging because it can peek into the stream without changing it 

Explain the difference between methods skip and dropWhile: skip(long n) is a straightforward method that skips over the first n elements of the stream. dropWhile(Predicate<? super T> predicate) drops elements as long as the given predicate is true

Explain the rule of chaining methods distinct and sorted (compare the two possible orderings, i.e, "distinct -> sorted" vs. "sorted" -> "distinct): 

3) throw-catch and functional programming mismatch

Analyse the source code in package lst07_03

Exercises

Explain the problem of the "throw-catch and functional programming mismatch": 

Compare the way of handling checked and unchecked exceptions in the Java stream pipelines (and lambda expressions):

Explain the advantages of using Optional when compared to throwing excpetions or using the null):

4) Stream methods (II): filter, map, flatMap, and reduce

Analyse the source code in package lst07_04

Write imperative (loop based) implementations of filter, map, flatMap, and reduce
Given a stream of 100 random integers print out only even values
Given:

List.of("alpha", "bravo", "charlie", "delta")
print out the first letter (capitalized) of each element

Using flatMap, flatten the following list:

List.of(List.of(1, 2), List.of(3, 4, 5), List.of(6, 7, 8, 9)
Given a stream of 100 random (positive) integers, using the method reduce compute their sum

Given a stream of 7 random (positive) integers, using the method reduce compute their product

Given a stream of 100 random (positive) integers, using the method reduce find their max value

Given a stream of 10 random (positive) integers, using the method reduce concatenate them

Exercises

5) Primitive type streams: IntStream, LongStream, and DoubleStream

Analyse the source code in package lst07_05

Exercises

Compare IntStream with Stream<Integer>
Explain the output of the following code:

int[][] a = {{1, 2}, {3, 4}, {5, 6}};
System.out.println(Stream.of(a)
.mapToInt(e -> IntStream.of(e).sum())
.sum());

double[] numbers = {1.2, 1, 2.2, 3.6};
System.out.println(DoubleStream.of(numbers)
.mapToInt(e -> (int)e).sum());
Explain the output of the following code:

System.out.println(Stream.of(new Character[] {'D', 'B', 'A', 'C'})
.mapToInt(e -> e - 'A').sum());
Create a stream of 1000 random integers and then calculate their min, max, sum and average

Given a finite stream of strings, find the average string length
6) Stream pipelines and collectors

Analyse the source code in package lst07_06

Exercises

Given:

record Client(String name, String address, Optional<String> email) {}
record Ticket(String departure, String destination, LocalDate date, Client client, int priceInUnits) {}
generate a list of clients (i.e., List<Client> clients) and and a list of tickets (i.e., List<Ticket> tickets)

Given a list of tickets and a destination, compute the number of tickets with the given destination

Given a list of tickets and a date, print out the tickets for the given date

Given a list of tickets and the name of a client, check if there is at least one ticket reserved fot the given client

Given a list of tickets return the average value of the prices for all the tickets in the list

Given a list of tickets check if all the clients have an email address

Given a list of tickets return return a comma separated value containing all the destination in the list

7) Streams in text processing (I)

Analyse the source code in package lst07_07

Exercises (related to the IMDB top 250 movies)

Compute the total number of actors
Compute the total number of movies rated "PG-13"
Compute the total number of genres
Compute the list of movies for each certification (i.e, "R" => ["The Shawshank Redemption", "The Godfather",...], "PG-13" => ["The Dark Knight", "Forrest Gump, ... ], ... )
Compute the number of movies for each certification
Compute the list of movies for each actor (i.e., "Morgan Freeman" => ["The Shawshank Redemption", "Se7en", ...])
Compute the number of movies for each actor
Compute 5 most frequent directors (sorted)
Compute 5 most actors (sorted)
8) Streams in text processing (II)

Analyse the source code in package lst07_08

Exercises (related to the text of "Alice's Adventures in Wonderland")

Compute the total number of words
Compute the total number of italicized words (i.e., _it_)
Compute the number of words for each chapter
Compute 10 most frequent words in the whole text (sorted)
Compute 10 most frequent words for each chapter (sorted)
Compute 10 longest words in the whole text (sorted)
Compute 10 longest words for each chapter (sorted)
Compute the frequency table of vowels in the whole text
Compute the frequency table of vowels for each chapter