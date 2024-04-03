package agh.ii.prinjava.proj1.impl;

import agh.ii.prinjava.proj1.MyQueue;

public class MyQueueDLLBImpl<E> implements MyQueue<E> {
    /**Implementation of a queue using a doubly-linked list.
     * @param <E> type of elem
     */
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

