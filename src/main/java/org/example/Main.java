package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Do the following in main:
 * • You must read data from the input file and populate the hash table with that data.
 * • Print all data in the hash table on screen (organized by bucket).
 * • Write code to show that the following MyHashTable methods work properly:
 *      o Copy constructor
 *      o deepCopy
 *      o find
 */
public class Main {
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();
        fileReader(myHashTable);
        //printAll(myHashTable);

        test(myHashTable); //test Copy constructor , deepCopy and find methods
    }

    /**
     * read the value from file and add item in to a House array
     * @param myHashTable  holds the data of house
     */
    public static void fileReader(MyHashTable myHashTable) {
        String path = "src/main/resources/houses.txt";
        try (Scanner scnr = new Scanner(new File(path))){ // read the file
            while(scnr.hasNextLine()){ // read all texts

                House house = new House();

                String owner = scnr.nextLine(); // Read the owner
                house.setOwner(owner); // save owner

                int value = scnr.nextInt(); // Read the value
                house.setValue(value);// save value

                scnr.nextLine(); // jump to next line

                myHashTable.add(house);
            }

        }catch (FileNotFoundException e){
            System.out.println("Not found the file in " + path);
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Prints all data in the hash table.
     * @param myHashTable list need to print all data
     */
    static void printAll(MyHashTable myHashTable){
        myHashTable.show();
    }

    /**
     *  test Copy constructor , deepCopy and find methods
     * @param myHashTable use to search and copy instance
     */
    static void test(MyHashTable myHashTable){
        MyHashTable copyMyHashTable = new MyHashTable(myHashTable);
        MyHashTable deepCopyMyHashTable = myHashTable.deepCopy();

        String owner = "Nicole Lee";
        House findHouse = myHashTable.find(owner);
        House findHouse1 = copyMyHashTable.find(owner);
        House findHouse2 = deepCopyMyHashTable.find(owner);

        myHashTable.find(owner).setValue(100000);

        System.out.println("Original HashTable");
        findHouse(findHouse);

        copyMyHashTable.find(owner).setOwner("Lee");
        System.out.println("Copy HashTable(Copy constructor)");
        findHouse(findHouse1);

        System.out.println("Deep Copy HashTable(deepCopy method)");
        findHouse(findHouse2);




    }

    /**
     * a tool method to print message about finding
     * @param house finding house
     */
    private static void findHouse(House house){
        if (house == null) {
            System.out.println("Not found house by owner");
        } else {
            System.out.println("Owner " + house.getOwner() + " has house value " + house.getValue());
        }
    }



}