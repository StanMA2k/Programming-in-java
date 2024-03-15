0) Java Style Guide

Look briefly at Google Java Style Guide
[IntelliJ] Install CheckStyle-IDEA plugin
[IntelliJ] Perform the project code inspection:
select Code > Inspect Code...
check Whole project
press OK
Analyse the warnings

Main warnings: local variable; final; robust logging; modifier; return same value; 
1) Java exceptions hierarchy

Throwable, Error vs. Exception; checked vs. unchecked exceptions

Exercises

Familiarise yourself with The Java Tutorials > Essential Java Classes > Exceptions

Familiarise yourself with the following classes:

Throwable: contains 2 subclasses: error and exception, usually use directly those 2 subclasses

Error: stands for system error or resource error, usually can't be predicted and repaired, example: OutOfMemoryError, StackOverflowError,etc. Solution: stop the program

Exception: checked exception (IOException) and unchecked exception (RuntimeException)

IOException: indicate an exception when operating files, use "throws" to declare an exception and use "try-catch" to deal with it

RuntimeException: indicate programming errors in the program, such as accessing a null pointer, out-of-bounds array access, or attempting an illegal type cast. This exception needs to ameliorate the program

Look briefly at the chapter of Java Language Specification related to Exceptions

2) throws, throw, try-catch, try-finally, and try-catch-finally

Analyse the source code in packages:

lst03_01 (unchecked exceptions, RuntimeException, Error)
lst03_02 (checked exceptions, try-catch)
lst03_03 (try-finally, and try-catch-finally)
Exercises

Look briefly at the chapters of Java Language Specification related to:

throws clause: is a part of method declaration, it indicates the possible exception type of the program

throw statement: throw new ExceptionType("Error Message");
```java
/*example
public void setAge(int age) {
if (age < 0) {
throw new IllegalArgumentException("Age cannot be negative");
}
this.age = age;
}*/
```
try statement: try-catch; try-catch-catch; try-catch-finally; try-finally. try: give some code; catch: deal with exception; finally: execute "finally" code weather an exception is caught

Explain the differences between checked and unchecked exceptions

Checked exceptions are those who need to be dealt with when compiling, there might have problems if call a method that have checked exceptions.
Unchecked exceptions include exceptions occurred in running the program, or Error. It doesn't need to be handled explicitly but it reminder the compiler of the quality of the code.

Explain the meaning of keywords throw and throws

throw: used inside a method, it gives a message when exception occurred.
```java
if (value < 0) {
throw new IllegalArgumentException("Value cannot be negative");
}
```
throws: used after the name of method, it declares that this method might throw an exception. If this method is called, the caller must deal with this exception.
```java
public void readFile(String fileName) throws IOException {
    // read file
}

```
[c] Refactor the source code to one file-one class structure
[c] Add exception handling to the StackOfInts
3) try-with-resources and AutoCloseable interface

Analyse the source code in package lst03_04
Exercises

Look briefly at the chapter of Java Language Specification related to try-with-resources
Familiarise yourself with the AutoCloseable interface
```java
public interface AutoCloseable {
    void close() throws Exception;
}
/*
Every class implemented with AutoCloseable can use try-with-resource. Close: when close is called, the resources would be cleared. 
 */
try (ResourceType resource = new Resource()) {
        }//ResourceType must realize AutoCloseable. After "try", system will call resource.close().
```

[c] Refactor the source code to one file-one class structure
4) Reading and writing from/to the console

Analyse the source code in package lst03_05

Exercises

Look briefly at the content of files: Console.java, System.java, and Scanner.java

Run agh.ii.prinjava.lab03.lst03_05.Main from the (external) console window

5) Simple File I/O: text files

Analyse the source code in package lst03_06

Exercises

[c] [ optional ] Write a function that counts the number of characters in a given text file
[c] [ optional ] Write a function that counts the number of lines in a given text file
[c] [ optional ] Write a function that concatenates two given files; consider two approaches:
the second file is appended to the first one
the result is a new file
[c] [ optional ] Write a function that counts the number of words in a given text file
[c] [ optional ] Write a function that counts the number of whitespace characters in a given text file
[c] [ optional ] Write a function that changes, in a given text file, all TAB characters to SPACE characters
6) Simple File I/O: binary files

Analyse the source code in package lst03_07

Exercises

Explain briefly the applications of the following classes:

IOException:
1. BufferedReader: is used to read a file. It provides "readLine" method.
2. BufferedWriter: used to write text into output; BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"))
3. FileReader: extend from InputStreamReader, used to read a file; FileReader reader = new FileReader("example.txt")
4. FileWriter: extend from OutputStreamWriter, it can modify a file directly with a given path or to create one if not exist. An instance of fileWriter would replace the original one.
5. FileInputStream: used to read binary document, e.g. img, video, audio, etc. An instance can connect to the doc with its path or object
6. FileOutputStream: write data into doc.
7. DataInputStream: read primitive types, provides a series of read method (readInt、readDouble、readUTF, etc.). It is compatible with DataOutputStream, usually used to read data written by DataOutputStream 
8. DataOutputStream: provides write methods. 
9. ObjectInputStream
10. ObjectOutputStream

PrintWriter: it provides "print" and "println" method, which permit to output different data type(String, int, float, etc.). Use checkError() to find an exception (won't catch IOException).

Files

Path

File
[c] Extend the code in lst03_07 to be able to track how many times agh.ii.prinjava.lab03.lst03_07.Main has been executed. Hint: you can store a counter in the file and increment each time this program is executed.

7) Java marker interfaces (Cloneable and Serializable)

Analyse the source code in packages:

lst03_08 (marker interface concept)
lst03_09 (Serializable)
lst03_10 (Cloneable)
Exercises

Familiarise yourself with the content of Serializable.java and Cloneable.java

[c] Refactor the source code to one file-one class structure

8) Mini project 03_01 (exc03_01)

[c] The implementation of interface QueueOfInts:

Complete the linked list based implementation - LinkedListBasedImpl:
use nested class Node as the linked list building block
use the simplest possible implementation of the linked list (only two operations are required: adding an element at the front and removing an element from the back of the list)
add exception handling (checked/unchecked)
[ optional ] add serialization/deserialization of the queue
Add JavaDoc comments to the interface and all its methods; pay attention to the following tags:
@param
@return
@throws
```java
package agh.ii.prinjava.lab03.exc03_01;


/**
 * Interface QueueOfInts provides a series methods of arranging a queue
 */
public interface QueueOfInts {


    /**
     * add integer x to the tail
     *
     * @param x integer to be added
     */
    void enqueue(int x);


    /**
     * Dequeues an integer from the back of the queue.
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int dequeue();


    /**
     * Checks if the queue is empty.
     */
    default boolean isEmpty() {
        return numOfElems() == 0;
    }


    /**
     * Return the number of elements in the queue.
     * This operation provides the current size of the queue.
     * @return the number of elements in the queue
     */
    int numOfElems();


    /**
     * Return the first element in the queue
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    int peek();
}

```

Add JavaDoc comments to LinkedListBasedImpl (the class itself and all its methods)
```java
package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;


/**
 * {@code LinkedListBasedImpl} provides a linked-list-based implementation of the {@code QueueOfInts} interface
 */
public class LinkedListBasedImpl implements QueueOfInts {


    /**
     * Adds an integer element to the front of the queue.
     * This method implements the enqueue operation of the {@code QueueOfInts} interface by inserting the element at the beginning of the linked list.
     * @param x the integer element to be added to the front of the queue
     */
    @Override
    public void enqueue(int x) {
        Node node = new Node(x);
        if (first == null){
            first = last = new Node(x);
        }else{
            node.next = first;
            first.prev = node;
            first = node;
        }
        numOfElems++;
    }


    /**
     * Removes and returns the integer element from the back of the queue.
     * This method implements the dequeue operation of the {@code QueueOfInts} interface by removing the element from the end of the linked list.
     * @return the integer element removed from the back of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public int dequeue() {
        if (last == null){
            throw new IllegalStateException("Linked list is empty");
        }
        int elem = last.elem;
        last = last.prev;
        if (last != null){
            last.next = null;
        }else{
            first = null;
        }
        numOfElems--;
        return elem;
    }


    /**
     * Return the number of elements in the queue.
     * This method implements the numOfElems operation of the {@code QueueOfInts} interface
     * @return the number of elements in the queue
     */
    @Override
    public int numOfElems() {
        return numOfElems;
    }


    /**
     * Return the first element of the queue.
     * This method implements the peek operation of the {@code QueueOfInts} interface by returning the element at the front of the linked list without removing it.
     * @return the integer at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    @Override
    public int peek() {
        if (first == null) {
            throw new IllegalStateException("Linked list is empty");
        }
        return first.elem;
    }



/**
 * Node is a private static inner class used to implement the linked list.
 * Each node stores an integer element and has references to the next and previous nodes in the list.
 */
    private static class Node {
        int elem;
        Node next;
        Node prev;

        public Node(int elem) {
            this.elem = elem;
        }

        public Node(int elem, Node next, Node prev) {
            this.elem = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node first = null;
    private Node last = null;

    private int numOfElems = 0;
}

```

Write unit tests for different cases
```java
package agh.ii.prinjava.lab03.exc03_01.impl;

import agh.ii.prinjava.lab03.exc03_01.QueueOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    // Create an empty queue
    private final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
        final QueueOfInts queueOfInts = QueueOfIntsFtry.create(QueueOfIntsFtry.Impln.L_LIST_B);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty(), "A new queue should be empty");
    }

    @Test
    void enqueue(){
        queueOfInts.enqueue(1);
        assertFalse(queueOfInts.isEmpty(), "Queue shouldn't be empty after enqueue");

    }

    @Test
    void enqueueToHead(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(2, queueOfInts.peek(), "Queue head should be the latest enqueued elem");
    }

    @Test
    void dequeue(){
        queueOfInts.enqueue(1);
        queueOfInts.dequeue();
        assertTrue(queueOfInts.isEmpty(), "Queue should be empty");
    }

    @Test
    void dequeueFromTail(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.dequeue());
        assertEquals(2, queueOfInts.peek());
    }

    @Test
    void numOfElemsChanges(){
        queueOfInts.enqueue(10);
        assertEquals(1, queueOfInts.numOfElems(), "Number of elems should change");
        queueOfInts.dequeue();
        assertEquals(0,queueOfInts.numOfElems());
    }

    @Test
    void peekShouldBeLastInElem(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(2, queueOfInts.peek(), "Peek should be last in elem");
    }

}

```