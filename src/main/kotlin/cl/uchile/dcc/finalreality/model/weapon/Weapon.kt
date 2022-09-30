package cl.uchile.dcc.finalreality.model.weapon

/**
 * An interface that holds all the attributes for the weapons.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */

interface Weapon {
    val name: String
    val damage: Int
    val weight: Int
}