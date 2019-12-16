package by.model.entity;

//import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * Participant - a class that describe participant
 * that placed bet. Such as:
 * <ul>
 *     <li>Name</li>
 *     <li>Money</li>
 * </ul>
 * @author Rowan Morrison
 * @version 1.0
 */
public class Participant extends Entity implements Serializable, Comparable<Participant> {
    /**
     * Constructor, which set all the fields of the
     * horse in default values.
     */
    public Participant(String name) {
        this.name = name;
    }

    /** Field, that describes a participant name*/
    private String name;

    /** Field, that describes a participant money*/
    private double money;

    /**
     * Method to get the value field {@link Participant#money}
     *
     * @return Return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * Method to set the value of money{@link Participant#money}
     *
     * @return Return money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Method to get the value field {@link Participant#name}
     *
     * @return Return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - name of participant
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return String with all fields of the class.
     */
    @Override
    public String toString() {
        return "Name: " + this.name + "\tMoney: " + this.money;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj object to be checked for equivalence
     * @return return true if objects is equal and false in otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof Participant) {
            Participant temp = (Participant) obj;
            return this.name.equals(temp.name) &&
                    Math.abs(this.money - this.money) <= 0.00001;
        } else return false;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return hash code of object
     */
    @Override
    public int hashCode(){
        int result = name != null ? name.hashCode()
                : 0;
        result = 31 * result + (int) money * 24;
        return result;
    }

    @Override
    public int compareTo(Participant o) {
        return 0;
    }

    //@Override
   // public int compareTo(@NotNull Participant participant) {
      //  return this.name.compareTo(participant.name);
   // }
}
