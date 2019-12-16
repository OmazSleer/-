package by.model.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * Horce - a class that describe horse
 * that participant on races. Such as:
 * <ul>
 *     <li>Horse name</li>
 *     <li>Wight horse</li>
 *     <li>Horses jockey</li>
 * </ul>
 * @author Rowan Morrison
 * @version 1.0
 */
public class Horse extends Entity implements Serializable, Comparable<Horse> {
    /**
     * Constructor, which set all the fields of the
     * horse in default values.
     */
    public Horse(String name)
    {
        this.name = name;
    }

    /** Field, that describes a horse name*/
    private String name;

    /** Field, that describes a horse weight*/
    private int weight;

    /** Field, that describes a horse's jockey*/
    private String jockey;

    /** Field, that describes a date of horse's last run*/
    private Date lastRun;

    /** Field, that describes a age of horse*/
    private int age;

    /**
     * Method to get the value field {@link Horse#name}
     *
     * @return Return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - new name of horse
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the value field {@link Horse#weight}
     *
     * @return Return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight - new horse wight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Method to get the value field {@link Horse#jockey}
     *
     * @return Return jockey
     */
    public String getJockey() {
        return jockey;
    }

    /**
     * @param jockey - new horse jockey
     */
    public void setJockey(String jockey) {
        this.jockey = jockey;
    }

    /**
     * Method to get the value field {@link Horse#lastRun}
     *
     * @return Return lastRun
     */
    public Date getLastRun() {
        return lastRun;
    }

    /**
     * @param lastRun - date of horse's last run
     */
    public void setLastRun(Date lastRun) {
        this.lastRun = lastRun;
    }

    /**
     * Method to get the value field {@link Horse#age}
     *
     * @return Return age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age - new age of horse
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return String with all fields of the class.
     */
    @Override
    public String toString() {
        return "Id: " + this.getId() +  " Name: " + this.name + "\tAge: " + this.age + "\tWeight: " + this.weight + "\tJockey: " + this.jockey +
                "\tLast run: " + this.lastRun;
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
        if (obj instanceof Horse) {
            Horse temp = (Horse) obj;
            return this.name.equals(temp.name) &&
                    (this.age == temp.age) &&
                    this.jockey.equals(temp.jockey) &&
                    (this.weight == temp.weight) &&
                    this.lastRun.equals(temp.lastRun);
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
        result = 31 * result + (jockey != null ? jockey.hashCode() : 0) * age;
        return result;
    }

    @Override
    public int compareTo(Horse o) {
        return 0;
    }

    // @Override
    //public int compareTo(@NotNull Horse horse) {
      //  return this.name.compareTo(horse.name);
   // }
}
