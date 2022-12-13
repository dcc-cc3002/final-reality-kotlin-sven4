/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.weapon.Weapon

/**
 * A character controlled by the user.
 *
 * @property equippedWeapon
 *    the weapon that the character is currently using
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
interface PlayerCharacter {
    val equippedWeapon: Weapon

    /**
     * Equips a weapon to the character.
     */
    fun equip(weapon: Weapon)
    fun equipAxe(weapon: Weapon): Weapon
    fun equipStaff(weapon: Weapon): Weapon
    fun equipSword(weapon: Weapon): Weapon
    fun equipKnife(weapon: Weapon): Weapon
    fun equipBow(weapon: Weapon): Weapon
}
