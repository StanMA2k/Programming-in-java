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
a throw-catch caused by exception may interrupt the normal program process, these interruptions are not ideal for a functional programming. In functional programming it would rather use Option/Optional and Either/Result types to replace a throw-catch in exception handling. 

Compare the way of handling checked and unchecked exceptions in the Java stream pipelines (and lambda expressions):
Unchecked exceptions, which include RuntimeException and its subclasses, do not require explicit handling in the method signatures, Unchecked exceptions can be thrown without altering the lambda expression or method interface; 
Checked exceptions are those that must be either caught or declared in the method's signature. Lambda expressions in Java cannot throw checked exceptions without wrapping them in a runtime exception if the functional interface does not allow checked exceptions.

Explain the advantages of using Optional when compared to throwing exceptions or using the null:
Optional is more clear than null, and can reduce NullPointerException. Using Optional may make the code more difficult to write. 

4) Stream methods (II): filter, map, flatMap, and reduce

Analyse the source code in package lst07_04

Write imperative (loop based) implementations of filter, map, flatMap, and reduce
Given a stream of 100 random integers print out only even values
```java
Random rand = new Random();
List<Integer> randomIntegers = new ArrayList<>();
for (int i = 0; i < 100; i++) {
    randomIntegers.add(rand.nextInt(100)); // Generate random integers between 0 and 99
}
List<Integer> evenIntegers = filter(randomIntegers);
for (Integer even : evenIntegers) {
    System.out.println(even);
}
```
Given:

List.of("alpha", "bravo", "charlie", "delta")
print out the first letter (capitalized) of each element
```java
List<String> words = List.of("alpha", "bravo", "charlie", "delta");
List<String> firstLetters = map(words);
for (String letter : firstLetters) {
    System.out.println(letter);
}
```
Using flatMap, flatten the following list:

List.of(List.of(1, 2), List.of(3, 4, 5), List.of(6, 7, 8, 9)
Given a stream of 100 random (positive) integers, using the method reduce compute their sum
```java
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int sum = IntStream.generate(() -> random.nextInt(100) + 1) 
                .limit(100) 
                .reduce(0, Integer::sum); 

        System.out.println("Sum of 100 random positive integers: " + sum);
    }
}
```
Given a stream of 7 random (positive) integers, using the method reduce compute their product
```java
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int product = IntStream.generate(() -> random.nextInt(100) + 1) 
                .limit(7) 
                .reduce(1,(a,b) -> a * b); 

        System.out.println("Product of 7 positive integers: " + product);
    }
}
```
Given a stream of 100 random (positive) integers, using the method reduce find their max value
```java
public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Integer maxVal = IntStream.generate(() -> random.nextInt(100) + 1) 
                .limit(1) 
                .reduce(Integer::maxVal)
                .orElse(-1);
        System.out.println("Max value of 100 random positive integers: " + maxVal);
    }
}
```
Given a stream of 10 random (positive) integers, using the method reduce concatenate them
```java
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        
        String concatenatedResult = IntStream.generate(() -> random.nextInt(100) + 1) 
                .limit(10) 
                .mapToObj(Integer::toString) 
                .reduce("", (a, b) -> a + b); 

        System.out.println("Concatenated string of 10 random positive integers: " + concatenatedResult);
    }
}
```
Exercises

5) Primitive type streams: IntStream, LongStream, and DoubleStream

Analyse the source code in package lst07_05

Exercises

Compare IntStream with Stream<Integer>: IntStream can handle primitive data type, Stream<Integer> handles an wrapper class, which means it may use boxing and unboxing operations.
IntStream is more compatible to deal with number calculations, Stream<Integer> is a general operation for stream operations

Explain the output of the following code:
```java
int[][] a = {{1, 2}, {3, 4}, {5, 6}};
System.out.println(Stream.of(a)
.mapToInt(e -> IntStream.of(e).sum())
.sum()); //output 21
```
```java
double[] numbers = {1.2, 1, 2.2, 3.6};
System.out.println(DoubleStream.of(numbers)
.mapToInt(e -> (int)e).sum()); //output 7
```
Explain the output of the following code:
```java
System.out.println(Stream.of(new Character[] {'D', 'B', 'A', 'C'})
.mapToInt(e -> e - 'A').sum()); //output 6
```
Create a stream of 1000 random integers and then calculate their min, max, sum and average
```java
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        
        IntStream randomStream = random.ints().limit(1000);
        int max = randomStream.max().getAsInt();

        IntStream randomStream = random.ints().limit(1000);
        int min = randomStream.min().getAsInt();
        
        IntStream randomStream = random.ints().limit(1000);
        int sum = randomStream.sum().getAsInt();

        randomStream = random.ints().limit(1000);
        double avg = randomStream.average().getAsDouble();
        
        System.out.println("The max value is: " + max);
        System.out.println("The min value is: " + min);
        System.out.println("The sum is: " + sum);
        System.out.println("The average is: " + avg);
    }
}
```
Given a finite stream of strings, find the average string length
6) Stream pipelines and collectors

Analyse the source code in package lst07_06

Exercises

Given:

record Client(String name, String address, Optional<String> email) {}
record Ticket(String departure, String destination, LocalDate date, Client client, int priceInUnits) {}
generate a list of clients (i.e., List<Client> clients) and a list of tickets (i.e., List<Ticket> tickets)
```java

public record Client(String name, String address, Optional<String> email) {}
public record Ticket(String departure, String destination, LocalDate date, Client client, int priceInUnits) {}
public class Main {
    public static void main(String[] args) {
        // List of Clients
        List<Client> clients = Arrays.asList(
                new Client("Alice Smith", "123 Maple St", Optional.of("alice@example.com")),
                new Client("Bob Johnson", "456 Oak St", Optional.empty()),
                new Client("Charlie Brown", "789 Pine St", Optional.of("charlie@example.com"))
        );

        // List of Tickets
        List<Ticket> tickets = Arrays.asList(
                new Ticket("New York", "Los Angeles", LocalDate.of(2023, 5, 15), clients.get(0), 300),
                new Ticket("Chicago", "Houston", LocalDate.of(2023, 6, 20), clients.get(1), 200),
                new Ticket("San Francisco", "Seattle", LocalDate.of(2023, 7, 10), clients.get(2), 250)
        );

        // Print Clients
        System.out.println("Clients:");
        clients.forEach(client -> System.out.println(client));

        // Print Tickets
        System.out.println("\nTickets:");
        tickets.forEach(ticket -> System.out.println(ticket));
    }
}

```
Given a list of tickets and a destination, compute the number of tickets with the given destination
```java
public class TicketCounter {

    public static void main(String[] args) {
       
        List<Ticket> tickets = List.of(
            new Ticket("New York", "Los Angeles", LocalDate.of(2023, 5, 15), new Client("Alice Smith", "123 Maple St", Optional.of("alice@example.com")), 300),
            new Ticket("Chicago", "Houston", LocalDate.of(2023, 6, 20), new Client("Bob Johnson", "456 Oak St", Optional.empty()), 200),
            new Ticket("New York", "Los Angeles", LocalDate.of(2023, 7, 10), new Client("Charlie Brown", "789 Pine St", Optional.of("charlie@example.com")), 250)
        );

        int count = countTicketsWithDestination(tickets, "Los Angeles");
        System.out.println("Number of tickets to Los Angeles: " + count);
    }

    private static int countTicketsWithDestination(List<Ticket> tickets, String destination) {
        return (int) tickets.stream()
            .filter(ticket -> ticket.destination().equals(destination))
            .count();
    }
}

```
Given a list of tickets and a date, print out the tickets for the given date
```java
public class TicketPrinter {

    public static void main(String[] args) {
        
        List<Ticket> tickets = List.of(
            new Ticket("New York", "Los Angeles", LocalDate.of(2023, 5, 15), new Client("Alice Smith", "123 Maple St", Optional.of("alice@example.com")), 300),
            new Ticket("Chicago", "Houston", LocalDate.of(2023, 5, 15), new Client("Bob Johnson", "456 Oak St", Optional.empty()), 200),
            new Ticket("San Francisco", "Seattle", LocalDate.of(2023, 7, 10), new Client("Charlie Brown", "789 Pine St", Optional.of("charlie@example.com")), 250)
        );

        LocalDate queryDate = LocalDate.of(2023, 5, 15);
        printTicketsForDate(tickets, queryDate);
    }

    private static void printTicketsForDate(List<Ticket> tickets, LocalDate date) {
        tickets.stream()
            .filter(ticket -> ticket.date().equals(date))
            .forEach(System.out::println); 
}}
```
Given a list of tickets and the name of a client, check if there is at least one ticket reserved fot the given client
```java
public class TicketPrinter {

    public static void main(String[] args) {
        
        List<Ticket> tickets = List.of(
            new Ticket("New York", "Los Angeles", LocalDate.of(2023, 5, 15), new Client("Alice Smith", "123 Maple St", Optional.of("alice@example.com")), 300),
            new Ticket("Chicago", "Houston", LocalDate.of(2023, 5, 15), new Client("Bob Johnson", "456 Oak St", Optional.empty()), 200),
            new Ticket("San Francisco", "Seattle", LocalDate.of(2023, 7, 10), new Client("Charlie Brown", "789 Pine St", Optional.of("charlie@example.com")), 250)
        );

        String cliName = "Bob Johnson";
        boolean hasTicket = checkForClientTicket(tickets, clientName);
        System.out.println("Does " + clientName + " have a ticket? " + hasTicket);
    }

    private static boolean checkForClientTicket(List<Ticket> tickets, String clientName) {
        return tickets.stream()
                .anyMatch(ticket -> ticket.client().name().equals(clientName));
    }
}
```
Given a list of tickets return the average value of the prices for all the tickets in the list
```java
public class TicketPrinter {

    public static void main(String[] args) {
        
        List<Ticket> tickets = List.of(
            new Ticket("New York", "Los Angeles", LocalDate.of(2023, 5, 15), new Client("Alice Smith", "123 Maple St", Optional.of("alice@example.com")), 300),
            new Ticket("Chicago", "Houston", LocalDate.of(2023, 5, 15), new Client("Bob Johnson", "456 Oak St", Optional.empty()), 200),
            new Ticket("San Francisco", "Seattle", LocalDate.of(2023, 7, 10), new Client("Charlie Brown", "789 Pine St", Optional.of("charlie@example.com")), 250)
        );

        double avgVal = calculateAvgVal(tickets); 
        
        System.out.println("Does " + clientName + " have a ticket? " + hasTicket);
    }

    private static double calculateAvgVal(List<Ticket> tickets) {
        return tickets.stream()
                .mapToInt(Ticket::priceInUnits)
                .average()
                .orElse(0.0);
    }
}
```
Given a list of tickets check if all the clients have an email address
```java
public class TicketManager {

    public static void main(String[] args) {
        List<Ticket> tickets = List.of(
            new Ticket("New York", "Los Angeles", LocalDate.of(2023, 5, 15), new Client("Alice Smith", "123 Maple St", Optional.of("alice@example.com")), 300),
            new Ticket("Chicago", "Houston", LocalDate.of(2023, 6, 20), new Client("Bob Johnson", "456 Oak St", Optional.empty()), 200),
            new Ticket("San Francisco", "Seattle", LocalDate.of(2023, 7, 10), new Client("Charlie Brown", "789 Pine St", Optional.of("charlie@example.com")), 250)
        );

        boolean allHaveEmails = checkAllClientsHaveEmails(tickets);
        System.out.println("Do all clients have emails? " + allHaveEmails);
    }

    private static boolean checkAllClientsHaveEmails(List<Ticket> tickets) {
        return tickets.stream()
                      .map(Ticket::client) 
                      .allMatch(client -> client.email().isPresent());  
    }
}
```
Given a list of tickets return a comma separated value containing all the destination in the list
```java
public class TicketManager {

    public static void main(String[] args) {
        // Example list of tickets
        List<Ticket> tickets = List.of(
            new Ticket("New York", "Los Angeles", LocalDate.of(2023, 5, 15), new Client("Alice Smith", "123 Maple St", Optional.of("alice@example.com")), 300),
            new Ticket("Chicago", "Houston", LocalDate.of(2023, 6, 20), new Client("Bob Johnson", "456 Oak St", Optional.empty()), 200),
            new Ticket("San Francisco", "Seattle", LocalDate.of(2023, 7, 10), new Client("Charlie Brown", "789 Pine St", Optional.of("charlie@example.com")), 250),
        );

        String destinations = getCommaSeparatedDestinations(tickets);
        System.out.println("Destinations: " + destinations);
    }

    private static String getCommaSeparatedDestinations(List<Ticket> tickets) {
        return tickets.stream()
                      .map(Ticket::destination)
                      .collect(Collectors.joining(", "));
    }
}
```
7) Streams in text processing (I)

Analyse the source code in package lst07_07

Exercises (related to the IMDB top 250 movies)

Compute the total number of actors
```java
 private static void countActors() {
        System.out.println("\ncountActors...");
final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        Set<String> uniqueActors = optMovies.orElseThrow().stream()
        .flatMap(movie -> movie.actors().stream())  
        .collect(Collectors.toSet());
        System.out.println("Total number of unique actors: " + uniqueActors.size());
        }
```
Compute the total number of movies rated "PG-13"
```java
private static void PG13() {
        System.out.println("\nPG13...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        long countPG13 = optMovies.orElseThrow().stream()
            .filter(m -> "PG-13".equals(m.rating()))
            .count();

        System.out.println("Total number of PG-13 rated movies: " + countPG13);
    }
```
Compute the total number of genres
```java
private static void countGenres() {
        System.out.println("\ncountGenres...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        Set<String> uniqueGenres = optMovies.orElseThrow().stream()
            .flatMap(movie -> movie.genres().stream())  
            .collect(Collectors.toSet()); 

        System.out.println("Total number of unique genres: " + uniqueGenres.size());
    }
```
Compute the list of movies for each certification (i.e, "R" => ["The Shawshank Redemption", "The Godfather",...], "PG-13" => ["The Dark Knight", "Forrest Gump, ... ], ... )
```java
private static void groupMoviesByCertification() {
        System.out.println("\ngroupMoviesByCertification...");
        final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        Map<String, List<String>> moviesByCertification = optMovies.orElseThrow().stream()
            .collect(Collectors.groupingBy(
                Movie::rating, 
                Collectors.mapping(Movie::title, Collectors.toList())
            ));

        moviesByCertification.forEach((rating, titles) -> {
            System.out.println(rating + " => " + titles);
        });
    }
```
Compute the number of movies for each certification
```java
private static void countMoviesByCertification() {
        System.out.println("\ncountMoviesByCertification...");
final Optional<List<Movie>> optMovies = ImdbTop250.movies();
        Map<String, Long> moviesByCertification = optMovies.orElseThrow().stream()
        .collect(Collectors.groupingBy(
        Movie::rating,  
        Collectors.counting()  
        ));
        moviesByCertification.forEach((rating, count) -> {
        System.out.println(rating + " => " + count);
        });
        }

```
Compute the list of movies for each actor (i.e., "Morgan Freeman" => ["The Shawshank Redemption", "Se7en", ...])
```java
private static void listMoviesByActor() {
    System.out.println("\nlistMoviesByActor...");
    final Optional<List<Movie>> optMovies = ImdbTop250.movies();
    Map<String, List<String>> moviesByActor = optMovies.orElseThrow().stream()
        .flatMap(movie -> movie.actors().stream().map(actor -> new AbstractMap.SimpleEntry<>(actor, movie.title())))
        .collect(Collectors.groupingBy(
            Map.Entry::getKey, 
            Collectors.mapping(Map.Entry::getValue, Collectors.toList())
        ));

    moviesByActor.forEach((actor, movies) -> {
        System.out.println(actor + " => " + movies);
    });
}

```
Compute the number of movies for each actor
```java
private static void countMoviesByActor() {
    System.out.println("\ncountMoviesByActor...");
    final Optional<List<Movie>> optMovies = ImdbTop250.movies();
    Map<String, Long> movieCountByActor = optMovies.orElseThrow().stream()
        .flatMap(movie -> movie.actors().stream().map(actor -> new AbstractMap.SimpleEntry<>(actor, movie)))
        .collect(Collectors.groupingBy(
            Map.Entry::getKey, 
            Collectors.counting()
        ));

    movieCountByActor.forEach((actor, count) -> {
        System.out.println(actor + " => " + count);
    });
}
```
Compute 5 most frequent directors (sorted)
```java
private static void topFiveDirectors() {
    System.out.println("\ntopFiveDirectors...");
    final Optional<List<Movie>> optMovies = ImdbTop250.movies();
    Map<String, Long> directorFrequency = optMovies.orElseThrow().stream()
        .collect(Collectors.groupingBy(
            Movie::director, 
            Collectors.counting()
        ));
    directorFrequency.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(5)
        .forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
}
```
Compute 5 most actors (sorted)
```java
private static void topFiveActors() {
    System.out.println("\ntopFiveActors...");
    final Optional<List<Movie>> optMovies = ImdbTop250.movies();
    Map<String, Long> actorFrequency = optMovies.orElseThrow().stream()
        .flatMap(movie -> movie.actors().stream())  // Assuming Movie::actors returns List<String>
        .collect(Collectors.groupingBy(
            Function.identity(), 
            Collectors.counting()  
        ));
    
    actorFrequency.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(5)
        .forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
}
```
8) Streams in text processing (II)

Analyse the source code in package lst07_08

Exercises (related to the text of "Alice's Adventures in Wonderland")

Compute the total number of words
```java
private static void countTotalWords() {
        System.out.println("\ncountTotalWords...");
        final Optional<List<String>> optLines = Alice.lines();

        if (optLines.isPresent()) {
            long wordCount = optLines.get().stream()
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .filter(word -> !word.isEmpty())
                .count();

            System.out.println("Total number of words: " + wordCount);
        } else {
            System.out.println("Text data is not available.");
        }
    }
```
Compute the total number of italicized words (i.e., _it_)
```java
private static void countItalicizedWords() {
    System.out.println("\ncountItalicizedWords...");
    final Optional<List<String>> optLines = Alice.lines();

    if (optLines.isPresent()) {
        long italicizedWordCount = optLines.get().stream()
            .flatMap(line -> Arrays.stream(line.split("\\s+")))
            .filter(word -> word.matches("_\\w+_")) // Matches words that are enclosed by underscores
            .count();

        System.out.println("Total number of italicized words: " + italicizedWordCount);
    } else {
        System.out.println("Text data is not available.");
    }
}
```
Compute the number of words for each chapter
```java
private static void countWordsByChapter() {
    System.out.println("\ncountWordsByChapter...");
    final Optional<Map<Integer, List<String>>> optChapterLines = Alice.chapterLines();

    if (optChapterLines.isPresent()) {
        optChapterLines.get().entrySet().stream()
            .forEach(entry -> {
                int chapter = entry.getKey();
                long wordCount = entry.getValue().stream()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .filter(word -> !word.isEmpty())
                    .count();
                System.out.println("Chapter " + chapter + " has " + wordCount + " words");
            });
    } else {
        System.out.println("Chapter data is not available.");
    }
}

```
Compute 10 most frequent words in the whole text (sorted)
```java
private static void topTenFrequentWords() {
    System.out.println("\ntopTenFrequentWords...");
    final Optional<List<String>> optLines = Alice.lines();

    if (optLines.isPresent()) {
        Map<String, Long> wordFrequencies = optLines.get().stream()
            .flatMap(line -> Arrays.stream(line.toLowerCase().split("[\\s.,:;!?'\"()\\[\\]{}]+"))) 
            .filter(word -> !word.isEmpty())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> sortedFrequentWords = wordFrequencies.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(10)
            .collect(Collectors.toList());

        System.out.println("Top 10 most frequent words:");
        sortedFrequentWords.forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    } else {
        System.out.println("Text data is not available.");
    }
}

```
Compute 10 most frequent words for each chapter (sorted)
```java
private static void topTenFrequentWordsPerChapter() {
        System.out.println("\ntopTenFrequentWordsPerChapter...");
final Optional<Map<Integer, List<String>>> optChapterLines = Alice.chapterLines();

        if (optChapterLines.isPresent()) {
        optChapterLines.get().forEach((chapter, lines) -> {
        System.out.println("Chapter " + chapter + ":");

        Map<String, Long> wordFrequencies = lines.stream()
        .flatMap(line -> Arrays.stream(line.toLowerCase().split("[\\s.,:;!?'\"()\\[\\]{}]+")))
        .filter(word -> !word.isEmpty())
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> sortedFrequentWords = wordFrequencies.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(10)
        .collect(Collectors.toList());

        sortedFrequentWords.forEach(entry ->
        System.out.println(" " + entry.getKey() + " => " + entry.getValue()));
        System.out.println("---");
        });
        } else {
        System.out.println("Chapter data is not available.");
        }
        }
```
Compute 10 longest words in the whole text (sorted)
```java
private static void topTenLongestWords() {
    System.out.println("\ntopTenLongestWords...");
    final Optional<List<String>> optLines = Alice.lines();

    if (optLines.isPresent()) {
        List<String> longestWords = optLines.get().stream()
            .flatMap(line -> Arrays.stream(line.split("[\\s.,:;!?'\"()\\[\\]{}]+"))) 
            .filter(word -> !word.isEmpty())
            .distinct() // Remove duplicates to avoid listing the same word multiple times
            .sorted(Comparator.comparingInt(String::length).reversed()) 
            .limit(10) // Limit to the top 10 longest words
            .collect(Collectors.toList());

        System.out.println("Top 10 longest words:");
        longestWords.forEach(word -> System.out.println(word + " (" + word.length() + " characters)"));
    } else {
        System.out.println("Text data is not available.");
    }
}

```
Compute 10 longest words for each chapter (sorted)
```java
private static void topTenLongestWordsPerChapter() {
    System.out.println("\ntopTenLongestWordsPerChapter...");
    final Optional<Map<Integer, List<String>>> optChapterLines = Alice.chapterLines();

    if (optChapterLines.isPresent()) {
        optChapterLines.get().forEach((chapter, lines) -> {
            System.out.println("Chapter " + chapter + ":");

            List<String> longestWords = lines.stream()
                .flatMap(line -> Arrays.stream(line.split("[\\s.,:;!?'\"()\\[\\]{}]+"))) 
                .filter(word -> !word.isEmpty())
                .distinct() // Remove duplicates to focus on unique words
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(10) // Limit to the top 10 longest words
                .collect(Collectors.toList());

            longestWords.forEach(word -> System.out.println(word + " (" + word.length() + " characters)"));
            System.out.println("---");
        });
    } else {
        System.out.println("Chapter data is not available.");
    }
}

```
Compute the frequency table of vowels in the whole text
```java
private static void vowelFrequencyTable() {
    System.out.println("\nvowelFrequencyTable...");
    final Optional<List<String>> optLines = Alice.lines();

    if (optLines.isPresent()) {
        Map<Character, Long> vowelCounts = optLines.get().stream()
            .flatMapToInt(String::chars) 
            .mapToObj(c -> (char) c) 
            .filter(c -> "AEIOUaeiou".indexOf(c) != -1) 
            .collect(Collectors.groupingBy(Character::toLowerCase, TreeMap::new, Collectors.counting()));

        System.out.println("Vowel frequencies:");
        vowelCounts.forEach((vowel, count) -> System.out.println(vowel + ": " + count));
    } else {
        System.out.println("Text data is not available.");
    }
}

```
Compute the frequency table of vowels for each chapter
```java
private static void vowelFrequencyTablePerChapter() {
    System.out.println("\nvowelFrequencyTablePerChapter...");
    final Optional<Map<Integer, List<String>>> optChapterLines = Alice.chapterLines();

    if (optChapterLines.isPresent()) {
        optChapterLines.get().forEach((chapter, lines) -> {
            System.out.println("Chapter " + chapter + ":");

            Map<Character, Long> vowelCounts = lines.stream()
                .flatMapToInt(String::chars) 
                .mapToObj(c -> (char) c) 
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1) 
                .collect(Collectors.groupingBy(Character::toLowerCase, TreeMap::new, Collectors.counting()));

            System.out.println("Vowel frequencies:");
            vowelCounts.forEach((vowel, count) -> System.out.println(" " + vowel + ": " + count));
            System.out.println("---");
        });
    } else {
        System.out.println("Chapter data is not available.");
    }
}

```