package cl.uchile.dcc.finalreality.model.weapon

import java.util.Objects

/**
 * A staff class is a type of [MagicWeapon].
 *
 * @property name String
 *     The name of the staff.
 * @property damage Int
 *     The base damage done by the staff.
 * @property weight Int
 *     The weight of the staff.
 * @property magicDamage Int
 *     The magicDamage of the staff
 *
 * @constructor Creates a Staff with a name, a base damage and speed.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
class Staff(
    name: String,
    damage: Int,
    weight: Int,
    magicDamage: Int
) : MagicWeapon(name, damage, weight, magicDamage) {

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Staff -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        magicDamage != other.magicDamage -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Staff::class, name, damage, weight, magicDamage)

    override fun toString() = "Staff { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight, " +
        "magicDamage: $magicDamage " +
        "}"
}
