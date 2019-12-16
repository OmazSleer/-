package by.model.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Race extends Entity implements Serializable, Comparable<Race> {

    /**
     * It creates a new object with the specified values
     *
     * @param bets - array of bets thar placed on race
     * @param horses - array of horses that participate on race
     * @see Race#Race()
     */
    public Race(ArrayList<Bet> bets, ArrayList<Horse> horses) {
        this();
        this.horses = horses;
        this.bets = bets;
    }
    /**
     * Create a new empty object
     *
     * @see Race#Race(ArrayList, ArrayList)
     */
    public Race() {
        bets = new ArrayList<>();
        horses = new ArrayList<>();
    }

    /** Field, that describes bets that placed on race*/
    private ArrayList<Bet> bets;

    /** Field, that describes horses which participating in race*/
    private  ArrayList<Horse> horses;

    /** Field, that indicates if race is finished*/
    private boolean isCompleted;

    /** Field, that describes a winning horse */
    private  Horse winner;

    /**
     * Method to get the value {@link Race#bets}
     *
     * @return Return bets
     */
    public ArrayList<Bet> getBets() {
        return bets;
    }

    /**
     * Method to get the value {@link Race#isCompleted}
     *
     * @return Return isCompleted
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Method to set the value is race completed
     * @param isCompleted - bool if race completed
     */
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    /**
     * Method to get value {@link Race#winner}
     *
     * @return Return winner
     */
    public Horse getWinner() {
        return winner;
    }

    /**
     * Method to set value {@link Race#winner}
     * and finish race {@link Race#isCompleted}
     *
     * @param  winner - horse which wins
     */
    public void setWinner(Horse winner) {
        isCompleted = true;
        this.winner = winner;
    }

    /**
     * Method to place bet
     *
     * @param bet - new bet
     */
    public boolean addBet(Bet bet) {
        if (isCompleted) return false;
        bets.add(bet);
        return true;
    }

    /**
     * Method to get value {@link Race#horses}
     *
     * @return Return horses
     */
    public List<Horse> getHorses() {
        return horses;
    }

    /**
     * Method add horse in race
     *
     * @param horse - new horse
     */
    public void addHorse(Horse horse) {
        horses.add(horse);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return String with all fields of the class.
     */
    @Override
    public String toString() {
        String result = "";
        for (Horse horse :
                horses) {
            result += horse.toString() + "\n";
        }
        return result + "\tIs finished: " + isCompleted;
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
        if (obj instanceof Race) {
            Race temp = (Race) obj;
            return this.horses.equals(temp.horses) &&
                    this.winner.equals(temp.winner) &&
                    (this.isCompleted == temp.isCompleted) &&
                    this.bets.equals(temp.bets);
        } else return false;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return hash code of object
     */
    @Override
    public int hashCode(){
        int result = 0;
        for (Horse horse :
                horses) {
            result += horse.hashCode();
        }
        return result;
    }


    @Override
    public int compareTo(Race o) {
        return 0;
    }
}
