package kotlin.cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.exceptions.Require

/**
 * An abstract class for the common weapons.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage and speed.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
abstract class CommonWeapon(
    override val name: String,
    damage: Int,
    weight: Int,
) : Weapon {
    override val damage = Require.Stat(damage, "Damage") atLeast 0
    override val weight = Require.Stat(weight, "Weight") atLeast 0
}
