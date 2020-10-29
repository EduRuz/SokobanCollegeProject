package sokoban;
/**
 * The directions of movement for the warehouse manager.
 * 
 * @author Ruaraidh Canaway
 */
public enum Direction {
    /** Movement up - decrement the y co-ordinate. */
    UP,

    /** Movement down - increment the y co-ordinate. */
    DOWN,

    /** Movement left - decrement the x co-ordinate. */
    LEFT,

    /** Movement right - increment the x co-ordinate. */
    RIGHT;
}