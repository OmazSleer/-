package by.model.entity;

/**
 * The BetType enum announces a type of bet.
 *
 * @author Rowan Morrison
 * @version 1.0
 */
public enum BetType {
    /**
     * Bet on win
     */
    WIN,
    /**
     * Bet on win or prize place
     */
    EACH_WAY,
    /**
     * Bet on what place horse takes
     */
    PLACE,
    /**
     * Bet that horse comes first, second or third
     */
    SHOW,
    /**
     * Bet if horse finishes
     */
    FINISH
}
