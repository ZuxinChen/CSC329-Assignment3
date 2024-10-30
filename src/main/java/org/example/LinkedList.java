package org.example;

/*
  implication of singly linked list, and it stores instances of House

  @author zuxin chen
 */

/**
 * Node of singly linked list
 */
class Node {
    House value;
    Node next;

    /**
     * constructor of Node, next should point to next node, so it is null
     */
    Node(House value) {
        this.value = value;
        this.next = null;
    }
}

/**
 * linked list implication, only hold House object
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * default constructor
     */
    LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * add operation of linked list, add new node in linked list
     * @param house new node
     */
    void add(House house){
        Node newNode = new Node(house);

        if(head == null){ // if it is empty, add new node to head
            head = newNode;
            tail = newNode; //set tail to new node
        }else { // if not, add to next node
            tail.next = newNode;
            tail = newNode; //set tail to new node
        }
        size++;
    }

    /**
     * remove operation of linked list, remove a node from linked list
     * @param house target need to remove
     */
    void remove(House house){
        if(house == null){ // not change
            return;
        }
        Node prev = null;
        //prev -> x(a) -> n
        for(Node x = head; x != null; prev = x, x = x.next){
             if(x.value.equals(house)){
                 if(prev == null){ //remove head , head -> n ->...
                     head = x.next;
                 }else { // remove middle or tail, ...-> prev -> n -> ...
                     prev.next = x.next;
                 }
                 if(x == tail){ // update th tail, tail -> prev -> null
                     tail = prev;
                 }
                 size--;
                 return;
             }
        }
    }

    /**
     * find operation of linked list, find the index of target node
     * @param owner target need to find
     * @return target house, else return null
     */
    House find(String owner){
        for(Node x = head;x != null; x = x.next){
            if(x.value.getOwner().equals(owner)){
                return x.value;
            }

        }
        return null;
    }

    /**
     * get the size of list
     * @return size of list
     */
    int getSize(){return size;}

    /**
     * get of head node
     * @return head node of list
     */
    Node getHead() {
        return head;
    }

    /**
     * print all values
     */
    void print(){
        for(Node x = head;x != null; x = x.next){
            System.out.print("(" + x.value.getOwner() +"," +x.value.getValue() +") ");
        }
    }
}