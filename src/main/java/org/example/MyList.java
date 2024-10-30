package org.example;

/**
 * Create a singly-linked-unordered list that stores instances of House.
 * You must implement the list yourself. DO NOT USE A JAVA COLLECTION CLASS FOR THE LIST!
 * MyList Specifications
 * 1. Create private members as necessary.
 * 2. Your class must also implement the following methods (use the given method headers):
 *      a. Default constructor.
 *      b. Copy constructor (should be a DEEP COPY of the parameter).
 *      Here is the prototype: MyList(MyList other)
 *      c. MyList deepCopy() - Write a deepCopy method (should be a DEEP COPY of the current instance).
 *      d. void add(House) – Adds a house to the start of the list.
 *      e. House find(String owner) – Searches the list for the house with the given owner.
 *      It should return the House instance if it finds it, and null otherwise.
 *
 * @author zuxin chen
 */
public class MyList {
    private final LinkedList myList;

    /**
     * Default constructor
     */
    MyList() {
        this.myList = new LinkedList();
    }
    /**
     * Copy constructor, a DEEP COPY of the parameter.
     * @param other other object need to deep copy to new instance
     */
    MyList(MyList other){
        myList = new LinkedList();
        Node crruNode = other.myList.getHead();
        while (crruNode != null){
            myList.add(new House(crruNode.value).deepCopy());
            crruNode = crruNode.next;
        }

    }

    /**
     * a DEEP COPY of the current instance
     * @return new instance
     */
    MyList deepCopy(){return new MyList(this);}

    /**
     * Adds a house to the start of the list.
     */
    void add(House a){
        myList.add(a);
    }

    /**
     * searches the list for the house with the given owner.
     * @param owner owner need to search house
     * @return return the House instance if it finds it, and null otherwise.
     */
    House find(String owner){
        return myList.find(owner);
    }

    /**
     * getter of myList
     * @return instance of myList
     */
    public LinkedList getMyList() {
        return myList;
    }

    /**
     * print all values of list
     */
    void print(){
        myList.print();
    }


}
