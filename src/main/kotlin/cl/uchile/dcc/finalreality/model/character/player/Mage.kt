package cl.uchile.dcc.finalreality.model.character.player

/**
 * A mage superclass for [WhiteMage] and [BlackMage], it's a type of [PlayerCharacter]
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */

interface Mage {
    val name: String
    val maxHp: Int
    val maxMp: Int
    var currentMp: Int
    val defense: Int
}
