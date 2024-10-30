package org.example;

import java.util.Objects;

/**
 * House Class Specifications
 * 1. Include member variables for owner(String), value(int)
 * 2. Write a default constructor.
 * 3. Write a constructor that takes values for all member variables as parameters.
 * 4. Write a copy constructor (should be a DEEP COPY of the parameter). Here is the prototype:
 * House(House other)
 * 5. Implement get/set methods for all member variables.
 * 6. Write a deepCopy method (should be a DEEP COPY of the current instance). Here is the
 * prototype:
 * House deepCopy()
 * 7. Implement an equals override. It should return a value based on the “values” and not the
 * “references”. It should return true if the owners are equal (do a value compare on the
 * owners).
 * 8. Add a hashcode override to this class.
*  This method should generate a hash value.
 * Do NOT do a mod in this method.
 * You can use Java’s Objects.hash method to generate a hash code value
 *
 * @author zuxin chen
 */
public class House {
    private String owner;
    private int value;

    /**
     * default constructor
     */
    public House() {
        this.owner ="";
        this.value = 0;
    }

    /**
     * parameter constructor
     * @param owner house's owner
     * @param value house's value
     */
    public House(String owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    /**
     * DEEP COPY of the parameter
     * @param other current instance of parameter
     */
    public House(House other){
        this.owner = other.owner;
        this.value = other.value;
    }
    /**
     * DEEP COPY of the current instance
     * @return this class
     */
    public House deepCopy(){
        return new House(this);
    }

    /**
     * getter of owner
     * @return this owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * setter of owner
     * @param owner object
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * getter of value
     * @return this value
     */
    public int getValue() {
        return value;
    }

    /**
     * setter of value
     * @param value object
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * Implement an equals override. It should return a value based on the “values” and not the
     * “references”. It should return true if the owners are equal (do a value compare on the
     * owners).
     * @param obj input object
     * @return return true if the owners are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null){ // not null
            return false;
        }
        if(this.getClass() != obj.getClass()){ // not in same class
            return false;
        }
        if(this == obj){ // it is self
            return true;
        }

        House otherHouse = (House) obj; // casting to House type
        // it is true if owners are equal to obj
        return this.owner.equals(otherHouse.owner);

    }

    /**
     * This method generate a hash value.
     * @return hash code by Objects.hash()
     */
    @Override
    public int hashCode(){
        return Objects.hash(value);
    }



}
