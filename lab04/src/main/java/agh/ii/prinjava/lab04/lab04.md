1) Concepts of parametric polymorphism, type constructor, and type variable

Exercises

Familiarise yourself with The Java Tutorials > Generics

Look briefly at the chapters of Java Language Specification related to:


Generics, or "parameterized types." When we talk about parameters, what comes most familiarly to mind is the parameter list defined in a method. In the parameter list of a common method, the data type of each parameter is determined, while the variable is a parameter. When calling a common method, it is necessary to pass in a variable (actual parameter) that matches the data type defined for the formal parameter. If the actual parameter passed does not match the data type defined for the formal parameter, an error will be reported.

Generic Classes: class Name<T,R...>{members};
T: Represents any general class.
E: Stands for Element, or it can mean Exception.
K: Stands for Key.
V: Stands for Value, usually used in conjunction with K.
S: Stands for Subtype.
```java
public class Generic<T> {
// The member type is T
private T key;

    public Generic(T key) { 
        this.key = key;
    }
    
    public T getKey(){ 
        return key;
    //can be instanced as any "Generic" type, e.g. Generic<String>, Generic<Integer>  
    }
}
```
Generic Methods: must declare the data type of T when creating an instance, or default as <object>
```java
@ Test
public void test() {
	Generic<String> generic = new Generic<>();// typs is string
	
	// no indecated type in <> = Generic<Object> generic = new Generic<>();
	Generic generic = new Generic();
}
```

Generic Interfaces: the type parameter of a generic interface is defined when inherited or realized
```java
public interface Inter<T> {
public abstract void show(T t) ;
}
```
2) Generic methods, classes, and interfaces

Analyse the source code in packages:

lst04_01
lst04_02
lst04_03
Exercises

Explain the benefits of using generic types

Using generic types enforces review of type (find type error in compilation), it provides different data type in only one code, which would also increase the encapsulation of the code

Explain the syntax of:

generic class declaration: public class Generic<T1,T2,...Tn>{} //Tn here means different data type

generic method declaration: public <T> T genericMethod(T t) {method}

Explain what a raw type is, why it is unsafe, and why the raw types are allowed in Java

In generic classes, a raw type is a data type that carries no actual type argument, e.g. between List<E> and List, List is a raw type. A rar type is made to compatible with old time when Generic isn't exist. Compared to Generic, raw type can't have a type check or a type argument, so it's unsafe.

Given GenBox as defined in lst04_01 explain the compilation result of:
```java
// (a)
GenBox gb1 = new GenBox(1);
        gb1.setX("abc");
        gb1.setX(new GenBox(true)); //true, the default type is String
```
```java
//b
 GenBox<Integer> gb2 = new GenBox(1);
        gb2.setX("abc");
        gb2.setX(new GenBox(true)); //error, 1 is integer, "abc" is String
```

[c] Complete the method header in the following code so that it compiles:
```java
public class Main {
public static void main(String[] args ) {
Integer[] ints = {1, 2, 3};
String[] strs = {"A", "B", "C"};

        print(ints);
        print(strs);
    }

    public static class GenArray<T> {
        public void print(T[] elems) {
    for (int i = 0; i < elems.length; i++)
        System.out.print(elems[i] + " ");
    System.out.println();
    }
} }
```
[c] Refactor the source code to one file-one class structure

[c] Implement the generic class Pair<F,S> (see exc04_01):

add at least one constructor (two parameters: F fst and S snd)
add the accessors ("getters") and mutators ("setters")
add toString, equals, hashCode
add clone method
add unit tests
```java
package agh.ii.prinjava.lab04.exc04_01;

import java.util.Objects;

public class Pair<F,S> implements Cloneable {
    private F fst;
    private S snd;
    public Pair(F fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }


    public void setF (F fst){
        this.fst = fst;
    }
    public F getF(){
        return this.fst;
    }


    public void setS (S snd){
        this.snd = snd;
    }
    public S getS(){
        return this.snd;
    }

    @Override
    public String toString(){
        return ("First is: " + getF() + "\nSecond is: " + getS());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        };
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(fst, pair.fst) && Objects.equals(snd, pair.snd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}


```
```java
package agh.ii.prinjava.lab04.exc04_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    Pair<Integer, String> pairOfIntStr;

    @BeforeEach
    void setUp() {
        pairOfIntStr = new Pair<>(1, "snd");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void t1() {
        assertTrue(true);
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        super.clone();
        assertEquals(pairOfIntStr,clone(),"Cloned pair should be same as original pair" );
    }
}
```
3) Bounds for type variables

Analyse the source code in packages:

lst04_04
lst04_05
Exercises

Explain the purpose of bounds for type variables

Bounds for type variables are used in generic to restrict the type of elem by using interface, e.g. interface a{} class GenClass <T extends a>{}, the output type is restricted as a.

Check if a type variable may have many interface bounds. Repeat this for class bounds.
```java
<T extends InterfaceA & InterfaceB & InterfaceC>
```
[c] Change the following generic function so that it compiles

```java
interface Moveable{
    void goTo(double x, double y);
}
public class move{
// Moving all elements of the array to point (x,y)
private static <T extends Moveable> void moveAll(T[] elems, double x, double y) {
for (var e : elems) {
e.goTo(x, y);
}
}
}
```
Hint: first declare interface Moveable, and then use it as the bound for the type variable

4) Subtyping and Wildcards

Analyse the source code in package lst04_06

Exercises

Explain the notions of

invariance
covariance
contravariance
of generic types (type constructors)

A container with a generic type does not become a subtype with the subtyping relationship of its element types. If we have a List<T>, if A is a subtype of B, there is no subtype relationship between List<A> and List<B>.
```java
//a covariance example
List<? extends Number> covariantList; //change type with subtype
//a contravariance example
List<? super Integer> contravariantList; 

```
Explain the notions of:

subtype wildcard
supertype wildcard
unbounded wildcard
Given:
```java
class A {}
class B extends A {}
class C extends B {}
class GenBox<T> {
private T x;
public T getX() { return x; }
public void setX(T x) { this.x = x; }
//...
}
```
from the following lines point out these that do not compile (explain each error):
```java
GenBox<B> gb1 = new GenBox<B>();
GenBox<B> gb2 = new GenBox<C>(); //require type B
GenBox<B> gb3 = new GenBox<A>();// as above
B b1 = gb1.getX();
gb1.setX(new B());

GenBox<? extends B> gb4 = new GenBox<B>();
GenBox<? extends B> gb5 = new GenBox<C>();
GenBox<? extends B> gb6 = new GenBox<A>();// require type <? extends B>, A is not a subtype of B
B b2 = gb5.getX();
gb5.setX(new B());// can't add elem to B
gb5.setX(new C());//as above 

GenBox<? super B> gb7 = new GenBox<B>();
GenBox<? super B> gb8 = new GenBox<C>();//C is not a superclass of B 
GenBox<? super B> gb9 = new GenBox<A>();
B b3 = gb9.getX();// gp9.getX() return an Object
gb9.setX(new B());
gb9.setX(new C());

GenBox<?> gb10 = new GenBox<B>();
GenBox<?> gb11 = new GenBox<C>();
GenBox<?> gb12 = new GenBox<A>();
B b4 = gb10.getX();//gb10.getX() return an Object
gb10.setX(new B());//can't add elem except null
```

5) Mini project 04_01 (exc04_02)

[c] Implementation of generic interfaces MyStack<E> and MyQueue<E>:

Augment these interfaces with exception handling
Complete MyStackDLLBImpl and MyQueueDLLBImpl (DLLB - Doubly Linked List Based)
Add JavaDoc comments to both interfaces and implementation classes
Write unit tests
```java
package agh.ii.prinjava.lab04.exc04_02.impl;


public class DLinkList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public boolean listIsEmpty(){
        return size== 0;
    }

    private static class Node<T> {
        T elem;
        Node<T> next;
        Node<T> prev;

        /**
         * Constructor of node
         * @param elem the elem of this node
         * @param prev the previous node in the list
         * @param next the next node in the list
         */
        Node(T elem, Node<T> prev, Node<T> next) {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }

    }
    public E deleteElem(){
        E elem = first.elem;
        Node<E> next = first.next;
        first.elem = null;
        first.next = null;
        first = next;
        if (first == null){
            last = null;
        }
        size--;
        return elem;
    }

    public void addElemToQueue(E x){
        final Node<E> f = last;
        final Node<E> newNode = new Node<>(x, f, null);
        last = newNode;
        if (f == null) {
            first = newNode;
        } else {
            f.next = newNode;
        }
        size++;
    }
    public void addElem(E x){
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(x, null, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public E peekElem(){
        return first.elem;
    }


}
```
```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLinkListTest {

    DLinkList<Integer> dLinkList = new DLinkList<>();

    @BeforeEach
    void setUp() {
        dLinkList = new DLinkList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteElem(){
        dLinkList.addElem(1);
        dLinkList.deleteElem();
        assertTrue(dLinkList.listIsEmpty(),"Linked list should be empty");
    }

    @Test
    void addElem(){
        dLinkList.addElem(1);
        assertFalse(dLinkList.listIsEmpty(), "Linked list shouldn't be empty");
    }

    @Test
    void addElemToQueue(){
        dLinkList.addElemToQueue(1);
        dLinkList.addElemToQueue(2);
        assertEquals(1, dLinkList.peekElem());
    }

    @Test
    void peakElem(){
        dLinkList.addElem(1);
        dLinkList.addElem(2);
        assertEquals(2, dLinkList.peekElem(), "Peek elem should be last added elem");
    }
}
```
```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.w3c.dom.Node;

/**
 * A stack implementation using a doubly-linked list as the underlying data structure.
 * @param <E> the type of elements held in this stack
 */
public class MyStackDLLBImpl<E> extends DLinkList<E> implements MyStack<E> {
    private DLinkList<E> elems;

    public MyStackDLLBImpl() {
        this.elems = new DLinkList<>();
    }

    /**
     * Remove elem from the stack
     * @return the element removed from the top of the stack
     */
    @Override
    public E pop() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elems.deleteElem();
    }

    /**
     * Push an elment to the top of the stack
     * @param x the element should be pushed to the top
     */
    @Override
    public void push(E x) {
        elems.addElem(x);
    }

    /**
     * Count the size of ths stack
     * @return size of the stack
     */
    @Override
    public int numOfElems() {
        return elems.size;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * @return the top element of the stack
     */
    @Override
    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
    return elems.peekElem();
    }


    /**
     * Inner class implementing  double linked list
     * @param <E> type of elements in node
     */
    public class DLinkList<E> {
        private Node<E> first;
        private Node<E> last;
        private int size = 0;

        private static class Node<T> {
            T elem;
            Node<T> next;
            Node<T> prev;

            /**
             * Constructor of node
             * @param elem the elem of this node
             * @param prev the previous node in the list
             * @param next the next node in the list
             */
            Node(T elem, Node<T> prev, Node<T> next) {
                this.elem = elem;
                this.prev = prev;
                this.next = next;
            }

        }
        public E deleteElem(){
            E elem = first.elem;
            Node<E> next = first.next;
            first.elem = null;
            first.next = null;
            first = next;
            if (first == null){
                last = null;
            }
            size--;
            return elem;
        }
        public void addElem(E x){
            final Node<E> f = first;
            final Node<E> newNode = new Node<>(x, null, f);
            first = newNode;
            if (f == null) {
                last = newNode;
            } else {
                f.prev = newNode;
            }
            size++;
        }

        public E peekElem(){
            return first.elem;
        }

    }

}
```
```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackDLLBImplTest {

    MyStack<Integer> stackOfInts = MyStack.<Integer>create();

    @BeforeEach
    void setUp() {
       stackOfInts = MyStack.<Integer>create();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newStackIsEmpty() {
        assertTrue(stackOfInts.isEmpty(),"A new stack should be empty");
    }

    @Test
    void pushElem(){
        stackOfInts.push(1);
        assertFalse(stackOfInts.isEmpty(), "Stack shouldn't be empty after push");
    }

    @Test
    void popElem(){
        stackOfInts.push(1);
        stackOfInts.pop();
        assertTrue(stackOfInts.isEmpty(), "Stack shouldn't have element");
    }

    @Test
    void peekElem(){
        stackOfInts.push(1);
        stackOfInts.push(2);
        assertEquals(2, stackOfInts.peek(),"Peek should be last pushed element");
    }

}
```
```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;

/**Implementation of a queue using a doubly-linked list.
 * @param <E> type of elem
 */
public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    private DLinkList<E> elems;

    /**
     * Create a new queue
     */
    public MyQueueDLLBImpl() {
        this.elems = new DLinkList<>();
    }

    /**
     * Add elem to the end of queue
     * @param x the elem to add
     */
    @Override
    public void enqueue(E x) {
        elems.addElemToQueue(x);
    }

    /**
     * Remove elem from the head of queue
     * @return the head of the queue
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return elems.deleteElem();
    }

    /**
     * Count the number of elem in the queue
     * @return the number of elem in the queue
     */
    @Override
    public int numOfElems() {
        return elems.size;
    }


    /**
     * Return the head of the queue
     * @return the head of the queue 
     */
    @Override
    public E peek() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return elems.peekElem();
    }


    public class DLinkList<E> {
        private Node<E> first;
        private Node<E> last;
        private int size = 0;
        private static class Node<T> {
            T elem;
            Node<T> next;
            Node<T> prev;

            Node(T elem, Node<T> prev, Node<T> next) {
                this.elem = elem;
                this.prev = prev;
                this.next = next;
            }

        }
        public E deleteElem(){
            E elem = first.elem;
            Node<E> next = first.next;
            first.elem = null;
            first.next = null;
            first = next;
            if (first == null){
                last = null;
            }
            size--;
            return elem;
        }
        public void addElemToQueue(E x){
            final Node<E> f = last;
            final Node<E> newNode = new Node<>(x, f, null);
            last = newNode;
            if (f == null) {
                first = newNode;
            } else {
                f.next = newNode;
            }
            size++;
        }

        public E peekElem(){
            return first.elem;
        }


    }

}
```
```java
package agh.ii.prinjava.lab04.exc04_02.impl;

import agh.ii.prinjava.lab04.exc04_02.MyQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueDLLBImplTest {

    MyQueue<Integer> queueOfInts = MyQueue.<Integer>create();

    @BeforeEach
    void setUp() {
        queueOfInts = MyQueue.<Integer>create();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newQueueIsEmpty() {
        assertTrue(queueOfInts.isEmpty(),"A new queue shouldn't be empty");
    }

    @Test
    void enqueueElem(){
        queueOfInts.enqueue(1);
        assertFalse(queueOfInts.isEmpty(), "Stack shouldn't be empty after push");
    }

    @Test
    void dequeueElem(){
        queueOfInts.enqueue(1);
        queueOfInts.dequeue();
        assertTrue(queueOfInts.isEmpty(), "Stack shouldn't have element");
    }

    @Test
    void peekElem(){
        queueOfInts.enqueue(1);
        queueOfInts.enqueue(2);
        assertEquals(1, queueOfInts.peek(),"Peek should be last pushed element");
    }

}
```
