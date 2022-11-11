package kotlin.cl.uchile.dcc.finalreality.model.weapon

import cl.uchile.dcc.finalreality.exceptions.Require

/**
 * A class that holds all the information of a weapon.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 * @property magicDamage Int
 *     The base magic damage done by the magic weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, speed, it's type,
 *              and base magic damage.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
abstract class MagicWeapon(
    override val name: String,
    damage: Int,
    weight: Int,
    val magicDamage: Int
) : Weapon {
    override val damage = Require.Stat(damage, "Damage") atLeast 0
    override val weight = Require.Stat(weight, "Weight") atLeast 0
}
