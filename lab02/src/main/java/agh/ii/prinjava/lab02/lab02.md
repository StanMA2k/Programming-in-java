Final variables, methods, and classes
   Analyse the source code in packages:

lst02_01 (final variables)
lst02_02 (final methods)
lst02_03 (final classes)

Exercises

1. Look briefly at the chapters of Java Language Specification related to final variables, methods, and classes
2. Explain the benefits of using constants in programming

   A constant can declare an unchangeable value by defining a "final". It's easy to modify in case of changing the constant and prevent unexpected change during the programming.
3. Explain the meaning of keyword final when used for:

   local variables: this variable won't be changed

   instance variables: can't be changed once initialised 

   static constants: the static constant is at class level, not instance level. It's initialise when declared 

   methods: the method can't be overwritten

   classes: it won't have any subclasses (no inheritance)

4. Answer the following questions:

-If a class contains only private data fields and no setter methods, is the class immutable?

The two conditions are essential but there are more conditions. The class should be declared as "final", and the same for all its member variables (private final). The members should be initialised by constructors

-If all the data fields in a class are private and of primitive types, and the class does not contain any setter methods, is the class immutable?

Yes it is immutable
5. Explain why the following class is not immutable

```java
public class C {
private int[] values;

public int[] getValues() {
return values;
}
}
```
Because it exposes its internal state through the getValues(), which returns a reference to its private array values. Array is mutable so when this array is called, it may be changed.


[c] Refactor the source code to one file-one class structure


Enumeration classes (enums)
   Analyse the source code in package lst02_04
   Exercises


1. Look briefly at the chapters of Java Language Specification related to enum classes
2. Familiarise yourself with java.lang.Enum class
3. Analyse the following implementation of the singleton design pattern
enum EnumBasedSingleton {
INSTANCE;
int value;

public int getValue() {
return value;
}

public void setValue(int value) {
this.value = value;
}
}

Is this correct? Thread-safe?

This is correct and it is definitely thread-safe 
[c] Refactor the source code to one file-one class structure


Nested classes
   Analyse the source code in package lst02_05
   Note: nested classes: static and non-static member classes, local classes, and anonymous classes
   Exercises

1. Look briefly at the chapters of Java Language Specification related to Nested classes (a static and non-static member classes, local classes, and anonymous classes)
2. Explain the main differences between the types of nested classes available in Java

There are 2 types of nested class in java: static nested class and inner class. Static nested class is like a static member of outer class, it has access to all static members of outer class and can create instance without outer class instance.
Inner class also has access to outer class members, but it needs an instantiation of outer class to create inner class instance. 
3. Answer the following questions:

-Can an inner class be used in a class other than the class in which it nests?

Yes, for example in Main method an inner class can be used to create its instances. If the inner class is private it can't be used. 

-Can the modifiers public, protected, private, and static be used for inner classes?

Yes, this modifiers change the visibility of inner class.
[c] Refactor the source code to one file-one class structure

Abstract Data Types (abstract classes and interfaces)
   Analyse the source code in packages:

lst02_06 (abstract classes)
lst02_07, lst02_08, lst02_09 (interfaces)

Exercises


1. Look briefly at the chapters of Java Language Specification related to abstract classes and interfaces
2. Explain the main differences between abstract classes and interfaces in Java

An abstract class: static method, abstract method, concrete method, final method, constructor.
Interface: abstract method, default method, static method and private method;
Abstract class can have member variable and constant but interface can only have constant.
3. List possible types of members of Java interfaces

Constants(public static final by default), abstract methods
4. From the following list select the correct definition of an abstract class:
class A { abstract void m1() {} } 
public class abstract B { abstract void m1(); }
class C { abstract void m1(); }
abstract class D { protected void m1(); }
abstract class E { abstract void m1(); }

DE

5. From the following list select the correct definition of an interface:
interface A { void m1() {} }
abstract interface B { m1(); }
abstract interface C { abstract void m1() {} }
interface D { void m1(); }

D

6. Explain the output of running the class Main:
```java
interface A {}
class C {}
class D extends C {}
class B extends D implements A {}


public class Main {
public static void main(String[] args) {
B b = new B();
if (b instanceof A)
System.out.println("b is an instance of A");
if (b instanceof C)
System.out.println("b is an instance of C");
}
}
```
b is an instance of A 

b is an instance of C

[c] Refactor the source code to one file-one class structure


Functional interfaces and lambda expressions
   Analyse the source code in packages lst02_10 and lst02_12
   Exercises


1. Look briefly at the chapters of Java Language Specification related to functional interfaces and lambda expressions
2. Explain the relationship between lambda expressions and functional interfaces


3. Write functional interfaces that correspond to the following function types:

$void \rightarrow int$
$int \rightarrow void$
$int \rightarrow int$
$(int, int) \rightarrow void$

and then implement them (any implementation that compiles is good) using:

anonymous classes
lambda expressions

Note: any implementation that compiles is good


[c] Refactor the source code to one file-one class structure



Mini project 02_01 (exc02_01)
   [c] The implementation of interface StackOfInts:

Add JavaDoc comments to the interface and all its methods

/**
* Stack of integers - Abstract Data Type (ADT)
* This interface contains all methods that would be applied in ArrayBasedImpl, LinkedListBasedImpl and StackOfIntsFtry.
* Here is the list of usage for each method:
  *pop(): is used to delete an entered element
* push(): is used to enter a new element
* isEmpty(): check if the stack is empty
* numOfElems(): Calculate the number of elements in a stack
* peek(): get the peek element of a stack
  */

Add JavaDoc comments to LinkedListBasedImpl (the class itself and all its methods)

Complete the linked list based implementation - LinkedListBasedImpl.
Notes:

use nested class Node as the linked list building block
use the simplest possible implementation of the linked list, i.e,

it can be unidirectional
only two operations are required: adding and removing an element from the front of the list
```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
 *create a stack based on linked list
 */

public class LinkedListBasedImpl implements StackOfInts {

   /**
    *pop(): give exception message if the stack is empty, otherwise it delete the first elem in the stack
    */
   @Override
   public int pop() {
      if (first == null){
         throw new IllegalStateException("Stack is empty");
      }
      int elem = first.elem;
      first = first.next;
      numOfElems--;
      return elem;
   }

   /**
    *push(): add new elem in the stack
    */
   @Override
   public void push(int x) {
      first = new Node(x, first);
      numOfElems++;
   }

   /**
    *counter the elems in the stack
    */
   @Override
   public int numOfElems() {
      return numOfElems;
   }

   /**
    *peek(): give exception message if the stack is empty, otherwise it returns the first elem of the stack
    */
   @Override
   public int peek() {
      if (first == null){
         throw new IllegalStateException("Stack is empty");
      }
      return first.elem;
   }

   private static class Node {
      int elem;
      Node next;

      public Node(int elem, Node next) {
         this.elem = elem;
         this.next = next;
      }
   }

   private Node first = null;
   private int numOfElems = 0;
}

```
Write unit tests for different cases
```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.L_LIST_B);

    @BeforeEach
    void setUp() {
         StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.L_LIST_B);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty(), "A new stack should be empty");
    }

    @Test
    void pushElem(){
        stackOfInts.push(1);
        assertFalse(stackOfInts.isEmpty(), "Stack shouldn't be empty after first push");
    }

    @Test
    void popElem (){
        stackOfInts.push(1);
        stackOfInts.pop();
        assertTrue(stackOfInts.isEmpty(), "Stack should be empty after one push and one pop");
    }

    @Test
    void elemNum (){
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems(),"Number of element should increased after push");
    }

    @Test
    void peekElem(){
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek(), "Peek should be the last push element");
    }

}
```
Add JavaDoc comments to ArrayBasedImpl (to the class itself and all its methods)
Write unit tests for different cases (i.e. apply a TDD-like approach)
```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayBasedImplTest {

    // Create an empty stack
    private final StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);

    @BeforeEach
    void setUp() {
        StackOfInts stackOfInts = StackOfIntsFtry.create(StackOfIntsFtry.Impln.ARRAY_B);
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty());
    }

    @Test
    void popElem(){
        stackOfInts.push(1);
        stackOfInts.pop();
        assertTrue(stackOfInts.isEmpty(), "A stack should be empty");
    }

    @Test
    void pushElem(){
        stackOfInts.push(1);
        assertFalse(stackOfInts.isEmpty(), "A stack shouldn't be empty");
    }

    @Test
    void peekElem(){
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek(), "The top of the stack should be the last pushed element");
    }

    @Test
    void elemNum (){
        stackOfInts.push(1);
        assertEquals(1, stackOfInts.numOfElems(),"Number of element should increased after push");
    }
}
```
Complete the array based implementation - ArrayBasedImpl. Notes:

it should be an array of integers (int), and not, for instance, ArrayList<Integer>)
the size of the array should grow and shrink (according to some strategy) as elements are pushed and popped
```java
package agh.ii.prinjava.lab02.exc02_01.impl;

import agh.ii.prinjava.lab02.exc02_01.StackOfInts;

/**
 * Create a stack using an array
 */
public class ArrayBasedImpl implements StackOfInts {
   /**
    *Stack to create array list
    */
   @Override
   /**
    * delete top element of the array
    */
   public int pop() {
      if (isEmpty()){
         throw new IllegalStateException("Stack is empty");
      }
      size--;
      numOfElems--;
      return stack[--numOfElems];
   }

   /**
    *add element to the top of the array
    */
   @Override
   public void push(int x) {
      if (numOfElems == size) {
         size++;
      }
      int top;
      numOfElems++;
      top = stack[numOfElems++];
   }

   /**
    *return the numbers of element (size) in the array
    */
   @Override
   public int numOfElems() {
      return numOfElems;
   }

   /**
    *return the top element
    */
   @Override
   public int peek() {
      if (isEmpty()){
         throw new IllegalStateException("Stack is empty");
      }
      return stack[numOfElems-1];
   }

   private int numOfElems = 0;
   private int [] stack;
   private int size;//= numOfElems;

}
```