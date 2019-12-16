package by.model.entity;


import java.io.Serializable;

/**
 * Bet - a class that describe bets
 * by participant on races. Such as:
 * <ul>
 *     <li>A placed money</li>
 *     <li>Participant that place bet</li>
 *     <li>Horse on which money placed</li>
 * </ul>
 * @author Rowan Morrison
 * @version 1.0
 */
public class Bet extends Entity implements Serializable, Comparable<Bet> {
    /**
     * Constructor, which set all the fields of the
     * bet in default values.
     */
    public Bet(int id, BetType betType, double money, int participantId, int horseId) {
        this.setId(id);
        this.betType = betType;
        this.money = money;
        this.participantId = participantId;
        this.horseId = horseId;
    }

    /**
     * Empty constructor
     * bet in default values.
     */
    public Bet() {

    }
    /** Field, that describes a placed money*/
    private double money;

    /** Field, that describes participant who placed bet*/
    private int participantId;

    /** Field, that describes horse on which money placed*/
    private int horseId;

    /** Field, that describes type of bet*/
    private BetType betType;

    /** Field, that describes if bet is win*/
    private boolean IsWin;

    /** Field, that describes how much money bet wins*/
    private double winMoney;

    /** Field, that describes a coefficient on which multiply money if bet wins*/
    private double coefficient;

    /**
     * Method to get the value field {@link Bet#coefficient}
     *
     * @return Return coefficient
     */
    public double getCoefficient() {
        return coefficient;
    }

    /**
     * @param coefficient - coefficient on which multiply money if bet wins
     */
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    /**
     * Method to get the value field {@link Bet#money}
     *
     * @return Return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * Method to set the value field {@link Bet#money}
     *
     * @param money to bet
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * Method to get the value participant {@link Bet#participantId}
     *
     * @return Return participant
     */
    public int getParticipantId() {
        return participantId;
    }

    /**
     * Method to set the value field {@link Bet#participantId}
     *
     * @param participant who placed a bet
     */
    public void setParticipantId(int participant) {
        this.participantId = participant;
    }

    /**
     * Method to get the value type of bet {@link Bet#betType}
     *
     * @return Return betKind
     */
    public BetType getBetType() {
        return betType;
    }

    /**
     * Method to set the value field {@link Bet#betType}
     *
     * @param betType of bet
     */
    public void setBetType(BetType betType) {
        this.betType = betType;
    }

    /**
     * Method to get the value type of bet {@link Bet#horseId}
     *
     * @return Return horse
     */
    public int getHorseId() {
        return horseId;
    }

    /**
     * Method to set the value field {@link Bet#horseId}
     *
     * @param horse on which placed bet
     */
    public void setHorseId(int horse) {
        this.horseId = horse;
    }

    /**
     * Method to get the value type of bet {@link Bet#IsWin}
     *
     * @return Return IsWin
     */
    public boolean isWin() {
        return IsWin;
    }

    /**
     * Method to set the value field {@link Bet#horseId}
     * and count wined money if bet is win
     *
     * @param win show if bet is wins
     */
    public void setWin(boolean win) {
        IsWin = win;
    }

    /**
     * Method to get the value type of bet {@link Bet#winMoney}
     *
     * @return Return winMoney
     */
    public double getWinMoney() {
        return winMoney;
    }

    /**
     * Method to set money winned from bet
     *
     * @param money
     */
    public void setWinMoney(double money) {
        this.winMoney = money;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return String with all fields of the class.
     */
    @Override
    public String toString() {
        return "Participant id: " + this.participantId + "\t\tBet: " + this.money + "\tHorse id: " + this.horseId +
                "\tType of bet:" + this.betType;
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
        if (obj instanceof Bet) {
            Bet temp = (Bet) obj;
            return Math.abs(this.money - this.money) < 0.00001 &&
                    this.participantId == temp.participantId &&
                    this.horseId == temp.horseId &&
                    this.betType.equals(temp.betType) &&
                    (this.IsWin == temp.IsWin) &&
                    Math.abs(this.winMoney - this.winMoney) < 0.00001 &&
                    (Math.abs(this.coefficient - this.coefficient) < 0.00001);
        } else return false;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return hash code of object
     */
    @Override
    public int hashCode(){
        int result = participantId;
        result = 31 * result + (horseId * (int)money);
        return result;
    }


    @Override
    public int compareTo(Bet o) {
        return 0;
    }
}
