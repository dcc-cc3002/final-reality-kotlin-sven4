package cl.uchile.dcc.finalreality.model.weapon

import java.util.Objects

/**
 * An axe class is a type of [CommonWeapon].
 *
 * @property name String
 *     The name of the axe.
 * @property damage Int
 *     The base damage done by the axe.
 * @property weight Int
 *     The weight of the axe.
 *
 * @constructor Creates an axe with a name, a base damage and speed.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
class Axe(
    name: String,
    damage: Int,
    weight: Int
) : CommonWeapon(name, damage, weight) {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Axe -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Axe::class, name, damage, weight)

    override fun toString() = "Axe { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight" +
        "} "
}
