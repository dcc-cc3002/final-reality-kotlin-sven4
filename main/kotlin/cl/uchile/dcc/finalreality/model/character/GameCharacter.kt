package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.states.CharacterState

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @property name
 *    The name of the character.
 * @property maxHp
 *    The maximum health points of the character.
 * @property defense
 *    The defense of the character.
 * @property currentHp
 *    The current health points of the character.
 * @property state
 *    The current state of the character.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
interface GameCharacter {
    val name: String
    val maxHp: Int
    var currentHp: Int
    val defense: Int
    var state: CharacterState

    /**
     * Sets a scheduled executor to make this character (thread) wait for `speed / 10`
     * seconds before adding the character to the queue.
     */
    fun waitTurn()

    /**
     * Function that manage the states of the characters
     */
    fun paralyze()
    fun poison()
    fun burned()
    fun isParalyzed() : Boolean
    fun isPoison() : Boolean
    fun isBurned() : Boolean
}
