package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.states.CharacterState
import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon
import cl.uchile.dcc.finalreality.model.weapon.Weapon
import java.util.concurrent.BlockingQueue

/**
 * An abstract mage class for [WhiteMage] and [BlackMage]
 *
 * @param name The name of the mage.
 * @param maxHp the max HP of the mage.
 * @param defense the defense of the mage.
 * @param maxMp the max MP of the mage.
 * @param turnsQueue  the queue with the characters waiting for their turn
 *
 * @property currentMp The current MP of the mage.
 * @property currentHp The current HP of the mage.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */

abstract class AbstractMage(
    name: String,
    maxHp: Int,
    defense: Int,
    maxMp: Int,
    turnsQueue: BlockingQueue<GameCharacter>,
) : AbstractPlayerCharacter(
    name, maxHp, defense, turnsQueue
) {
    override lateinit var state: CharacterState
    val maxMp = Require.Stat(maxMp, "Max MP") atLeast 0
    var currentMp: Int = maxMp
        set(value) {
            field = Require.Stat(
                value, "Current MP"
            ) inRange 0..maxMp
        }
}
