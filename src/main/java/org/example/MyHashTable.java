package org.example;

/**
 * Create a hash table with separate chaining that stores instances of House.
 * You must implement the hash table yourself.
 * DO NOT USE A JAVA COLLECTION CLASS FOR THE HASH TABLE!
 * It should use the MyList class you implemented to store bucket data.
 * DO NOT USE A JAVA COLLECTION CLASS FOR THE LIST!
 * MyHashTable Specifications
 * 1. Create private members as necessary. Use an array to store the buckets.
 * 2. Hash Function. When hashing to calculate a bucket index use the House.hashCode() method
 *      as the transform method (check slide 24 of the Hash Table Overview slides for hash function help).
 *      To do this you call the hashCode method on the House instance.
 *      Take the value returned by the House hashCode method and mod that value by the number of buckets
 *      and this will give you the bucket number.
 *      So, the House hashCode method is being used as the hashing transform method in this implementation.
 * 3. Your class must also implement the following methods (use the given method headers):
 *      a. Default constructor. The hash table should start with 4 buckets
 *          (this will force it to do resizes very early).
 *      b. Copy constructor (should be a DEEP COPY of the parameter).
 *          Here is the prototype: MyHashTable(MyHashTable other)
 *      c. MyHashTable deepCopy() - Write a deepCopy method (should be a DEEP COPY of the current instance).
 *          All rights reserved.
 *      d. void add(House) – Adds a house to the hash table.
 *          Use the House hashCode override to get a hash value.
 *          Make sure to use mod on the value returned by hashCode to get a bucket index.
 *          If the load factor is above .75 before adding the house,
 *          then double the size of the bucket array.
 *          All items will have to be rehashed and put into the new bucket array.
 *      e. House find(String owner) – Searches the hash table for the house with the given owner.
 *          It should return the House instance if it finds it, and null otherwise.
 *      f. void show() – Prints all data in the hash table.
 *          It should show data by bucket. The output should be organized and easy to read
 *          (not a blob of text that is poorly spaced and hard to read).
 */
public class MyHashTable {
    private MyList[] bucketsArray;
    int size; // size of hash table

    /**
     * Default constructor. The hash table should start with 4 buckets
     */
    public MyHashTable() {
        this.bucketsArray = new MyList[4];
        for (int i = 0; i < bucketsArray.length; i++) {
            bucketsArray[i] = new MyList();
        }
        this.size = 0;
    }

    /**
     * Copy constructor (should be a DEEP COPY of the parameter).
     * @param other other object need to deep copy to new instance
     */
    MyHashTable(MyHashTable other){
        bucketsArray = new MyList[other.bucketsArray.length];
        for (int i = 0; i < other.bucketsArray.length; i++) {
            bucketsArray[i] = new MyList(other.bucketsArray[i].deepCopy());
        }
        this.size = other.size;
    }

    /**
     * a deepCopy method (should be a DEEP COPY of the current instance)
     * @return a DEEP COPY of the current instance
     */
    MyHashTable deepCopy(){
        return new MyHashTable(this);
    }

    /**
     * Adds a house to the hash table.
     * Use the House hashCode override to get a hash value.
     * Make sure to use mod on the value returned by hashCode to get a bucket index.
     * If the load factor is above .75 before adding the house,
     * then double the size of the bucket array.
     * @param a new house need to add
     */
    void add(House a){
        int index = a.hashCode() % bucketsArray.length;
        double loadFactor = (double) size / bucketsArray.length;

        if(loadFactor > 0.75){
            resize(); // double the size of the bucket array.
        }

        bucketsArray[index].add(a); // add house in index with array
        size++;
    }

    /**
     * resize the bucket array as double size
     */
    private void resize(){
        MyList[] newBucketsArray = new MyList[bucketsArray.length*2];
        for (int i = 0; i < newBucketsArray.length; i++) {
            newBucketsArray[i] = new MyList();
        }
        for (MyList myList : bucketsArray) {
            LinkedList linkedList = myList.getMyList();
            Node node = linkedList.getHead();
            while (node != null) {
                House a = node.value;
                int index = a.hashCode() % newBucketsArray.length;
                newBucketsArray[index].add(a);
                node = node.next;
            }

        }

        bucketsArray = newBucketsArray; // change the reference
    }

    /**
     * Searches the hash table for the house with the given owner.
     * @param owner owner of house
     * @return return the House instance if it finds it, and null otherwise.
     */
    House find(String owner){
        for(MyList list: bucketsArray){
            if(list.find(owner) != null) {
                return list.find(owner);
            }
        }
        return null;
    }

    /**
     * Prints all data in the hash table.
     */
    void show(){
        if(bucketsArray == null){
            System.out.println("buckets is empty");
            return;
        }
        System.out.println("Size: "+size);
        System.out.println("load factor: "+ (double) size / bucketsArray.length);
        System.out.println("----Hash Table----");
        System.out.println("key\t: values");

        for (int i = 0; i < bucketsArray.length; i++) {
            System.out.print(i + "\t:");
            if(bucketsArray[i] != null) {
                bucketsArray[i].print();
            }
            System.out.println();
        }
    }
}
