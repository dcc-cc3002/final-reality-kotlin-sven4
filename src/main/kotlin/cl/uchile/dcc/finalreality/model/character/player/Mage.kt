package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.GameCharacter

import java.util.concurrent.BlockingQueue

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

open class Mage(
    name: String,
    maxHp: Int,
    maxMp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractPlayerCharacter(name, maxHp, defense, turnsQueue) {
    val maxMp = Require.Stat(maxMp, "Max MP") atLeast 0
    var currentMp: Int = maxMp
        set(value) {
            field = Require.Stat(value, "Current MP") inRange 0..maxMp
        }
}