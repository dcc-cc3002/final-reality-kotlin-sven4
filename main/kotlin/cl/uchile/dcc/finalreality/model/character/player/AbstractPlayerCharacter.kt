/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponEquipped
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.weapon.Weapon
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new playable character.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
abstract class AbstractPlayerCharacter(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractCharacter(name, maxHp, defense, turnsQueue),
    PlayerCharacter {

    private lateinit var scheduledExecutor: ScheduledExecutorService
    private lateinit var _equippedWeapon: Weapon
    override val equippedWeapon: Weapon
        get() = _equippedWeapon

    override fun equip(weapon: Weapon) {
        this._equippedWeapon = weapon.getEquiped(this)
    }

    override fun equipAxe(weapon: Weapon): Weapon {
        throw InvalidWeaponEquipped("This class cannot equip an Axe.")
    }

    override fun equipBow(weapon: Weapon): Weapon {
        throw InvalidWeaponEquipped("This class cannot equip a Bow.")
    }

    override fun equipKnife(weapon: Weapon): Weapon {
        throw InvalidWeaponEquipped("This class cannot equip a Knife.")
    }

    override fun equipStaff(weapon: Weapon): Weapon {
        throw InvalidWeaponEquipped("This class cannot equip a Staff.")
    }

    override fun equipSword(weapon: Weapon): Weapon {
        throw InvalidWeaponEquipped("This class cannot equip a Sword.")
    }

    override fun waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
        scheduledExecutor.schedule(
            /* command = */ ::addToQueue,
            /* delay = */ (this.equippedWeapon.weight / 10).toLong(),
            /* unit = */ TimeUnit.SECONDS
        )
    }

    /**
     * Adds this character to the turns queue.
     */
    private fun addToQueue() {
        turnsQueue.put(this)
        scheduledExecutor.shutdown()
    }
}
