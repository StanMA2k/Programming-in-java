package agh.ii.prinjava.proj1.impl;

import java.util.NoSuchElementException;

/**
 * Doubly linked list implementation
 *
 * @param <E> the type of elements stored in the list
 */
public class DLinkList<E> {
    private Node<E> first;
    private Node<E> last;
    int size;

    /**
     * Constructs an empty doubly linked list.
     */
    public DLinkList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Adds the specified element at the beginning of the list.
     *
     * @param elem the element to add
     */
    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(elem);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    /**
     * Adds the specified element at the end of the list.
     *
     * @param elem the element to add
     */
    public void addLast(E elem) {
        Node<E> newNode = new Node<>(elem);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the first element of the list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedElem = first.elem;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
        return removedElem;
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the last element of the list
     * @throws NoSuchElementException if the list is empty
     */
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E removedElem = last.elem;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
        return removedElem;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.elem);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the first element in the list without removing it
     *
     * @return the first element
     */
    public E peekElem() {
        return first.elem;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return {@code true} if the list is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<E> {
        E elem;
        Node<E> prev;
        Node<E> next;

        Node(E elem) {
            this.elem = elem;
            prev = null;
            next = null;
        }
    }
}
